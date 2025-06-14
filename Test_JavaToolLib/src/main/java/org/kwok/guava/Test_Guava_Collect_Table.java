package org.kwok.guava;

import java.util.Map;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Guava 行-列-值二维表结构
 * @author Kwok
 */
public class Test_Guava_Collect_Table {

	public static void main(String[] args) {
		
		Table<String, String, Integer> table = HashBasedTable.create();
		
		table.put("user1", "age", 18);
		table.put("user1", "score", 98);
		table.put("user2", "age", 22);
		table.put("user2", "score", 100);
		
        System.out.println(table);
        System.out.println(table.row("user1"));
        System.out.println(table.column("age"));
        System.out.println(table.get("user2", "score"));

        Map<String, Map<String, Integer>> rowMap = table.rowMap();
        System.out.println(rowMap);

		Map<String, Map<String, Integer>> columnMap = table.columnMap();
		System.out.println(columnMap);

	}

}
