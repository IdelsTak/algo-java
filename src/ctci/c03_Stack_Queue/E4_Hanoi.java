/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t03_Stack_Queue;

import t02_LinkedLists.Node;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E4_Hanoi {
    Stack<Character> ss = new Stack<>(), 
            dd = new Stack<>(), 
            tt = new Stack<>();
    
    
    public Stack<Character> getStack(String str){
        Stack<Character> lo = new Stack<>();
        char[] chars = str.toCharArray();
        for(char c : chars){
            lo.push(c);
        }
        return lo;
    }

    
    /*
    public void M(int n, Stack<Character> s, Stack<Character> d, Stack<Character> t){
        if(1 == n){
            d.push(s.pop());
        }else if(2 == n){
            t.push(s.pop());
            d.push(s.pop());
            d.push(t.pop());
        }else{
            M(n-1, s, t, d);
            d.push(s.pop());
            M(n-1, t, d, s);
        }
    }    
    */

    public void M(int n, Stack<Character> s, Stack<Character> d, Stack<Character> t){
        if(n > 0){
            M(n-1, s, t, d);
            d.push(s.pop());
            M(n-1, t, d, s);
        }
    }
    
    @Test
    public void test(){
        String str = "ABCDE";
        ss = getStack(str);
        str = ss.toString();
        M(str.length(), ss, dd, tt);
        String sStr = ss.toString();
        String dStr = dd.toString();
        String tStr = tt.toString(); 
        
        System.out.println(str + "   " + sStr + "   " + dStr + "   " + tStr);
        
        assertTrue("null", "".equals(sStr));
        assertTrue("abcde", str.equals(dStr));
    }

}
