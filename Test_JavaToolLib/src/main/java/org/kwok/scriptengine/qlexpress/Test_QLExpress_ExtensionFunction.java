package org.kwok.scriptengine.qlexpress;

import com.alibaba.qlexpress4.Express4Runner;
import com.alibaba.qlexpress4.InitOptions;
import com.alibaba.qlexpress4.QLOptions;
import com.alibaba.qlexpress4.QLResult;
import com.alibaba.qlexpress4.runtime.function.ExtensionFunction;
import com.alibaba.qlexpress4.security.QLSecurityStrategy;
import org.kwok.scriptengine.obj.User;

import java.lang.reflect.Member;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: QLExpress 自定义函数及操作符
 * @author: Kwok
 * @date: 2025/9/27
 */
public class Test_QLExpress_ExtensionFunction {

    public static void main(String[] args) throws ReflectiveOperationException {

        // 对象访问白名单
        Set<Member> memberList = new HashSet<>();
        memberList.add(User.class.getMethod("getName"));
        memberList.add(User.class.getMethod("getAge"));

        InitOptions initOptions = InitOptions.builder()
                .securityStrategy(QLSecurityStrategy.whiteList(memberList))
                .addExtensionFunctions(Collections.singletonList(helloFunction))
                .addExtensionFunctions(Collections.singletonList(matcherFunction))
                .build();

        Express4Runner express4Runner = new Express4Runner(initOptions);
        QLOptions qlOptions = QLOptions.builder()
                .build();

        Map<String, Object> context = new HashMap<>();
        User user = new User();
        user.setName("Kwok");
        user.setAge(18);
        context.put("obj", user);

        QLResult qlResult = express4Runner.execute("obj.name + ':' + (obj.age + 2)", context, qlOptions);
        System.out.println(qlResult.getResult());

        // 自定义函数实现
        System.out.println(express4Runner.execute("'Kwok'.hello()", Collections.emptyMap(), qlOptions).getResult());

        // `like %` 通配语法
        System.out.println(express4Runner.execute("obj.name like 'Kw%'", context, qlOptions).getResult());
        System.out.println(express4Runner.execute("obj.name like '%wo%'", context, qlOptions).getResult());

        // 官方目前没提供正则，通过自定义函数实现。
        System.out.println(express4Runner.execute("'Kw.*'.matcher(obj.name) && obj.age > 16", context, qlOptions).getResult());

        // 自定义操作符
        express4Runner.addOperatorBiFunction("=~", (var, regEx) -> {
            if (var == null || regEx == null){
                return false;
            }
            String patternStr = (String)regEx;
            String varStr = (String)var;
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(varStr);
            return matcher.matches();
        });
        System.out.println(express4Runner.execute("obj.name =~ 'Kw.*'", context, qlOptions).getResult());

        // 自定义函数
        express4Runner.addVarArgsFunction("regEx",
                params -> {
                    if (params == null || params.length < 2){
                        return false;
                    }
                    String varStr = (String)params[0];
                    String patternStr = (String)params[1];
                    Pattern pattern = Pattern.compile(patternStr);
                    Matcher matcher = pattern.matcher(varStr);
                    return matcher.matches();
        });
        System.out.println(express4Runner.execute("regEx(obj.name, '[kK]w.*')", context, qlOptions).getResult());
    }

    // 自定义扩展函数示例
    static ExtensionFunction helloFunction = new ExtensionFunction() {
        @Override
        public Class<?>[] getParameterTypes() {
            return new Class[0];
        }

        @Override
        public String getName() {
            return "hello";
        }

        @Override
        public Class<?> getDeclaringClass() {
            return String.class;
        }

        @Override
        public Object invoke(Object obj, Object[] args) {
            String varStr = (String)obj;
            return "Hello, " + varStr;
        }
    };

    // 自定义 正则匹配 拓展函数示例
    static ExtensionFunction matcherFunction = new ExtensionFunction() {
        @Override
        public Class<?>[] getParameterTypes() {
            return new Class[]{String.class};
        }

        @Override
        public String getName() {
            return "matcher";
        }

        @Override
        public Class<?> getDeclaringClass() {
            return String.class;
        }

        @Override
        public Object invoke(Object obj, Object[] args) {
            String patternStr = (String)obj;
            String varStr = (String) args[0];
            if (varStr == null) {
                return false;
            }
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(varStr);
            return matcher.matches();
        }

    };

}
