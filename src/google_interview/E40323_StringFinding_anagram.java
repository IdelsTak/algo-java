/* 
Solutions to http://www.careercup.com/question?id=5389078581215232
Given two strings a and b,
 find whether any anagram of string a
 is a sub-string of string b.

 For eg:
 if a = xyz and b = afdgzyxksldfm
 then the program should return true.
 */

package google_interview;


public class E40323_StringFinding_anagram {
	int[] hash;
	int R = 256;
	int NPat, nPat;

	public static void main(String[] arg){
		String txt = "afdgzyxksldfm";
		String pat = "xyz";
		E40323_StringFinding_anagram finder = new E40323_StringFinding_anagram();
		System.out.println(finder.isContain(txt, pat));
	}

	private void reset(String pat){
		hash = new int[256];
		NPat = pat.length();
		nPat = 0;
		for(int i = 0; i<pat.length(); i++){
			hash[pat.charAt(i)]++;
		}
	}

	public boolean isContain(String txt, String pat){
		reset(pat);
		for(int i = 0; i<txt.length(); i++){
			char c = txt.charAt(i);
			if(hash[c] >0){
				hash[c]--;
				nPat++;
				if(nPat == NPat)
					return true;
			}else if(nPat!=0){
				reset(pat);
			}
		}
		return false;
	}
}
