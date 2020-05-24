package testlib.base;

import java.util.UUID;

/**
 * 该练习是运用 java.util.UUID 产生32位(8-4-4-4-12) 16进制数，即 128位 2进制的通用唯一标识符。
 * 实际中常使用 UUID.randomUUID().toString().replace("-", "") 方式生成32位十六进制随机码字符串。
 * @author Kwok
 */
public class Test_UUID {

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		System.out.println(uuid.getMostSignificantBits());  // 返回此 UUID 的 128 位值中的最高有效 64 位。
		System.out.println(uuid.getLeastSignificantBits()); // 返回此 UUID 的 128 位值中的最低有效 64 位。

		System.out.println("------------------------------ 操作 3 ------------------------------");
		UUID uuid21 = UUID.nameUUIDFromBytes("Hello123".getBytes());
		UUID uuid22 = UUID.nameUUIDFromBytes("Hello123".getBytes());
		System.out.println(uuid21.version());  // 返回值 3 表示是基于名称的 UUID。 
		System.out.println(uuid21.compareTo(uuid22));  // 返回值 -1、0  或 1 分别表示 UUID 小于、等于或大于。
		System.out.println(uuid21);
		System.out.println(uuid22);

		System.out.println("------------------------------ 操作 4 ------------------------------");

		/* 实际中常用该种方式生成随机码 */
		String str = uuid.toString().replace("-", "");
		System.out.println(str);

		System.out.println("------------------------------ 操作 5 ------------------------------");
		/* 验证 UUID 表示一个 128 位的通用唯一标识符。*/
		String s = hexStr2binStr(str);
		System.out.println(s);
		System.out.println(s.length());
		
	}
	
	
	/* 十六进制字符串转化为二进制字符串 */
	public static String hexStr2binStr(String hexStr) {

		if (hexStr == null || hexStr.equals(""))
			return null;
		StringBuffer sb = new StringBuffer();
		int len = hexStr.length();
		String temp;
		for (int i = 0; i < len; i++) {
			temp = "0000" + Integer.toBinaryString(Integer.parseInt(hexStr.substring(i, i + 1), 16));
			sb.append(temp.substring(temp.length() - 4));
		}
		return sb.toString();

	}
}