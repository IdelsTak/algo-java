/*
    this is a full functionality class for char class
 */

package t02_LinkedLists;

/**
 *
 * @author andy
 */
public class LinkedList {
    public NodeC head = null;     

    public LinkedList(){    }
    
    public LinkedList(String str, boolean isRev){
        char[] chars = str.toCharArray();
        if (isRev){
            int len = chars.length;
            for(int i = 0; i< len/2; i++){
                char tmp = chars[i];
                chars[i] = chars[len - i - 1];
                chars[len - i - 1] = tmp;
            }
        }
        for(char d : chars){
            if(head == null){
                head = new NodeC(d);
            }else{
                head.Append(d);
            }
        }        
    }
    
    public LinkedList(String str){
        this(str, false);
    }
    
    public LinkedList(NodeC head){
        this.head = head;
    }
    
    public void Append(char c){        
        if(head == null){
            NodeC n = new NodeC(c);
            head = n;
        }else{
            head.Append(c);
        }            
    }
    
    public void print(){
        NodeC p = head;
        while(null != p){
            System.out.print(p.data);
            p = p.next;
        }
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        NodeC p = head;
        while(null != p){
            sb.append(p.data);
            p = p.next;
        }
        return sb.toString();
    }
}