package org.kwok.scriptengine.jexl;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.jexl3.introspection.JexlPermissions;
import org.kwok.scriptengine.obj.User;

/**
 * @description:
 * @author: Kwok
 * @date: 2025/6/10
 */
public class Test_Jexl {

    public static void main(String[] args) {

        // 创建 JexlEngine 对象
        JexlEngine jexl = new JexlBuilder()
                .cache(1000)
                .strict(false)
                .permissions(JexlPermissions.parse("org.kwok.*"))
                // .silent(true)
                .create();

        // 定义变量和表达式
        JexlContext env = new MapContext();
        env.set("a", 10);
        env.set("b", 20);
        User user = new User("张三", 20);
        env.set("obj", user);

        // 定义表达式字符串
        String expression1 = "a + b + c";
        String expression2 = "(a > b) ? 'a is greater' : 'b is greater'";
        String expression3 = "obj.age > 10";
        String expression = "obj.age";

        // 解析和执行表达式
        JexlExpression exp1 = jexl.createExpression(expression1);
        JexlExpression exp2 = jexl.createExpression(expression2);
        JexlExpression exp3 = jexl.createExpression(expression3);
        JexlExpression exp = jexl.createExpression(expression);

        // 计算结果
        Integer result1 = (Integer) exp1.evaluate(env);
        String result2 = (String) exp2.evaluate(env);
        Boolean result3 = (Boolean)exp3.evaluate(env);
        Object result = exp.evaluate(env);

        // 输出结果
        System.out.println("Result of expression1: " + result1); // 输出：30
        System.out.println("Result of expression2: " + result2); // 输出：b is greater
        System.out.println("Result of expression3: " + result3); // 输出：false
        System.out.println(result);

    }

}
