package com.epi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E0511_PrimeSieveBasic {
    public static List<Integer> genPrimes(int n){
        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n+1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);
        for(int i = 2; i<=n; i++){
            if(isPrime.get(i)){
                primes.add(i);                
                for(int j =i;  i<=n; j+=j)
                    isPrime.set(j, false);            
             }
        }        
        return primes;
    }
}
