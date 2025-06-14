package org.kwok.scriptengine.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

/**
 * @description:
 * @author: Kwok
 * @date: 2025/4/30
 */
public class Test_AviatorScript {

    public static void main(final String[] args) throws Exception {

        // Compile the script into a Expression instance.
        Expression exp = AviatorEvaluator.getInstance().compileScript("aviator/hello.av");
        // Run the exprssion.
        exp.execute();
        System.out.println(exp.getSourceFile());

    }

}
