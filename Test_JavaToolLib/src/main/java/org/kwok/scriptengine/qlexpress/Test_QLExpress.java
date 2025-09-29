package org.kwok.scriptengine.qlexpress;

import com.alibaba.qlexpress4.Express4Runner;
import com.alibaba.qlexpress4.InitOptions;
import com.alibaba.qlexpress4.QLOptions;
import com.alibaba.qlexpress4.QLResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: QLExpress 基础使用
 * 注：`QLExpress` V3、V4 无论从文档完整度、源码注释，执行异常的处理，脚本执行安全策略配置 等方面都比不上脚本引擎 `Aviator`。
 * @author: Kwok
 * @date: 2025/9/27
 */
public class Test_QLExpress {

    public static void main(String[] args) throws ReflectiveOperationException {

        Express4Runner express4Runner = new Express4Runner(InitOptions.DEFAULT_OPTIONS);

        Map<String, Object> context = new HashMap<>();
        context.put("a", 1);
        context.put("b", 2);
        context.put("c", 3);

        System.out.println(express4Runner.execute("a + b * c", context, QLOptions.DEFAULT_OPTIONS));

        InitOptions initOptions = InitOptions.builder()
                .traceExpression(true)
                .build();

        express4Runner = new Express4Runner(initOptions);
        QLOptions qlOptions = QLOptions.builder()
                .cache(true)
                .traceExpression(true)
                .build();

        // 规则引擎使用场景示例
        double score = 88.8;
        context.put("score", score);
        if (score > 90) {
            System.out.println("优秀");
        } else if (score > 60) {
            System.out.println("合格");
        } else {
            System.out.println("不合格");
        }

        QLResult qlResult = express4Runner.execute("if (score > 90){return '优秀'; }else if (score > 60) {return '合格'; }else {return '不合格'; }", context, qlOptions);
        System.out.println(qlResult.getResult());

        // 规则执行情况链路追踪
        System.out.println(qlResult.getExpressionTraces().get(0).toPrettyString(2));

    }

}
