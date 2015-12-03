package com.epi;

public class E0506_InterconvertingStringInteger {
    public static String intToString(int x, int base){
        boolean isNegative = false;
        if(x<0){
            x = -x;
            isNegative = true;
        }
        
        StringBuilder s = new StringBuilder();
        do {
            s.append('0'+ x%base);
            x /= base;
        }while(x!=0);
        if (isNegative)
            s.append('-');
        s.reverse();
        return s.toString();
    }

    public static int stringToInt(String s, int base){
        int idx=0;
        int result = 0;
        int sign = 1;
        char[] c = s.toCharArray();
        if(c[0] == '-'){
            sign = -1;
            idx = 1;
        }
        for(int i = idx; i<c.length; i++){
            result = result * base + c[i] - '0';
        }
        result *= sign;
        return result;
    }
}
