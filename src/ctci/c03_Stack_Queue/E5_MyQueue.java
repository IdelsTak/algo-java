/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t03_Stack_Queue;

/**
 *
 * @author andy
 */
public class E5_MyQueue {
    Stack<Character> s1 = new Stack<>(),
            s2 = new Stack<>();
    
    void enQue(char c){
        s1.push(c);
    }
    
    void shiftQueue(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()) s2.push(s1.pop());            
        }
    }
    
    char peek(){
        shiftQueue();
        return s2.peek();
    }
    
    char deQue(){
        shiftQueue();
        return s2.pop();
    }

}
