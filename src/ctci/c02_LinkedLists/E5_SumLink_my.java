/*
 */

package t02_LinkedLists;
import java.util.Stack;
import static org.junit.Assert.*;
import org.junit.Test;


/**
 *
 * @author andy
 */
public class E5_SumLink_my {
    /*
    
    */
    //use recusive - more clean code
    private Node<Integer> addRev1(Node<Integer> n1, Node<Integer> n2, int carry) {
        if(n1 == null && n2 == null && carry == 0){
            return null;
        }        
        int value = carry;
        if(n1 != null) value += n1.data;
        if(n2 != null) value += n2.data;
        Node<Integer> result = new Node(value%10);
        if(n1 != null || n2 != null){
            Node<Integer> more = addRev1(
                    n1 == null ? null : n1.next,
                    n2 == null ? null : n2.next,
                    value > 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }
    
    //use local loop
    private Node<Integer> addRev2(Node<Integer> n1, Node<Integer> n2) {
        Node<Integer> head = null;
        int carry = 0;
        while(n1 != null || n2 != null){
            int value = carry;
            if(n1 != null){
                value += n1.data;
                n1 = n1.next;
            }
            if(n2 != null){
                value += n2.data;
                n2 = n2.next;
            }
            head = LinkedListHelper.addToTail(head, value%10);
            carry = value/10;
        }
        if (carry > 0){
            head = LinkedListHelper.addToTail(head, carry);
        }
        return head;
    }

    
    /*
    reverse the order
    */
    private Stack<Node<Integer>> getStack(Node<Integer> n){
        Stack<Node<Integer>> stack = new Stack<>();
        while(n != null){
            stack.push(n);
            n = n.next;
        }
        return stack;
    }
            
    /*
    Forward: Neat method
    */        
    private Node<Integer> addFor1(Node<Integer> n1, Node<Integer> n2) {
        Node<Integer> head = null;
        Stack<Node<Integer>> s1 = getStack(n1);
        Stack<Node<Integer>> s2 = getStack(n2);
        int carry = 0;
        while(!s1.empty() || !s2.empty()){
            int value = carry;
            if(!s1.empty()) value += s1.pop().data;
            if(!s2.empty()) value += s2.pop().data;
            head = LinkedListHelper.addToHead(head, value%10);
            carry = value/10;
        }
        return head;
    }
    
    /*
    Forward: Cumbersome method
    */
    public class CarryWrapper{
        int carry;
    }    
    private Node<Integer> addFor2(Node<Integer> n1, Node<Integer> n2) {
        int l1, l2;
        l1 = LinkedListHelper.getLen(n1);
        l2 = LinkedListHelper.getLen(n2);
        if(l1 > l2) n2 = padLink(n2, l1-l2);
        if(l1 < l2) n1 = padLink(n1, l2-l1);
     
        CarryWrapper carry = new CarryWrapper();
        Node<Integer> head = addFor2_ext(n1, n2, carry);
        if(carry.carry > 0){
            head = new Node(carry.carry, head);
        }
        return head;
    }
    

    private Node<Integer> addFor2_ext(Node<Integer> n1, Node<Integer> n2, CarryWrapper sum) {
        if(n1 == null && n2 == null){
            sum.carry = 0;
            return null;
        }else if(n1 != null && n2 != null){
            Node<Integer> more = addFor2_ext(n1.next, n2.next, sum);
            int value = n1.data + n2.data + sum.carry;
            Node<Integer> curr = new Node<>(value%10, more);
            sum.carry = value/10;
            return curr;
        }else{
            assertTrue("addFor2_ext need two link have same length", false);
            return null;
        }
    }
    

    private Node<Integer> padLink(Node<Integer> head, int i) {
        for(int j = 0; j<i; j++)
            head = new Node(0, head);
        return head;
    }
    
    
    @Test
    public void test() {
        Node<Integer> n1, n2, n3;
        String result;
        /*
        same digit
        */
        n1 = LinkedListHelper.createReverse(617);//    7->1->6
        n2 = LinkedListHelper.createReverse(295);//   5->9->2->1
        n3 = addRev1(n1, n2, 0);//  2->1->9
        result = LinkedListHelper.toString(n3);
        assertTrue("rev1 should be 219 = " + result, result.equals("219"));

        n3 = addRev2(n1, n2);//  2->1->9
        result = LinkedListHelper.toString(n3);
        assertTrue("rev2 should be 219 = " + result, result.equals("219"));

        n1 = LinkedListHelper.createForward(617);//    7->1->6
        n2 = LinkedListHelper.createForward(295);//    5->9->2
        n3 = addFor1(n1, n2);
        result = LinkedListHelper.toString(n3);
        assertTrue("for should be 912 = " + result, result.equals("912"));
        
        n1 = LinkedListHelper.createForward(617);//    7->1->6
        n2 = LinkedListHelper.createForward(295);//    5->9->2
        n3 = addFor2(n1, n2);
        result = LinkedListHelper.toString(n3);
        assertTrue("for should be 912 = " + result, result.equals("912"));  
        /*
        Different digit
        */
        n1 = LinkedListHelper.createReverse(617);//    7->1->6
        n2 = LinkedListHelper.createReverse(1295);//   5->9->2->1
        n3 = addRev1(n1, n2, 0);//  2->1->9->1
        result = LinkedListHelper.toString(n3);
        assertTrue("rev1 should be 2191 = " + result, result.equals("2191"));

        n3 = addRev2(n1, n2);//  2->1->9
        result = LinkedListHelper.toString(n3);
        assertTrue("rev2 should be 2191 = " + result, result.equals("2191"));

        n1 = LinkedListHelper.createForward(617);//    7->1->6
        n2 = LinkedListHelper.createForward(1295);//    5->9->2
        n3 = addFor1(n1, n2);
        result = LinkedListHelper.toString(n3);
        assertTrue("for1 should be 1912 = " + result, result.equals("1912"));
        
        n1 = LinkedListHelper.createForward(617);//    7->1->6
        n2 = LinkedListHelper.createForward(1295);//    5->9->2
        n3 = addFor2(n1, n2);
        result = LinkedListHelper.toString(n3);
        assertTrue("for2 should be 1912 = " + result, result.equals("1912"));        
    }

}
