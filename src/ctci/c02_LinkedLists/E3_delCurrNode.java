/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t02_LinkedLists;

/**
 *
 * @author andy
 */
public class E3_delCurrNode {
    //P77
    public boolean del(NodeC node){
        if(node == null || node.next == null){
            return false;
        }else{
            node.data = node.next.data;
            node.next = node.next.next;
            return true;
        }
    }
    
}
