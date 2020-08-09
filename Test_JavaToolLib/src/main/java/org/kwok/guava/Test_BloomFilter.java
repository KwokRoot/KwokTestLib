package org.kwok.guava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * BloomFilter 判断元素是否存在，及非精确的去重统计。
 * 1.只能添加元素，不能删除元素。
 * 2.两个相同结构的 BloomFilter 可合并。
 * 3.存在错误率：有可能把不属于这个集合的元素误认为属于这个集合，但不会把属于这个集合的元素误认为不属于这个集合，即：
 *   com.google.common.hash.BloomFilter.mightContain(String) 为 true，的判断可能正确，为 false 的判断一定正确。
 * @author Kwok
 */
public class Test_BloomFilter {

	public static void main(String[] args) {
		/**
         * 创建一个插入对象为1亿，误报率为0.01%的布隆过滤器
         */
		BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 100000000, 0.0001);
        bloomFilter.put("1231");
        bloomFilter.put("1232");
        bloomFilter.put("1233");
        System.out.println(bloomFilter.mightContain("1231"));
        //结果：true
        
        //返回 True 时的误判率
        System.out.println(bloomFilter.expectedFpp());
        //结果：1.0226285907001444E-100
        
        //非精确的去重数
        System.out.println(bloomFilter.approximateElementCount());
        //结果：3
        
        
        //两个相同结构的 BloomFilter 合并
        BloomFilter<String> bloomFilter2 = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 100000000, 0.0001);
        bloomFilter2.put("JAVA");
        bloomFilter2.put("Python");
        
        bloomFilter.putAll(bloomFilter2);
        System.out.println(bloomFilter.mightContain("JAVA"));
        //结果：true
        
        System.out.println(bloomFilter.approximateElementCount());
        //结果：5
        
        
        //BloomFilter 序列化 与 反序列化。
        try {
        	BloomFilter<String> bloomFilter3_1 = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 100, 0.01);
        	bloomFilter3_1.put("111");
        	bloomFilter3_1.put("222");
        	
        	ByteArrayOutputStream baos = new ByteArrayOutputStream();
        	bloomFilter3_1.writeTo(baos);
			System.out.println(baos.toString());
	        //结果：......
			
			BloomFilter<CharSequence> bloomFilter3_2 = BloomFilter.readFrom(new ByteArrayInputStream(baos.toByteArray()), Funnels.stringFunnel(Charsets.UTF_8));
			bloomFilter3_2.put("JAVA");
			
			System.out.println(bloomFilter3_2.mightContain("JAVA"));
	        //结果：true
			
			System.out.println(bloomFilter3_2.mightContain("111"));
	        //结果：true
			
			System.out.println(bloomFilter3_2.mightContain("java"));
	        //结果：false
			
			System.out.println(bloomFilter3_2.approximateElementCount());
	        //结果：3
        } catch (IOException e) {
			e.printStackTrace();
		}
        
	}

}
