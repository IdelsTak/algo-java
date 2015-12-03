package com.epi;

public class E0507_ConvertBase {
    public String convert(int b1, String s, int b2){
        int n = E0506_InterconvertingStringInteger.stringToInt(s, b1);
        String str = E0506_InterconvertingStringInteger.intToString(n, b2);
        return str;
    }
}
