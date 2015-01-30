/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t03_Stack_Queue;

import t02_LinkedLists.Node;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E2_Stack_withMin {
    Node<Integer> top = null;
    Node<Node<Integer>> min = null;
    
    public void push(int d){
        top = new Node(d, top);
        if(d < getMin()){
            min = new Node(top, min);
        }
    }
    
    public int pop() throws Exception{
        if(null == top){
            throw new Exception("no data");
        }
        if(top == min.data) min = min.next;
        
        int data = top.data;
        top = top.next;
        return data;
    }
    
    public int min(){
        return min.data.data;
    }
    
    private int getMin(){
        int m;
        if(min == null){
            m = Integer.MAX_VALUE;
        }else{
            m = min.data.data;
        }
        return m;
    }
    
    @Test
    public void test() throws Exception {
        push(7);
        assertEquals(7, getMin());
        
        push(3);
        assertEquals(3, getMin());
        
        push(3);
        assertEquals(3, getMin());
        
        push(5);// 7335
        assertEquals(3, getMin()); 
        //
        
        pop();//5   733
        assertEquals(3, getMin());        
        pop();//3   73
        assertEquals(3, getMin());      
        pop();//3   7
        assertEquals(7, getMin());         
    }
}
