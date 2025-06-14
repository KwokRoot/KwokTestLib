package org.kwok.scriptengine.hutool;

import cn.hutool.core.map.MapUtil;
import cn.hutool.script.ScriptUtil;
import org.kwok.scriptengine.obj.User;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

/**
 * @description:
 * @author: Kwok
 * @date: 2025/6/11
 */
public class Test_Hutool {

    public static void main(String[] args) throws ScriptException {

        // JDK 提供 NashornScriptEngine(js)
        // ScriptEngine engine = ScriptUtil.getJsEngine();
        // jython-standalone 提供
        ScriptEngine engine = ScriptUtil.getPythonEngine();

        SimpleBindings sb = new SimpleBindings();
        sb.putAll(MapUtil.<String, Object>builder()
                .put("a", 1)
                .put("b", 2)
                .put("obj", new User("张三", 20))
                .build());

        Object eval = engine.eval("a + b + obj.age", sb);
        System.out.println(eval);
    }


}
