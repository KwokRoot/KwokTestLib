package org.kwok.scriptengine.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.kwok.scriptengine.obj.User;

import java.util.HashMap;
import java.util.Map;

import static com.googlecode.aviator.Options.ENABLE_PROPERTY_SYNTAX_SUGAR;
import static com.googlecode.aviator.Options.NIL_WHEN_PROPERTY_NOT_FOUND;

/**
 * @description:
 * @author: Kwok
 * @date: 2025/4/30
 */
public class Test_Aviator {

    public static void main(String[] args) {

        // 是否启用变量访问的语法糖，默认情况下 Aviator 会通过 commons-beantuils 反射访问类似 a.b.c 这样的嵌套 JavaBean 变量，或者 #list.[0].name 这样的数组（链表）中的元素。
        // 默认为 true 开启。
        AviatorEvaluator.setOption(ENABLE_PROPERTY_SYNTAX_SUGAR, true);
        // 在启用变量访问糖的情况下，如果反射调用失败，默认的行为将抛出运行时异常，而不是返回 null。
        // 默认为 false 关闭。设置为 true，将不抛出异常，而是返回 null。
        AviatorEvaluator.setOption(NIL_WHEN_PROPERTY_NOT_FOUND, true);
        Expression exp = AviatorEvaluator.compile("obj.age > 18 && obj.name =~ /张.*/");
        // 准备上下文环境
        Map<String, Object> env = new HashMap<>();

        User user1 = new User("张三", 20);
        User user2 = new User("李四", 17);
        env.put("obj", user1);

        // 执行表达式
        boolean result = (Boolean) exp.execute(env);  // 返回 true
        System.out.println(result);

    }

}
