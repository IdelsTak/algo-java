/*
only used for previous examples
 */

package t02_LinkedLists;

/**
 *
 * @author andy
 */
public class Node <T>{
    public Node<T> next = null;
    public T data;

    public Node(T data){
        this.data = data;
    }

    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }
    
    public void Append(T d){
        Node end = new Node(d);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;        
    }
}
