package org.kwok.guava;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.hash.Hashing;

public class Test_Guava_Hash {

	public static void main(String[] args) throws Exception {

		// 计算MD5值，结果保存为长整形或字符串类型。
		System.out.println(Hashing.md5().hashBytes("nihao".getBytes()).asLong());
		// 结果：-51900553098867687

		System.out.println(Strings.repeat("*", 36));

		System.out.println(Hashing.md5().hashBytes("nihao".getBytes()).toString());
		System.out.println(Hashing.md5().hashString("nihao", Charsets.UTF_8));
		System.out.println(Hashing.md5().newHasher().putString("nihao", Charsets.UTF_8).hash());
		// 结果：194ce5d0b89c47ff6b30bfb491f9dc26

		System.out.println(Strings.repeat("*", 36));

		// 由于 md5、sha1 不安全，推荐 sha256+
		System.out.println(Hashing.sha256().hashBytes("nihao".getBytes()).toString());
		System.out.println(Hashing.sha256().newHasher().putString("nihao", Charsets.UTF_8).hash());
		// 结果：5e793a946e316b581728ec808ce78584719cd23f824b2ac028042f87caf28554

		System.out.println(Strings.repeat("*", 36));

		// 类型影响 md5 计算结果
		System.out.println(Hashing.md5().hashString("123456", Charsets.UTF_8));
		// 结果：e10adc3949ba59abbe56e057f20f883e
		System.out.println(Hashing.md5().hashInt(123456));
		// 结果：1427562bb29f88a1161590b76398ab72

	}

}
