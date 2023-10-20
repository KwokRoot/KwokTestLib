package org.kwok.jython;

import org.python.util.PythonInterpreter;

public class Test_JPython {

	public static void main(String[] args) {

		//创建 Python 解释器
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.setOut(System.err);
        
        //执行 Python 语句、Python 文件
        interpreter.exec("a = 'helloworld.'");
        interpreter.execfile(Test_JPython.class.getResource("test_python.py").getPath());
		
        //关闭 Python 解释器
        interpreter.close();
	}

}
