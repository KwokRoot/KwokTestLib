package org.kwok.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

/**
 * @description: JOL（Java Object Layout）是 OpenJDK 提供的工具。用于分析 Java 对象在 JVM 中的内存布局、字段顺序、对齐方式及对象大小。
 * @author: Kwok
 * @date: 2025/11/16
 */
public class Test_JOL{

    public static void main(String[] args) {
        // 创建对象
        MyClass obj = new MyClass();

        // 浅层内存占用（仅当前对象）
        System.out.println(VM.current().sizeOf(obj));

        // 深度内存占用（对象+引用对象）
        System.out.println(GraphLayout.parseInstance(obj).totalSize());

        // 查看类的内存布局
        /* 注：
        1、静态变量（static字段）属于类元数据的一部分，存储在 方法区（Metaspace） 中，而非对象实例的内存布局中。
        2、JOL 的 ClassLayout 主要用于解析对象实例的内存结构（包括对象头、实例字段、对齐填充），而静态变量不占用对象实例的内存空间。
        3、固头信息中没有静态变量的展示。*/
        System.out.println(ClassLayout.parseClass(MyClass.class).toPrintable());

        // 打印对象内存布局
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        // 分析同步锁信息
        synchronized (obj) {
            System.out.println("Locked state:");
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }

    }

    static class MyClass {
        static int v = 369;
        int a;
        long b;
        String c;
    }

}
