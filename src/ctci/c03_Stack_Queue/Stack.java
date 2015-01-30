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
 */
public class Stack<T> {
    Node<T> top;
    
    int capacity;
    int size;
    
    public Stack(int capacity){
        this.capacity = capacity;
        this.size = 0;
    }
    
    public Stack(){
        this.capacity = 1000;
        this.size = 0;        
    }
    
    public boolean isFull(){
        return size >= capacity;
    }
    
    public boolean isEmpty(){
        return size <= 0;
    }
    
    T pop(){
        T item = null;
        if(top != null){
            item = top.data;
            top = top.next;
            size--;
        }
        return item;
    }
    
    Stack<T> push(T item){
        Node t = new Node(item);
        t.next = top;
        top = t;
        size++;
        return this;
    }
    
    T peek(){
        return top.data;
    }

    int removeBottom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<T> p = top;
        while(p != null){
            sb.append(p.data.toString());
            p = p.next;
        }
        return sb.toString();        
    }
}

