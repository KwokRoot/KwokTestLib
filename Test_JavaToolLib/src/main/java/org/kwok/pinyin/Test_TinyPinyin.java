package org.kwok.pinyin;

import com.github.promeg.pinyinhelper.Pinyin;

/**
 * 该练习是对 com.github.promeg:tinypinyin 的练习。
 * @date: 2022年12月30日
 * @author Kwok
 */
public class Test_TinyPinyin {

	public static void main(String[] args) {
		
		System.out.println(Pinyin.isChinese('为'));

		System.out.println(Pinyin.toPinyin('为'));
		
		System.out.println(Pinyin.toPinyin("你好", ","));
		
	}

}
