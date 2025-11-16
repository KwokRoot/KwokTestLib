package org.kwok.guava;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.base.Strings;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.openjdk.jol.info.GraphLayout;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 使用 guava TreeRangeMap 结构对IP段存储及查询，实现IP解析逻辑。
 * @author: Kwok
 * @date: 2025/8/27
 */
public class Test_Guava_RangeMap_Case01_IP_Parse {

    private static TreeRangeMap<BigInteger, String> rangeMap = TreeRangeMap.create();

    public static void load_ipv6(){
        //240e:0982:a303:0000:0000:0000:0000:0000, 240e:0982:a307:ffff:ffff:ffff:ffff:ffff, 中国电信-上海
        List<String> lines = FileUtil.readLines("ip_range_lib/ipv6.txt", "UTF-8");
        lines.forEach(x -> {
            List<String> lps = StrUtil.splitTrim(x, ",");
            String sip = lps.get(0);
            String eip = lps.get(1);
            String area = lps.get(2);
            rangeMap.put(Range.closed(NetUtil.ipv6ToBigInteger(sip), NetUtil.ipv6ToBigInteger(eip)), area);
        });
    }

    public static void load_ipv4(){
        // 219.158.113.127, 219.158.113.132, 中国联通-上海
        List<String> lines  = FileUtil.readLines("ip_range_lib/ipv4.txt", "UTF-8");
        lines.forEach(x -> {
            List<String> lps = StrUtil.splitTrim(x, ",");
            String sip = lps.get(0);
            String eip = lps.get(1);
            String area = lps.get(2);
            rangeMap.put(Range.closed(BigInteger.valueOf(NetUtil.ipv4ToLong(sip)), BigInteger.valueOf(NetUtil.ipv4ToLong(eip))), area);
        });
    }

    public static String parse_ip(String ipStr){
        if(Strings.isNullOrEmpty(ipStr)){
            return "-";
        }
        if (ipStr.contains(":")){
            return parse_ipv6(ipStr);
        }else {
            return parse_ipv4(ipStr);
        }
    }

    public static String parse_ipv4(String ipStr){
        return rangeMap.get(BigInteger.valueOf(NetUtil.ipv4ToLong(ipStr)));
    }

    public static String parse_ipv6(String ipStr){
        return rangeMap.get(NetUtil.ipv6ToBigInteger(ipStr));
    }

    public static void main(String[] args) {

        StopWatch sw = StopWatch.create("ip解析");

        sw.start("ipv6-lib导入");
        load_ipv6();
        System.out.println(rangeMap.span());
        sw.stop();

        sw.start("ipv4-lib导入");
        load_ipv4();
        System.out.println(rangeMap.span());
        sw.stop();

        // 获取对象占用内存大小
        System.out.println(String.format("占用空间: %s MB", ObjectSizeCalculator.getObjectSize(rangeMap) / 1000_000));
        // 获取对象及其引用对象占用内存大小（深堆）
        System.out.println(String.format("占用空间: %s MB", GraphLayout.parseInstance(rangeMap).totalSize() / 1000_000));

        sw.start("ip解析测试");
        System.out.println(parse_ip("183.193.26.80"));
        System.out.println(parse_ip("2a03:f80:852:151:236:20:7a:0"));
        System.out.println(parse_ip("0.0.0.0"));

        sw.stop();
        System.out.println(sw.prettyPrint(TimeUnit.MILLISECONDS));

    }

}
