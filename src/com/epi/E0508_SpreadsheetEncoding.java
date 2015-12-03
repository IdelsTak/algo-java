package com.epi;

public class E0508_SpreadsheetEncoding {
    public static int ColId2Int(String colId){
        return 1+E0506_InterconvertingStringInteger.stringToInt(colId, 26);
    }
}
