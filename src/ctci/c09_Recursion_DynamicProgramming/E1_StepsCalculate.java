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
public class E1_StepsCalculate {
    
    static int run(int n){
        int sum = 0;
        if(n>0){
            sum++;
            if(n>=1){
                sum += run(n-1);  //possible 1, take 1 step first
            }        
            if(n>=2) {
                sum += run(n-2);
            }
            if(n>=3){
                sum += run(n-3);
            }
        }
        return sum;
    }
    
    //TODO: to implement by avoid using recursion
    //TODO: to implement by using stack
    
    public static void main(String args[]){
        int steps = run(3);
        System.out.println(" 3 = " + steps);
        System.out.println("10 = " + run(10));
    }
}
