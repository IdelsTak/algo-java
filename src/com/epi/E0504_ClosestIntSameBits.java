package com.epi;
public class E0504_ClosestIntSameBits {
    public static long closestIntSameBitCount_notRight(long x){
        long prevBit = x & 1;
        long currBit = prevBit;
        for(int i = 1; i<64; i++){
            currBit = (x>>>i) & 1;
            if(currBit != prevBit) {
                x ^= (currBit | prevBit);    
                return x;
            }
        }
        throw new IllegalArgumentException("All bits are 0 or 1");
    }
    public static long closestIntSameBitCount(long x){
        for (int i = 0; i < 63; i++) {
            if(((x >>i) & 1) != ((x>>(i+1)) & 1)){
                x ^= ((1L << i) | (1L << (i+1)));
                return x;
            }
        }
        throw new IllegalArgumentException("all bits are 0 or 1");
    }
}
