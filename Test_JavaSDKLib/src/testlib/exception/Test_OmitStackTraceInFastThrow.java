package testlib.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 问题：异常不打印堆栈信息，只打印 `java.lang.NullPointerException`。
 * 原因：
 * JVM 默认只对几个特定类型异常开启了 Fast Throw 优化，这些异常包括:
    NullPointerException
    ArithmeticException
    ArrayIndexOutOfBoundsException
    ArrayStoreException
    ClassCastException
    
 * JVM 参数：`-XX:-OmitStackTraceInFastThrow`。
 */
public class Test_OmitStackTraceInFastThrow {

    public static void main(String[] args) throws InterruptedException {
        NPEThread npeThread = new NPEThread();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            executorService.execute(npeThread);
            // 稍微 sleep 一下, 为了不要让异常抛出太快, 导致控制台输出太快, 把有异常栈信息冲掉, 只留下fast throw方式抛出的异常。
            // 测试时，NPEThread-6667+ 开始出现 fast throw 方式抛出的异常。
            Thread.sleep(2);
        }
    }
    
}

class NPEThread extends Thread {
    private static int count = 0;
    @Override
    public void run() {
        try{
            System.out.println(this.getClass().getSimpleName()+"-"+(++count));
            String str = null;
            // 空指针 NPE
            System.out.println(str.length());
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}
