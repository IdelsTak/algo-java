package t02_LinkedLists;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andy
 */
public class E2_nth_to_lastElem {
    private NodeC head = null;
    private int len = 0;
    private String str = "fedcba987654321";
    
    public E2_nth_to_lastElem(){
        head = (new LinkedList(str)).head;
    }
    
    private int getLen(){
        len = 0;
        if(head != null){
            NodeC p = head;
            do{
                len++;
                p = p.next;
            } while(null != p);
        }
        return len;
    }
    
    //use the normal method
    public NodeC get1(int n){
        getLen();
        NodeC p = head;
        for(int i = 0; i<len-n; i++){
            p = p.next;
        }
        return p;
    }
    
    //use the two linkList
    public NodeC get2(int n){
        NodeC p1 = head;
        NodeC p2 = head;
        int i;
        for(i = 0; i<n-1; i++){
            if(p2.next != null){
                p2 = p2.next;
            }else{
                break;
            }
        }
        
        if(i == n - 1){
            while(p2.next != null){
                p1 = p1.next;
                p2 = p2.next;
            }
        }else{
            p1 = null;
        }
        return p1;
    }

    public int get3_bk1(NodeC head, int n){
        if(head == null) return 0;
        int i = get3_bk1(head.next, n) + 1;
        if (i == n){
             System.out.println(head.data + "");
        }
        return i;
    }
    
    //TODO: this inplementation need to think again.89l
    public class IntWrapper{
        public int i = 0;
    }
    
    public NodeC get3_bk2(NodeC head, int k, IntWrapper w){
        if(head == null) {
            w.i = 0;
            return null;
        }
        NodeC node = get3_bk2(head.next, k, w);
        w.i++;
        if(w.i == k){
            return head;
        }
            
        return node;
    }
    
    public Result get3(NodeC head, int n){
        if(head == null) return new Result(0);
        Result r = get3(head.next, n);
        r.i++;
        if (r.i == n){
             return new Result(n, head.data);
        }
        return r;
    }    
    
    public class Result{
        int i;
        char ch;
        public Result(int n){
            this.i = n;
        }
        public Result(int n, char c){
            this.i = n;
            this.ch = c;
        }
    }
    
    @Test
    public void test() {
        E2_nth_to_lastElem e = new E2_nth_to_lastElem();
        boolean isEq = (e.get1(5).data == '5');
        assertTrue("get1", isEq);
        assertTrue("get2", e.get2(5).data == '5');
        assertTrue("get3", e.get3(e.head, 5).ch == '5');    
        //
        IntWrapper wrap =new IntWrapper();
        NodeC node =  e.get3_bk2(e.head, 5, wrap);
        assertTrue("get3_bk2", node.data == '5');
    }    
}
