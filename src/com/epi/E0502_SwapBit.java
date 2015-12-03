package com.epi;

import java.util.Objects;
import java.util.Random;
import java.util.function.BiFunction;

public class E0502_SwapBit {
    public static long swapBits(long x, int i, int j){
        if(((x >>> i) & 1) != ((x >>> j) &1)){
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }    
    
    private static long swapBits2(long x, int i, int j){
        BiFunction <Long, Integer, Long> getBit;
        getBit = (x0, i0) -> (x0>>>i0) & 1;        
        if(! Objects.equals(getBit.apply(x, i), getBit.apply(x, j))){
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }
    
    
    public static void main(String[] args){
        Random r = new Random();
        long x = r.nextLong();
        int i = r.nextInt(64), j = r.nextInt(64);
        System.out.println(swapBits(x, i, j));
    }
}
