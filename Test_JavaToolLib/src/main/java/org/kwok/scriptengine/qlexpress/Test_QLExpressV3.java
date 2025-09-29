package org.kwok.scriptengine.qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.kwok.scriptengine.obj.User;

/**
 * 注：`QLExpress` V3、V4 无论从文档完整度、源码注释，执行异常的处理，脚本执行安全策略配置 等方面都比不上脚本引擎 `Aviator`。
 * @author: Kwok
 * @date: 2025/9/29
 */
public class Test_QLExpressV3 {

    public static void main(String[] args) throws Exception {

        ExpressRunner expressRunner = new ExpressRunner();

        User user = new User();
        user.setName("Kwok");
        user.setAge(18);

        DefaultContext<String, Object> context = new DefaultContext();
        context.put("obj", user);
        context.put("a", 3);
        context.put("b", 6);
        context.put("topic", "log_sys_no");

        Object result = expressRunner.execute("a * b", context, null, false, false);
        System.out.println(result);

        result = expressRunner.execute("obj.name + ' : ' + obj.age + '-' + obj.num", context, null, false, true);
        System.out.println(result);

        result = expressRunner.execute("topic like 'log_%'", context, null, true, true);
        System.out.println(result);

    }

}
