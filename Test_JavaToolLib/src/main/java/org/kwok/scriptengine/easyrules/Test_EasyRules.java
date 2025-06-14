package org.kwok.scriptengine.easyrules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;
import org.kwok.scriptengine.obj.User;

import java.io.FileReader;
import java.net.URL;

/**
 * @description:
 * @author: Kwok
 * @date: 2025/6/11
 */
public class Test_EasyRules {

    public static void main(String[] args) throws Exception {

        // 方式一：Builder 方式创建 Rule
        org.jeasy.rules.api.Rule weatherRule = new RuleBuilder()
                .name("weather rule")
                .description("if it rains then take an umbrella")
                // .when(facts -> facts.get("rain").equals(true))
                // .when(facts -> facts.get("test").equals(true))
                .when(facts -> facts.<User>get("obj").getAge() > 18)
                .then(facts -> System.out.println("It rains, take an umbrella!"))
                .build();


        // 方式二：配置文件方式创建 Rule
        // MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());
        // URL resource = Thread.currentThread().getContextClassLoader().getResource("easyrules/weather-rule.yml");
        // org.jeasy.rules.api.Rule weatherRule = ruleFactory.createRule(new FileReader(resource.getFile()));


        // 方式三：注解方式创建 Rule
        // WeatherRule weatherRule = new WeatherRule();

        // define facts
        Facts facts = new Facts();
        facts.put("rain", true);
        facts.put("obj", new User("张三", 20));
        // facts.put("test", true);

        // define rules
        Rules rules = new Rules();
        rules.register(weatherRule);

        // fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();

        rulesEngine.fire(rules, facts);

    }

    // 方式三：注解方式创建 Rule
    @Rule(name = "weather rule", description = "if it rains then take an umbrella")
    public static class WeatherRule {

        @Condition
        public boolean itRains(@Fact("rain") boolean rain, @Fact("test") boolean test, @Fact("obj")User user) {
            System.out.println(user.getAge());
            return rain && test;
        }

        @Action
        public void takeAnUmbrella() {
            System.out.println("It rains, take an umbrella!");
        }
    }

}
