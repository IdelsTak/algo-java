package com.epi;

import java.util.Random;

public class E0501_Parity {
    public static void main(String[] args){
        Random r = new Random();
        for(int times = 0; times < 1000; ++times){
            long x = r.nextInt(Integer.MAX_VALUE);
            assert(parity1(x) == parity2(x));
            assert(parity3(x) == parity2(x));
        }
    }
    
    public static short parity1(long x){
        short result = 0;
        while(x != 0){
            result ^= (x&1);
            x >>= 1;
        }
        return result;
    }
    
    public static short parity2(long x){
        short result = 0;
        while(x != 0){
            result ^= 1;
            x &= (x-1);
        }
        return result;
    }
    
    //parity 3
    private static short[] preComputedParity;
    static {
        preComputedParity = new short[1 << 16];
        for(int i = 0; i< (1<<16); ++i){
            preComputedParity[i] = E0501_Parity.parity1(i);
        }
    }
    
    public static short parity3(long x){
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;
        return (short) (
                preComputedParity[(int) ((x >>> (3 * WORD_SIZE)) & BIT_MASK)]
                ^ preComputedParity[(int) ((x >>> (3 * WORD_SIZE)) & BIT_MASK)]
                ^ preComputedParity[(int) ((x >>> (3 * WORD_SIZE)) & BIT_MASK)]
                ^ preComputedParity[(int) ((x >>> (3 * WORD_SIZE)) & BIT_MASK)]);
    }
}
