/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author awu
 */
public class E0500_Tmp {
    int getParity(long v){
        int p = 0;
        while(v!=0){
            p ^= 1;
            v &= (v-1);
        }
        return p;
    }
    
    long swap(long x, int i, int j){
        //!equal biti, bitj
        long y = (i<<i) | (i<<j);
        x ^= y;
        return x;
    }
    
    long closestInt(long v) throws Exception{
        long prev = v & 1;
        for(int i = 1; i<64; i++){
            long cur = v & (1L << i);
            if(cur != prev){
                v ^= (cur | prev);
                return v;
            }
        }
        throw new Exception("Error");
    }
    
    void printPowerSet(List<Integer> s){
        
    }
    
    void printPowerSetHelper(List<Integer> s, int next, List<Integer> result){
        if(next == s.size()){
            //print(result);
            return;
        }
        result.add(s.get(next));
        printPowerSetHelper(s, next+1, result);
        result.remove(s.get(next));
        printPowerSetHelper(s, next+1, result);
    }
    
    String intToString(int x){
        StringBuilder s = new StringBuilder();
        int y = x;
        do {
            s.append(y%10);
            y /= 10;
        }while(x!=0);
        if(x<0){
            s.append('-');
        }
        s.reverse();
        return s.toString();
    }
    
    int stringToInt(String s){
        char[] arr = s.toCharArray();
        if(arr == null) return 0;
        if(arr.length == 1) return arr[0] - '0';
        int sIdx = 1;
        int result = 0;
        if(arr[0] == '-'){
            sIdx = 2;
            result = (arr[1] - '0') * -1;
        }  else {
            result = arr[0] - '0';
        }
        for(int i= sIdx; i<arr.length; i++ ){
            result = result * 10 + (arr[i]-'0');
        }
        return result;            
    }
    
    int stringToInt2(String s){
        boolean isNegative = s.charAt(0) == '-';
        int result = 0;
        for(int i = isNegative? 1:0; i<s.length(); ++i){
            result = result * 10 + s.charAt(i) - '0';
        }
        return result;
    }
    
    int stringToIntBase(String s, int b1){
        boolean isNeg = s.charAt(0) == '-';
        int result = 0;
        for(int i = isNeg? 1 : 0; i<s.length(); i++){
            result = result * 10 + s.charAt(i) - '0';
        }
        return result * (isNeg? -1: 1);
    }
    
    String intToStringBase(int x,int b2){
        int y = x;
        StringBuilder sb = new StringBuilder();
        do{
            sb.append('0'+y%10);
            y /= 10;
        }while(y != 0);
        if(y<0) sb.append('-');
        sb.reverse();
        return sb.toString();
    }
    
    String baseConversion(String s, int b1, int b2){
        int n = stringToIntBase(s, b1);
        s = intToStringBase(n, b2);
        return s;
    }
    
    String enCode(int n){
        String s = intToStringBase(n, 2);
        for(int i = 1; i<s.length(); i++) s = "0" + s;
        return s;
    }
    
    String enCode(int[] a){
        StringBuilder sb = new StringBuilder();
        for(int n : a){
            sb.append(enCode(n));
        }
        return sb.toString();
    }
    
    List<Integer> deCode(String s){
        int nZeroStart = 0;
        ArrayList<Integer> Result = new ArrayList<>();
        for(int i = nZeroStart; i<s.length(); i++){
            if(s.charAt(i)!='0'){
                int nZeros = i - nZeroStart - 1;
                int nDigits = nZeros + 1;
                String strDigit = s.substring(i, nDigits);
                Result.add(stringToIntBase(strDigit, 10));
            }
        }
        return Result;
    }
    
    public List<Integer> getPrime(int n){
        ArrayList<Boolean> isPrime = new ArrayList<>(n+1);
        for(int i = 4; i<isPrime.size(); ++i) isPrime.set(i, true);
        for(int i = 0; i<4; ++i) isPrime.set(i, false);
        for(int i = 2; i<=isPrime.size()/2; i+=2)
            for(int j = i+i; j<isPrime.size(); j+=i)
                 isPrime.set(i, false);
        ArrayList<Integer> result = new ArrayList();
        for(int i = 1; i<=isPrime.size(); ++i){
            if(isPrime.get(i))
                result.add(i);
        }
        return result;
    }
    
    public int Longest(int[] a){
        int lS=0, lE=0;
        int s=0, e;
        for(e = s+1; e<a.length; e++){
            if(a[e-1]>a[e]){
                if(e-s > lE-lS){
                    lE = e;
                    lS = s;
                }
                s = e+1;
                e= s+1;
            }
        }
        if(e-s > lE-lS){
            lE = e;
            lS = s;
        }
        return lE-lS +1;
    }
    
    public String multiChar(String a, char b){
        int nB = 'b' - '0';
        if(nB == 0) return "0";
        if(nB == 1) return a;
        int nCarry = 0;
        StringBuffer sb = new StringBuffer();
        for(int i = a.length() -1; i>=0; i--){
            int sum = nCarry + nB * (a.charAt(i) - '0');
            nCarry = sum / 10;
            sb.append(sum%10 + '0');
        }
        if(nCarry >0) sb.append(nCarry + '0');
        sb.reverse();
        return sb.toString();
    }
    
    public int addCarry(char a, char b, int nCarry){
        int sum = a + b + nCarry;
        return sum/10;
    }
    
    public String addDigit(char a, char b, int nCarry){
        int sum = a + b + nCarry;
        return Integer.toString(sum%10);
    }
    
    
    public String add(String a, String b){
        int lenA = a.length(), lenB = b.length();
        int nCarry = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i<lenA && i<lenB){
            sb.append(addDigit(a.charAt(lenA - i -1), a.charAt(lenB - i - 1), nCarry));
            nCarry = addCarry(a.charAt(lenA - i -1), a.charAt(lenB - i - 1), nCarry);
            i++;
        }
        if(i==lenA && i==lenB && nCarry>0)
            sb.append('0' + nCarry);
        else 
        {
            //TODO
        }
        return "";
    }
    
    public String addZeros(String a, int n){
        for(int i = 0; i<n; i++) a = a+"0";
        return a;
    }
    
    public String multiPositiveStr(String a, String b){
        int n = b.length();
        String result = "0";
        for(int i = n-1; i>=0; i--){
           String a1 = addZeros(a, n-1-i);
           result = add(multiChar(a1, b.charAt(i)), result);
        }
        return result;
    }
    
}
