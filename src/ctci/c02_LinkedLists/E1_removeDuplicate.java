/*
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
public class E1_removeDuplicate {
    public NodeC head = null;
    public E1_removeDuplicate(String str){
        for(Character c : str.toCharArray()){
            if(null == head){
                head = new NodeC(c);
            }else{
                head.Append(c);
            }
        }
    }
    
    public void remove_duplicate(){
        if(head != null){
            NodeC p = head;
            while(p.next != null){
                NodeC q = p;
                while(null != q.next){
                    if(p.data == q.next.data){
                        q.next = q.next.next;
                    }else{
                        q = q.next;
                    }
                }//while
            }//while
        }
    }
    
    @Override
    public String toString(){
       StringBuilder sb = new StringBuilder();
       NodeC p = head;
       while(null != p){
           sb.append(p.data);
       }
       return sb.toString();
    }
    
    @Test
    public void test() {
        String str1 = "FOLLOW UP";
        assertTrue("", (new E1_removeDuplicate(str1).toString()).equals("FOLW UP"));
    }
    
    
}
