package testlib.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 流匹配计算：stream().anyMatch()、stream().allMatch()、stream().noneMatch() 
 * 
 * @author Kwok
 * 2025-06-14
 */
public class Test_Stream_Match {

    public static void main(String[] args) {

        List<Tuple2> tupleList = Arrays.asList(
                new Tuple2(true, 1L),
                new Tuple2(true, 2L),
                new Tuple2(true, 3L),
                new Tuple2(false, 4L),
                new Tuple2(false, 5L)
        );

        // 列表为空，默认值
        // List<Tuple2> testList = Arrays.asList();
        
        List<Tuple2> testList = tupleList;
        
        System.out.println("--------- anyMatch ---------");
        // 有一个匹配返回 true，校验存在性，注：短路操作，空流返回 false。
        boolean b1 = testList.stream().anyMatch(x -> {
            System.out.println(x);
            return x.getStatus() && x.getExpire_time() >= 5;
        });
        System.out.println(b1);

        // 都匹配返回 true，校验完整性，注：短路操作，空流返回 true。
        System.out.println("--------- allMatch ---------");
        boolean b2 = testList.stream().allMatch(x -> {
            System.out.println(x);
            return x.getStatus() && x.getExpire_time() <= 5;
        });
        System.out.println(b2);

        // 都不匹配返回 true，校验完整性，注：短路操作，空流返回 true。
        System.out.println("--------- noneMatch ---------");
        boolean b3 = testList.stream().noneMatch(x -> {
            System.out.println(x);
            return x.getStatus() && x.getExpire_time() >= 5;
        });
        System.out.println(b3);

    }

    static class Tuple2 {

        private Boolean status;
        private Long expire_time;

        public Tuple2(Boolean status, Long expire_time) {
            this.status = status;
            this.expire_time = expire_time;
        }

        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }

        public Long getExpire_time() {
            return expire_time;
        }

        public void setExpire_time(Long expire_time) {
            this.expire_time = expire_time;
        }

        @Override
        public String toString() {
            return "Tuple2{" +
                    "status=" + status +
                    ", expire_time=" + expire_time +
                    '}';
        }
        
    }

}
