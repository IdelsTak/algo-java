/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t01_Arrays_Strings;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andy
 */
public class E8_isRotation {
    public boolean isRot(String s1, String s2){
        int len1 = s1.length();
        if(len1 != 0 && s1.length() == s2.length()){
           String s1s1 = s1 + s1;
           if(s1s1.indexOf(s2)>0){
               return true;
           }
        }
        return false;
    }
    
    @Test
    public void test() {
        assertTrue("", isRot("waterbottle", "erbottlewat"));
        assertFalse("", isRot("waterbottle", "erbottlewae"));
    }
}
