package org.kwok.guava;

import com.google.common.base.Strings;
import com.google.common.collect.BoundType;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;

/**
 * TreeRangeMap<K extends Comparable, V> Key 支持 Integer、Long、BigInteger 等类型，例如 IP段解析等
 * @author: Kwok
 * @date: 2025/8/27
 */
public class Test_Guava_RangeMap {

    public static void main(String[] args) {

        TreeRangeMap<Integer, String> rangeMap = TreeRangeMap.create();

        rangeMap.put(Range.closedOpen(1, 5), "A");
        rangeMap.put(Range.open(7, 12), "B");
        rangeMap.put(Range.closed(10, 30), "C");

        System.out.println(rangeMap.asMapOfRanges());
        System.out.println(rangeMap.asDescendingMapOfRanges());

        System.out.println(rangeMap.get(8));
        System.out.println(rangeMap.get(10));
        System.out.println(rangeMap.get(11));

        System.out.println(rangeMap.getEntry(10));

        System.out.println(Strings.repeat("*", 18));

        System.out.println(rangeMap.subRangeMap(Range.range(5, BoundType.CLOSED, 10, BoundType.CLOSED)).asMapOfRanges());

        rangeMap.subRangeMap(Range.closed(5, 18))
                .asMapOfRanges()
                .forEach((range, value) -> System.out.println(range + " → " + value));

        System.out.println(Strings.repeat("*", 18));
        System.out.println(rangeMap.asMapOfRanges());

        System.out.println(Strings.repeat("*", 18));
        System.out.println(rangeMap.span());

    }

}
