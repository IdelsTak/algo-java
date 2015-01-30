package t01_Arrays_Strings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class E3_isPermTest {
	public static boolean isPerm1(String s1, String s2){
		if (s1.length() != s2.length()) return false;
		
		int[] letters = new int[256];
		char[] aS1 = s1.toCharArray();
		for(char s : aS1) letters[(int) s]++;
		
		char[] aS2 = s2.toCharArray();
		for(char s : aS2){
			if(--letters[s] < 0) return false;
		}
		return true;
	}
	
	public static boolean isPerm2(String s1, String s2){
		return sort(s1).equals(sort(s2));
	}
	
	public static String sort(String s){
		char[] str = s.toCharArray();
		java.util.Arrays.sort(str);
		return new String(str);
	}	
    
    @Test
    public void test() {
        assertTrue("isPerm1: abcd, cdab should be permtation", 
            E3_isPermTest.isPerm1("abcd", "cdab"));
        assertTrue("isPerm2: abcd, cdab should be permtation", 
            E3_isPermTest.isPerm2("abcd", "cdab"));
        
        assertFalse("isPerm1: abcd, cdae should not be permtation", 
            E3_isPermTest.isPerm1("abcd", "cdae"));
        assertFalse("isPerm2: abcd, cdae should not be permtation", 
            E3_isPermTest.isPerm2("abcd", "cdae"));        
	}
}
