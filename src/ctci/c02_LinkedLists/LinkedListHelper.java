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
public class LinkedListHelper{
    /*
    constructor
    */
    
    public static Node<Character> createForward(String str){
        Node<Character> list = null; 
        char[] datas = str.toCharArray();
        for(char d : datas){
            list = LinkedListHelper.addToTail(list, d);
        }        
        return list;
    }
     
     
    public static Node<Integer> createReverse(int d){
        Node<Integer> list = null;
        while (d > 0){
              list = LinkedListHelper.addToTail(list, d%10);
              d = d/10;
        }
        return list;
    }
    
    
    public static Node<Integer> createForward(int d){
        Node<Integer> list = null;
        while (d > 0){
              list = LinkedListHelper.addToHead(list, d%10);
              d = d/10;
        }
        return list;
    }
    
   
    /*
    append, insert
    */
    public static <T> Node<T> addToTail(Node<T> head, T d){
        Node<T> n = new Node<>(d);
        return addToTail(head, n);
    }
    
    public static <T> Node<T> addToTail(Node<T> head, Node<T> n) {
        if(head == null) {
            head = n;
        }else{
            Node<T> p = head;
            while(null != p.next){
                p = p.next;
            }
            p.next = n;
        }
        return head;
    }
    
 
    public static <T> Node<T> addToHead(Node<T> head, T d){
        Node<T> n = new Node<>(d);
        return addToHead(head, n);
    }
    
   
    public static <T> Node<T> addToHead(Node<T> head, Node<T> n) {
        n.next = head;
        head = n;
        return head;
    }


    /*
    Auxiliary
    */
    public static <T> void print(Node<T> head){
        Node<T> p = head;
        while(null != p){
            System.out.print(p.data);
            p = p.next;
        }
    }
    
    
    public static <T> String toString(Node<T> head){
        StringBuilder sb = new StringBuilder();
        Node<T> p = head;
        while(null != p){
            sb.append(p.data);
            p = p.next;
        }
        return sb.toString();
    }
    
    
    public static <T> int getLen(Node<T> head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }    
    
}
