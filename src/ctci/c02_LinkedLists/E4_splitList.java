/*ist
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t02_LinkedLists;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author andy
 */
public class E4_splitList {
    public LinkedList l;
    
    /*public E4_splitList(String str){//"caused an ERROR: Test class can only have one constructor:
        l = new LinkedList(str);
    }*/
    
    public E4_splitList(){
        l = new LinkedList("358219");
    }
    
    public void split(char x){
        NodeC p = l.head;
        while(null != p && p.data < x){
            p = p.next;
        }
        
        NodeC q = p;
        while(q.next != null){
            if(q.next.data > x){
                q = q.next;
            }else{
                //remove from list
                NodeC tmp = q.next;
                q.next = q.next.next;
                //add to the head
                tmp.next = l.head;
                l.head = tmp;
            }
        }
        l.print();        
    }
    
    @Test
    public void test() {
        //E4_splitList e = new E4_splitList("358219");
        E4_splitList e = new E4_splitList();
        e.split('5');
        assertTrue("", e.l.toString().endsWith("123589"));
    }    
    
}
