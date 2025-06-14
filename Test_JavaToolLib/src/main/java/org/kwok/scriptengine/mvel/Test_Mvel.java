package org.kwok.scriptengine.mvel;

import org.kwok.scriptengine.obj.User;
import org.mvel2.MVEL;
import org.mvel2.templates.CompiledTemplate;
import org.mvel2.templates.TemplateCompiler;
import org.mvel2.templates.TemplateRuntime;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Kwok
 * @date: 2025/6/12
 */
public class Test_Mvel {

    public static void main(String[] args) {


        Map<String, Object> env = new HashMap<>();
        env.put("name", "Michael");
        env.put("a", 1);
        env.put("b", 2);

        User user = new User("张三", 20);
        env.put("obj", user);

        // MVEL
        System.out.println(MVEL.eval("a + b", env));
        System.out.println(MVEL.eval("a > b", env));
        System.out.println(MVEL.eval("obj.name", env));
        System.out.println(MVEL.eval("obj.age > 10", env));

        // MVEL2.0 `@`流程控制符
        String template = "Hello, my name is @{name.toUpperCase()}, @if{obj.age < 18}少年@else{}青年@end{}";

        String output = (String) TemplateRuntime.eval(template, env);
        System.out.println(output);

        // 方式2：先编译
        CompiledTemplate compiledTemplate = TemplateCompiler.compileTemplate(template);
        String output2 = (String) TemplateRuntime.execute(compiledTemplate, env);
        System.out.println(output2);

    }

}
