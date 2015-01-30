/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t03_Stack_Queue;

import t02_LinkedLists.Node;

/**
 *
 * @author andy
 * @param <T>
 */
public class Queue <T> {
    Node<T> first, last;
    
    void enQueue(T data){
        if(first == null){
            first = new Node(data);
            last = first;
        }else{
            last = new Node(data, last);
        }
    }
    
    T deQueue(){
        T data = null;
        if(first != null){
            data = first.data;
            first = first.next;
            if(null == first){
                last = null;
            }
        }
        return data;
    }
}
