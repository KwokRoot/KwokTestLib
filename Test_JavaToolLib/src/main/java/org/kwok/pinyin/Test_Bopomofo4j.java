package org.kwok.pinyin;

import com.rnkrsoft.bopomofo4j.Bopomofo4j;
import com.rnkrsoft.bopomofo4j.ToneType;

/**
 * 该练习是对 com.rnkrsoft.bopomofo4j:bopomofo4j 的练习。
 * @date: 2022年12月30日
 * @author Kwok
 */
public class Test_Bopomofo4j {

	public static void main(String[] args) {

		// 利用本地 Jar 包
		Bopomofo4j.local();
		
		// 汉语句子 -> 声母音调拼音
		String v1 = Bopomofo4j.pinyin("中国人！", ToneType.WITH_VOWEL_TONE, false, false, " ");
		System.out.println(v1);//控制台输出 zhōng guó rén！

		// 汉语句子 -> 数字音调拼音
		String v2 = Bopomofo4j.pinyin("患难与共的兄弟！！", ToneType.WITH_NUMBER_TONE, false, false, " ");
		System.out.println(v2);//控制台输出 huan4 nan4 yu3 gong4 de0 xiong1 di4！！

		// 汉语句子 -> 无音调拼音
		String v3 = Bopomofo4j.pinyin("this is a pinyin library!这是一个汉语拼音库！！", 2, false, false, " ");
		System.out.println(v3);//控制台输出 this is a pinyin library! zhe shi yi ge han yu pin yin ku！！

		// 繁体 -> 简体
		String v4 = Bopomofo4j.cht2chs("APM（Actions Per Minute）是一個在遊戲");
		System.out.println(v4);//APM（Actions Per Minute）是一个在游戏

		// 简体 -> 繁体
		String v5 = Bopomofo4j.chs2cht("APM（Actions Per Minute）是一个在游戏");
		System.out.println(v5);//APM（Actions Per Minute）是一個在遊戲
		
		
	}

}
