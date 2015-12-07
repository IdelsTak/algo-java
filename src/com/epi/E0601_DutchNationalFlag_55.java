package com.epi;

import java.util.Collections;

public class E0601_DutchNationalFlag_55 {
      public static enum Color { RED, WHITE, BLUE }
      
    public static void dutchFlagPartition(int idx, Color[] A) {
        int smaller = 0, equal = 0, larger = A.length;
        Color pivot = A[idx];
        while(equal < larger){            
            if (A[equal].ordinal()< pivot.ordinal()) { //<
                swap(A, smaller++, equal++);
            }else if( A[equal] == pivot ){  //==
                ++equal;
            }else{ //>
                swap(A, equal, larger--);
            }
        }
    }
    
    public static void swap(Color[] A, int i, int j){        
    }
}
