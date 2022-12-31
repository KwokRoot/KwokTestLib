package org.kwok.pinyin;

import cn.hutool.extra.pinyin.PinyinEngine;
import cn.hutool.extra.pinyin.PinyinUtil;
import cn.hutool.extra.pinyin.engine.jpinyin.JPinyinEngine;

/**
 * 该练习是 Hutool 汉字 转 Pinyin 的练习。
 * @date: 2022年12月30日
 * @author Kwok
 */
public class Test_Hutool_PinyinUtil {

	public static void main(String[] args) {
		
		System.out.println(PinyinUtil.getPinyin("你好", ""));
		System.out.println(PinyinUtil.getFirstLetter("你好", ""));
		
		
		PinyinEngine engine = new JPinyinEngine();
		System.out.println(engine.getPinyin("你好Hello", ","));

		
	}

}
