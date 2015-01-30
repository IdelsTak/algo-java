/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t02_LinkedLists;

import java.util.Stack;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author andy
 */
public class E7_palindrome {

    //method 1: use stack, compare all the data
    //method 2: use fast and slow approach
    boolean isPalindrome(Node<Character> head){
        Node<Character> fast = head;
        Node<Character> slow = head;
        Stack<Character> stack = new Stack<>();
        while(fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) slow = slow.next;
        
        while(slow != null){
            if (slow.data != stack.pop().charValue()) return false;
            slow = slow.next;
        }
        return true;        
    }
    
    //TODO: Implement approach use Stack, book p199
    
    
    @Test
    public void test() {
        String str;
        Node<Character> n;
        str = "ABCDCBA";
        n = LinkedListHelper.createForward(str);
        assertTrue(str, isPalindrome(n));

        str = "ABCDCBAB";
        n = LinkedListHelper.createForward(str);
        assertFalse(str, isPalindrome(n));
    }    
}
