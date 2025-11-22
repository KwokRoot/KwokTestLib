package testlib;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @description: 关于 java.util.Comparator 接口使用。
 * compare 方法返回值：
 * 正数：o1 - o2 > 0，排序时 o1 在后。
 * 负数：o1 - o2 < 0，排序时 o1 在前。
 * 0：o1 - o2 = 0，不交换位置。
 * 
 * @author: Kwok
 * @date: 2025/11/22
 */
public class Test_Sort_ComparatorInterface {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(6);
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(8);
        System.out.println(list);

        // list 排序使用 Comparator 接口。
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

        System.out.println(list);

        
        // Comparator接口，使用时间戳排序时的注意点
		LocalDateTime startDT = LocalDateTime.of(2008, 8, 8, 20, 0, 0);
		LocalDateTime endDT = LocalDateTime.of(2008, 9, 8, 20, 0, 0);
		System.out.println(endDT.toInstant(ZoneOffset.ofHours(8)).toEpochMilli() - startDT.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
		// 当时间相差 1个月时，比较大小时不能随手把返回值强转为 int，会溢出变为负值！！！
        System.out.println((int)(endDT.toInstant(ZoneOffset.ofHours(8)).toEpochMilli() - startDT.toInstant(ZoneOffset.ofHours(8)).toEpochMilli()));
        // Long 类型比较的正确方式。
        System.out.println(Long.compare(endDT.toInstant(ZoneOffset.ofHours(8)).toEpochMilli(), startDT.toInstant(ZoneOffset.ofHours(8)).toEpochMilli()));

        // Integer 类型最大值
        System.out.println(Integer.MAX_VALUE);
        // 24天就会越界
        System.out.println(Integer.MAX_VALUE / 1000 / 60 / 60 / 24);

    }

}
