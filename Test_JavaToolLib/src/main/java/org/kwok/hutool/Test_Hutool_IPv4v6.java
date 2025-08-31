package org.kwok.hutool;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.StrUtil;

import java.math.BigInteger;
import java.net.InetAddress;

/**
 * `cn.hutool.core.net.NetUtil` 工具对 IPv4、IPv6 的处理。
 * @author: Kwok
 * @date: 2025/8/26
 */
public class Test_Hutool_IPv4v6 {

    public static void main(String[] args) throws Exception {

        // IPv4 与 Long 类型相互转化
        System.out.println(StrUtil.format("{} {} {}", StrUtil.repeat("*", 9), "IPv4 与 Long 类型相互转化", StrUtil.repeat("*", 9)));

        System.out.println(NetUtil.ipv4ToLong("183.193.26.80"));
        System.out.println(NetUtil.longToIpv4(3082885712L));

        // IPv6 与 BigInteger 类型相互转化
        System.out.println(StrUtil.format("{} {} {}", StrUtil.repeat("*", 9), "IPv6 与 BigInteger 类型相互转化", StrUtil.repeat("*", 9)));

        System.out.println(NetUtil.ipv6ToBigInteger("2a03:f80:852:151:236:20:7a:0"));
        System.out.println(NetUtil.bigIntegerToIPv6(new BigInteger("55843467093465945958228287159665295360")));

        // JDK底层 InetAddress 与 BigInteger 相互转化
        // IPv4
        System.out.println(StrUtil.format("{} {} {}", StrUtil.repeat("*", 9), "JDK底层 InetAddress 与 BigInteger 相互转化", StrUtil.repeat("*", 9)));
        InetAddress inetAddressV4 = InetAddress.getByName("183.193.26.80");
        System.out.println(new BigInteger(1, inetAddressV4.getAddress()));

        // IPv6
        InetAddress inetAddressV6 = InetAddress.getByName("2a03:f80:852:151:236:20:7a:0");
        System.out.println(new BigInteger(1, inetAddressV6.getAddress()));

        // IPv6(128位) 拆分成 2个 Long 类型(64位) 转化
        System.out.println(StrUtil.format("{} {} {}", StrUtil.repeat("*", 9), "IPv6(128位) 拆分成 2个 Long 类型(64位) 转化", StrUtil.repeat("*", 9)));
        BigInteger ipv6_val = new BigInteger("3027280417092927825").shiftLeft(64).add(new BigInteger("159314974265180160"));
        System.out.println(ipv6_val);
        System.out.println(NetUtil.bigIntegerToIPv6(ipv6_val));

    }

}
