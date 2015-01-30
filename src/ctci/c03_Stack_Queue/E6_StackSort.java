/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t03_Stack_Queue;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E6_StackSort {
    Stack<Integer> sA = new Stack<>();
    Stack<Integer> sV = new Stack<>();
    
    public void sort(){
        while(!sA.isEmpty()){
            int val = sA.pop();
            while(!val_to_sV(val)){
                sA.push(sV.pop());
            }
        }
        while(!sV.isEmpty()){
            sA.push(sV.pop());
        }
    }

    private boolean val_to_sV(int val) {
        if(sV.isEmpty() || val < sV.peek()){
            sV.push(val);
            return true;
        }
        return false;
    }
    
    @Test
    public void test(){
        sA.push(7).push(2).push(3).push(1).push(5);
        sort();
        String str = sA.toString();
        assertTrue("75321 = " + str, "75321".equals(str));
    }

}
