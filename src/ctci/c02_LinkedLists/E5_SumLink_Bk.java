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
class E5_SumLink_Bk {

    ////////////////////  ///////////////////////
    public LN addRev(LN l1, LN l2, int i) {
        if(l1 == null && l2 == null && i == 0){
            return null;
        }
        LN result = new LN();
        if(l1 != null) result.data += l1.data;
        if(l1 != null) result.data += l1.data;
        result.data += i;
        //recusive
        if(l1 != null || l2 != null){
            LN more = addRev(
                    (l1 == null ? null : l1.next),
                    (l2 == null ? null : l2.next),
                    (result.data > 10 ? 1 : 0)
            );
            result.setNext(more);
        }
        return result;
    }
    
    
    public class LN{
        public int data;
        public LN next;
        public LN prev;
        public LN(){ }
        private void setNext(LN more) { }
    }
    
    @Test
    public void test() {
        E5_SumLink_Bk e = new E5_SumLink_Bk();
        LN l1 = new LN();
        LN l2 = new LN();
        LN l3 = e.addRev(l1, l2, 0);
    }
    
    ////////////////////// 
}
