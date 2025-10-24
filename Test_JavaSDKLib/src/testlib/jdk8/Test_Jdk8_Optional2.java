package testlib.jdk8;

import java.util.Optional;

/**
 * @description: Optional 链式调用
 * @author: Kwok
 * @date: 2025/10/24
 */
public class Test_Jdk8_Optional2 {

    public static void main(String[] args) {

        // // 测试一
        TestClass1 testClass1 = null;

        // // 测试二
        // TestClass1 testClass1 = new TestClass1();
        // testClass1.setTestClass2(null);

        // // 测试三
        // TestClass1 testClass1 = new TestClass1();
        // TestClass2 testClass2 = new TestClass2();
        // testClass1.setTestClass2(testClass2);
        // testClass2.setName(null);

        // // 测试四
        // TestClass1 testClass1 = new TestClass1();
        // TestClass2 testClass2 = new TestClass2();
        // testClass1.setTestClass2(testClass2);
        // testClass2.setName("");

        // 不使用 Optional 的方式获取多层实体的属性值
        String o = null;
        if (testClass1 != null) {
            if (testClass1.getTestClass2() != null) {
                o = testClass1.getTestClass2().getName();
            }
        }
        System.out.println(String.format("o: %s", o));

        String a = Optional.ofNullable(testClass1).map(TestClass1::getTestClass2).map(TestClass2::getName).orElse(null);
        String b = Optional.ofNullable(testClass1).map(TestClass1::getTestClass2).map(TestClass2::getName).orElse("默认");
        System.out.println(String.format("a: %s",  a));
        System.out.println(String.format("b: %s",  b));

        String c = null;
        try {
            c = Optional.ofNullable(testClass1).map(TestClass1::getTestClass2).map(TestClass2::getName).get();
        }catch (Exception e){
            System.out.println("注：使用 Optional.get() 当值不存在时会抛异常:" + e.getMessage());
        }
        System.out.println(String.format("c: %s",  c));

    }

    public static class TestClass1 {

        private String id;
        private String name;
        private TestClass2 testClass2;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public TestClass2 getTestClass2() {
            return testClass2;
        }

        public void setTestClass2(TestClass2 testClass2) {
            this.testClass2 = testClass2;
        }
        
    }

    public static class TestClass2 {

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
    }

}
