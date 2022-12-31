package org.kwok.pinyin;

import java.util.Arrays;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import cn.hutool.core.util.StrUtil;

/**
 * 该练习是对 com.github.stuxuhai:jpinyin 的练习。
 * @date: 2022年12月30日WWW
 * @author Kwok
 */
public class Test_JPinyin {

	public static void main(String[] args) throws Exception {
		
		// 判断一个汉字是否为多音字
		System.out.println(PinyinHelper.hasMultiPinyin('浩'));
		System.out.println(PinyinHelper.hasMultiPinyin('为'));

		
		System.out.println(StrUtil.repeat("*", 36));
		
		// 获取单个汉字拼音
		System.out.println(Arrays.toString(PinyinHelper.convertToPinyinArray('为', PinyinFormat.WITH_TONE_MARK)));
		System.out.println(Arrays.toString(PinyinHelper.convertToPinyinArray('为', PinyinFormat.WITHOUT_TONE)));
		
		
		System.out.println(StrUtil.repeat("*", 36));
		
		// 汉字转拼音
		System.out.println(PinyinHelper.convertToPinyinString("你好", ",", PinyinFormat.WITH_TONE_MARK));
		System.out.println(PinyinHelper.convertToPinyinString("你好", ",", PinyinFormat.WITH_TONE_NUMBER));
		System.out.println(PinyinHelper.convertToPinyinString("你好", ",", PinyinFormat.WITHOUT_TONE));
		
		
		System.out.println(StrUtil.repeat("*", 36));
		
		// 汉字转拼音首字母
		System.out.println(PinyinHelper.getShortPinyin("你好"));
		
	}

}
