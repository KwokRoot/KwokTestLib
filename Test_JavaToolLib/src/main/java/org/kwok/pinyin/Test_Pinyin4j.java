package org.kwok.pinyin;

import java.util.Arrays;

import cn.hutool.core.util.StrUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

/**
 * 该练习是对 com.belerweb:pinyin4j 的练习。
 * @date: 2022年12月30日
 * @author Kwok
 */
public class Test_Pinyin4j {

	public static void main(String[] args) throws Exception {

		
		char c = '归';
		
		HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
		hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
		hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
		
		System.out.println(Arrays.toString(PinyinHelper.toHanyuPinyinStringArray(c, hanyuPinyinOutputFormat)));
		
		System.out.println(StrUtil.repeat("*", 18));
		
		System.out.println(PinyinHelper.toHanYuPinyinString("你好Hello", hanyuPinyinOutputFormat, ",", true));
		
		
		System.out.println(StrUtil.repeat("*", 36));
				
		// 汉语拼音
		System.out.println(Arrays.toString(PinyinHelper.toHanyuPinyinStringArray(c)));
		
		// 通用拼音
		System.out.println(Arrays.toString(PinyinHelper.toTongyongPinyinStringArray(c)));
		
		// 韦氏拼音(威妥码、港音、粤语)
		System.out.println(Arrays.toString(PinyinHelper.toWadeGilesPinyinStringArray(c)));

		// 注音二式
		System.out.println(Arrays.toString(PinyinHelper.toMPS2PinyinStringArray(c)));
		
		// 国语罗马字
		System.out.println(Arrays.toString(PinyinHelper.toGwoyeuRomatzyhStringArray(c)));
		
		// 耶鲁粤语拼音
		System.out.println(Arrays.toString(PinyinHelper.toYalePinyinStringArray(c)));

	}

}
