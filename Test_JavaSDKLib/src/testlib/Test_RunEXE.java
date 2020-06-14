package testlib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 该练习是 Java 下运行操作系统命令及程序的练习。
 * 使用 Runtime.getRuntime().exec(String...)方法与 ProcessBuilder 类运行命令或启动程序(即创建操作系统进程)。
 * @author Kwok
 */
public class Test_RunEXE {

	public static void main(String[] args) throws Exception {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		/* 运行 DOS 命令 */
		
		Process process = Runtime.getRuntime().exec("cmd /c " + "ipconfig/all"); //通过 cmd 程序执行 DOS 命令。  
		
		//读取屏幕输出。
		InputStream is=process.getInputStream();
		System.out.println(Is2Str(is));
		
        int exit = process.exitValue();    
        if (exit != 0) {    
            System.err.println("错误结束！");    
        } 
        
        
        System.out.println("------------------------------ 操作 2 ------------------------------");
        
        ProcessBuilder pb = new ProcessBuilder("cmd","/c","dir");
        Process p = pb.start();
        is=process.getInputStream();
		System.out.println(Is2Str(p.getInputStream()));
		
		
		System.out.println("------------------------------ 操作 3 ------------------------------");
		/* 启动本机程序(创建操作系统进程) */
		
		String cmdStr = "D:\\Program Files (x86)\\Tencent\\QQ\\Bin\\QQScLauncher.exe"; //待执行的程序路径
		
		System.out.println("--------------- 3-1 ---------------");
		ProcessBuilder pb3 = new ProcessBuilder(cmdStr);
        pb3.start();
        System.out.println("已启动执行");
        
        System.out.println("--------------- 3-2 ---------------");
        Runtime.getRuntime().exec(cmdStr);
        System.out.println("已启动执行");
	}
	
	/* InputStream 转 String */
	public static String Is2Str(InputStream is) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"GBK"));  
        StringBuffer sb=new StringBuffer();
		String line;  
        while ((line = br.readLine()) != null) {  
            sb.append(line + "\n");
        }
		return sb.toString();
	}

}
