/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t09_Recursion_DynamicProgramming;

/**
 *
 * @author andy
 */
public class Fibonacci {
	int run1(int n){
        if(n == 0 || n == 1) return n;
        return run1(n);
    }
    
    int[] fibCache = new int[Integer.MAX_VALUE];
    int run2(int n){
        if(n == 0 || n == 1) return n;
        if(fibCache[n] != 0) return fibCache[n];
        fibCache[n] = run2(n-1) + run2(n -1);
        return fibCache[n];
    }
    
    //no loop - with cache.
    int run3(int n){
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[0] + fib[1];
        }
        return fib[n];
    }
    
    //no loop - no cache, most efficient way
    int run4(int n){
        if(n == 0 || n == 1){
            return n;
        }else{
            int a = 0, b = 1, c = a + b;
            for(int i = 2; i <= n; i++){
                c = a + b;
                a = b;
                b = c;
            }
            return c;            
        }
    }//
}
