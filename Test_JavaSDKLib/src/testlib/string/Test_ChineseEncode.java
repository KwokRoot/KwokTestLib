package testlib.string;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;


/**
 * ① 中文排序问题
 * ② 中文编码问题
 * ③ 中文编码值
 * @author Kwok
 * 2022-01-09
 */
public class Test_ChineseEncode {

	public static void main(String[] args) throws Exception {
		
		System.out.println("----------------------- 中文排序 -----------------------");
		//中文默认排序是按中文的 Unicode 编码值进行的排序
		ArrayList<String> list = new ArrayList<String>();
		list.add("一");
		list.add("二");
		list.add("三");
		list.add("四");
		list.add("五");
		list.add("六");
		list.add("七");
		list.add("八");
		list.add("九");
		list.add("十");
		Collections.sort(list);
		System.out.println(list);

		
		
		TreeMap<Integer, Character> code_cn_map = new TreeMap<>(); 
		
		code_cn_map.put((int)'一', '一');
		code_cn_map.put((int)'二', '二');
		code_cn_map.put((int)'三', '三');
		code_cn_map.put((int)'四', '四');
		code_cn_map.put((int)'五', '五');
		code_cn_map.put((int)'六', '六');
		code_cn_map.put((int)'七', '七');
		code_cn_map.put((int)'八', '八');
		code_cn_map.put((int)'九', '九');
		code_cn_map.put((int)'十', '十');

		code_cn_map.forEach((x, y) -> {
			System.out.println(x + " -> " + y);
		});
		
		
		
		System.out.println("----------------------- 中文编码 -----------------------");
		
		//获取中文的 Unicode 码 十六进制值
		Character c = '一';
		System.out.println(Integer.toHexString(c));
		
		//获取中文的 Unicode 码 十进制值
		System.out.println(Integer.decode("0x" + Integer.toHexString(c)));
		
		System.out.println(Character.hashCode(c));
		System.out.println((int)c);
		
		
		System.out.println("----------------------- 中文编码值 -----------------------");
		
		//Java 默认 Unicode 编码，中文编码值
		System.out.println(Integer.toBinaryString('一'));
		System.out.println(Integer.valueOf("100111000000000", 2));
		
		byte[] bs = "一".getBytes("UnicodeBigUnmarked");
		System.out.println(Arrays.toString(bs));
		for (int i = 0; i < bs.length; i++) {
			System.out.print(Integer.toBinaryString(bs[i]));
		}
		
	}

}

