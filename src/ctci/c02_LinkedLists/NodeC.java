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
public class NodeC {
    NodeC next = null;
    char data;

    public NodeC(char data){
        this.data = data;
    }
    
    public void Append(char d){
        NodeC end = new NodeC(d);
        NodeC n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;        
    }
    
    //return the Head Position
    NodeC deleteNode(NodeC head, char d){
        NodeC n = head;
        if(n.data == d){
            return n.next;
        }
        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
            }
            n = n.next;
        }
        return head;
    }
}
