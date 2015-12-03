package com.epi;
public class E0504_ClosestIntSameBits {
    public static long closestIntSameBitCount(long x){
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
}
