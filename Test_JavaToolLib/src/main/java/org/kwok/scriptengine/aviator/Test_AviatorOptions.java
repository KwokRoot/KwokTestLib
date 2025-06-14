package org.kwok.scriptengine.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.AviatorEvaluatorInstance;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Feature;

import java.util.Map;

import static com.googlecode.aviator.Options.NIL_WHEN_PROPERTY_NOT_FOUND;

/**
 * @description:
 * @author: Kwok
 * @date: 2025/4/30
 */
public class Test_AviatorOptions {

    public static void main(String[] args) {

        AviatorEvaluatorInstance aviatorEval = AviatorEvaluator.getInstance();
        aviatorEval.enableSandboxMode();
        aviatorEval.enableFeature(Feature.InternalVars);
        aviatorEval.setCachedExpressionByDefault(true);
        aviatorEval.setOption(NIL_WHEN_PROPERTY_NOT_FOUND, true);

        aviatorEval.compile("rule01", "a + b == 3", true);

        // 执行表达式
        Expression exp = aviatorEval.getCachedExpressionByKey("rule01");
        Map<String, Object> env = exp.newEnv("a", 1, "b", 2);
        boolean result = (Boolean) exp.execute(env);  // 返回 true
        System.out.println(result);

        // 内置部分特殊变量
        System.out.println(aviatorEval.execute("__exp__"));
        System.out.println(aviatorEval.execute("__env__"));
        System.out.println(aviatorEval.execute("__instance__"));
        System.out.println(aviatorEval.execute("__args__"));

        System.out.println(exp.getVariableNames());
        System.out.println(exp.getVariableFullNames());
        System.out.println(exp.getFunctionNames());
        System.out.println(exp);

    }

}
