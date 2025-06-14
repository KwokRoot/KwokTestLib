package org.kwok.hutool;

import cn.hutool.core.map.multi.RowKeyTable;

/**
 * Hutool 行-列-值二维表结构
 * @author Kwok
 * 2025-06-12
 */
public class Test_Hutool_RowKeyTable{

    public static void main(String[] args) {

        RowKeyTable<String, String, Object> rowKeyTable = new RowKeyTable<>();
        rowKeyTable.put("1", "1-1", "a");
        rowKeyTable.put("2", "2-1", "b");
        rowKeyTable.put("2", "2-2", "c");
        rowKeyTable.put("3", "3-1", "d");
        rowKeyTable.put("3", "2-2", "e");
        rowKeyTable.put("3", "3-3", "f");

        System.out.println(rowKeyTable);
        System.out.println(rowKeyTable.getRow("2"));
        System.out.println(rowKeyTable.getColumn("2-2"));
        System.out.println(rowKeyTable.get("2", "2-2"));

        System.out.println(rowKeyTable.rowMap());
        System.out.println(rowKeyTable.columnMap());

    }

}
