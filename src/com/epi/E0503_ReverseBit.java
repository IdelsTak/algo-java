package com.epi;

public class E0503_ReverseBit {
    public static long reverseBits(long x){
        for(int i = 0; i<64/2; i++){
            x = E0502_SwapBit.swapBits(x, i, 63-i);
        }
        return x;
    }
}
