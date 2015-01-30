package t01_Arrays_Strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class E5_compressTest {
	public static String compress(String s){
		if (s.length() <= 0) return s;
	
		StringBuilder sb = new StringBuilder();
		char[] aC = s.toCharArray();
		int lastI = 0, i;
		for(i = 1; i<aC.length; i++){
			if(aC[i] != aC[lastI]){
				sb.append(aC[lastI]);
				if(i - lastI > 1) sb.append(i-lastI);
				lastI = i;
			}
		}
		
		sb.append(aC[aC.length-1]);
		if(i-lastI>1) sb.append(i-lastI);
		String s2 = sb.toString();
		return (s2.length()<s.length()) ? s2 : s;
	}
	
    @Test
    public void test() {
        assertTrue("", "hello".equals(E5_compressTest.compress("hello")));
        assertTrue("", "a3bcd".equals(E5_compressTest.compress("aaabcd")));
		assertTrue("", "abcd3".equals(E5_compressTest.compress("abcddd")));
		assertTrue("", "abc3d".equals(E5_compressTest.compress("abcccd")));
	}
}
