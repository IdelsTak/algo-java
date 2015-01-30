/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t02_LinkedLists;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author andy
 */
public class E6_CircularLink {
     //"ABCDEC"
    public Node<Character> createForwardLoop(String s){
        Node<Character> list = null;
        char[] cs = s.toCharArray();
        char lastChar = cs[cs.length - 1];
        for(int i = 0; i < cs.length - 1; i++){
            list = LinkedListHelper.addToTail(list, cs[i]);
        }
        //find link Loc
        Node<Character> p = list, loopNode = null;
        while(null != p){
            if(p.data == lastChar){
                loopNode = p;
                break;
            }
            p = p.next;
        }
        //get last node, and organize loop
        p = list;
        while(null != p && null != p.next){
            p = p.next;
        }
        if(null != p) p.next = loopNode;
        return list;
    }   

    @Test
    public void test() {
        Node<Character> n1, n0;
        n1 = createForwardLoop("ABCDEC");
        n0 = findBeginLoop(n1);
        assertTrue("Initial should be " + n0.data, n0.data == 'C');
    }

    private Node<Character> findBeginLoop(Node<Character> head) {
        Node<Character> slow = head;
        Node<Character> fast = head;
        //find the collision
        while( fast != null  && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }        
        if(fast == null || fast.next == null){
            return null;
        }
        //find the beginLoop
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}
