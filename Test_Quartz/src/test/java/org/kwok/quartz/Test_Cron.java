package org.kwok.quartz;

import java.text.ParseException;
import java.util.Locale;

import org.quartz.CronExpression;

import com.cronutils.descriptor.CronDescriptor;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.parser.CronParser;

import net.redhogs.cronparser.CronExpressionDescriptor;
import net.redhogs.cronparser.DescriptionTypeEnum;

public class Test_Cron {

	public static void main(String[] args) throws ParseException {
		CronExpression cronExpression = new CronExpression("* */5 * * * ?");
		System.out.println(cronExpression.getExpressionSummary());
		
		CronDefinition cronDefinition= CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ);
		CronParser cronParser = new CronParser(cronDefinition);
		
		CronDescriptor cronDescriptor = CronDescriptor.instance(Locale.CHINA);
		System.out.println(cronDescriptor.describe(cronParser.parse("* */5 */5 */5 * ?")));
		
		System.out.println(CronExpressionDescriptor.getDescription(DescriptionTypeEnum.HOURS, "* */5 */5 */5 * ?", Locale.CHINA));
		
	}
	
}
