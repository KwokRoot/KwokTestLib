package org.kwok.scriptengine.qlexpress;

import com.alibaba.qlexpress4.Express4Runner;
import com.alibaba.qlexpress4.InitOptions;
import com.alibaba.qlexpress4.QLOptions;
import com.alibaba.qlexpress4.QLResult;
import com.alibaba.qlexpress4.security.QLSecurityStrategy;
import org.kwok.scriptengine.obj.User;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: QLExpress 安全策略
 * @author: Kwok
 * @date: 2025/9/27
 */
public class Test_QLExpress_Security_Strategy {

    public static void main(String[] args) throws ReflectiveOperationException {

        // 对象访问白名单
        Set<Member> memberList = new HashSet<>();
        memberList.add(User.class.getMethod("getName"));
        memberList.add(User.class.getMethod("getAge"));

        InitOptions initOptions = InitOptions.builder()
                .securityStrategy(QLSecurityStrategy.whiteList(memberList))
                .traceExpression(true)
                .build();

        Express4Runner express4Runner = new Express4Runner(initOptions);
        QLOptions qlOptions = QLOptions.builder()
                .traceExpression(true)
                .build();

        Map<String, Object> context = new HashMap<>();
        User user = new User();
        user.setName("Kwok");
        user.setAge(18);
        context.put("obj", user);

        QLResult qlResult = express4Runner.execute("obj.name + ':' + obj.age", context, qlOptions);
        System.out.println(qlResult.getResult());
        System.out.println(qlResult.getExpressionTraces().get(0).toPrettyString(2));

    }

}
