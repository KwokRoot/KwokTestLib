package org.kwok.calcite;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.calcite.adapter.csv.CsvSchema;
import org.apache.calcite.adapter.csv.CsvTable;
import org.apache.calcite.adapter.csv.CsvTable.Flavor;
import org.apache.calcite.adapter.csv.CsvTableFactory;
import org.apache.calcite.config.CalciteConnectionConfigImpl;
import org.apache.calcite.config.CalciteConnectionProperty;
import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.plan.ConventionTraitDef;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.plan.RelOptUtil;
import org.apache.calcite.plan.hep.HepPlanner;
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.apache.calcite.prepare.CalciteCatalogReader;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.rel.rules.CoreRules;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.SqlExplainFormat;
import org.apache.calcite.sql.SqlExplainLevel;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.validate.SqlValidator;
import org.apache.calcite.sql.validate.SqlValidatorUtil;
import org.apache.calcite.sql2rel.SqlToRelConverter;
import org.apache.calcite.sql2rel.StandardConvertletTable;
import org.apache.calcite.tools.Frameworks;

/*
<!-- Apache Calcite -->
<dependency>
	<groupId>org.apache.calcite</groupId>
	<artifactId>calcite-core</artifactId>
	<version>1.36.0</version>
</dependency>

<dependency>
	<groupId>org.apache.calcite</groupId>
	<artifactId>calcite-example-csv</artifactId>
	<version>1.21.0</version>
</dependency>
<!-- Apache Calcite END -->
*/

/**
 * @Description: Apache Calcite 是一个动态数据管理框架，提供了：SQL 解析、SQL 校验、SQL 查询优化、SQL 生成以及数据连接查询等典型数据库管理功能。
 * @date: 2024年3月26日
 * @author guohao
 */
public class Test_Calcite {

	public static void main(String[] args) throws SqlParseException {

		SchemaPlus rootSchema = Frameworks.createRootSchema(true);
		String csvPath = Test_Calcite.class.getResource("").getPath();
		System.out.println(csvPath);
		CsvSchema csvSchema = new CsvSchema(new File(csvPath), Flavor.SCANNABLE);

//		CsvTableFactory csvTableFactory = new CsvTableFactory();
//		Map<String, Object> operand = new HashMap<>();
//		operand.put("file", authorPath);
//		operand.put("flavor", "scannable");
//		CsvTable aC = csvTableFactory.create(rootSchema, "author", operand, null);
//		CsvTableFactory csvTableFactoryB = new CsvTableFactory();
//		Map<String, Object> operandB = new HashMap<>();
//		operandB.put("file", bookPath);
//		operandB.put("flavor", "scannable");
//		CsvTable bC = csvTableFactoryB.create(rootSchema, "book", operandB, null);

		rootSchema.add("orders", csvSchema.getTable("orders"));
		rootSchema.add("consumers", csvSchema.getTable("consumers"));

		String sql = "SELECT o.id, o.goods, o.price, o.amount, c.firstname, c.lastname FROM orders AS o LEFT OUTER JOIN consumers c ON o.user_id = c.id WHERE o.amount > 30 ORDER BY o.id LIMIT 5";
		SqlParser.Config config = SqlParser.configBuilder().setCaseSensitive(false).build();
		SqlParser parser = SqlParser.create(sql, config);
		SqlNode sqlNodeParsed = parser.parseQuery();
		System.out.println("[parsed sqlNode]");
		System.out.println(sqlNodeParsed);

		JavaTypeFactoryImpl sqlTypeFactory = new JavaTypeFactoryImpl();
		Properties properties = new Properties();
		properties.setProperty(CalciteConnectionProperty.CASE_SENSITIVE.camelName(), "false");

		// reader 接收 schema，用于检测字段名、字段类型、表名等是否存在和一致
		CalciteCatalogReader catalogReader = new CalciteCatalogReader(CalciteSchema.from(rootSchema),
				CalciteSchema.from(rootSchema).path(null), sqlTypeFactory, new CalciteConnectionConfigImpl(properties));

		// 简单示例，大部分参数采用默认值即可
		SqlValidator validator = SqlValidatorUtil.newValidator(SqlStdOperatorTable.instance(), catalogReader,
				sqlTypeFactory, SqlValidator.Config.DEFAULT);

		// validate: SqlNode -> SqlNode
		SqlNode sqlNodeValidated = validator.validate(sqlNodeParsed);
		System.out.println();
		System.out.println("[validated sqlNode]");
		System.out.println(sqlNodeValidated);

		RexBuilder rexBuilder = new RexBuilder(sqlTypeFactory);
		HepProgramBuilder hepProgramBuilder = new HepProgramBuilder();
		hepProgramBuilder.addRuleInstance(CoreRules.FILTER_INTO_JOIN);

		HepPlanner hepPlanner = new HepPlanner(hepProgramBuilder.build());
		hepPlanner.addRelTraitDef(ConventionTraitDef.INSTANCE);

		RelOptCluster relOptCluster = RelOptCluster.create(hepPlanner, rexBuilder);
		SqlToRelConverter sqlToRelConverter = new SqlToRelConverter(
				new RelOptTable.ViewExpander() {
					@Override
					public RelRoot expandView(RelDataType rowType, String queryString, List<String> schemaPath,
							List<String> viewPath) {
						return null;
					}
				}, validator, catalogReader, relOptCluster,
				
				StandardConvertletTable.INSTANCE, SqlToRelConverter.config());
		RelRoot logicalPlan = sqlToRelConverter.convertQuery(sqlNodeValidated, false, true);

		System.out.println();
		System.out.println(RelOptUtil.dumpPlan("[Logical plan]", logicalPlan.rel, SqlExplainFormat.TEXT,
				SqlExplainLevel.NON_COST_ATTRIBUTES));

		hepPlanner.setRoot(logicalPlan.rel);
		RelNode phyPlan = hepPlanner.findBestExp();
		System.out.println(RelOptUtil.dumpPlan("[Physical plan]", phyPlan, SqlExplainFormat.TEXT,
				SqlExplainLevel.NON_COST_ATTRIBUTES));

	}

}
