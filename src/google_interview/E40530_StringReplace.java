/*May 30, 2014
Solutions to http://www.careercup.com/question?id=5192571630387200
 Given a string (for example: "a?bc?def?g"), write a program to generate all the possible strings by replacing ? with 0 and 1.
 Example:
 Input : a?b?c?
 Output: a0b0c0, a0b0c1, a0b1c0, a0b1c1, a1b0c0, a1b0c1, a1b1c0, a1b1c1.
 */

package google_interview;

/**
 *
 * @author andy
 */
public class E40530_StringReplace {

	//Solution_1, no iterative, use digital property
	public static void generate1(char[] chars) {//<editor-fold defaultstate="collapsed" desc="comment">
		System.out.println(">>>>>> Digital");
		int[] locs = new int[chars.length];
		int nQuestion = setReplaceLoc(chars, locs);
		for (int i = 0; i < (1 << nQuestion); i++) {
			for (int j = 0; j < nQuestion; j++)
				chars[locs[j]] = (char) (((int) '0') + ((i >> j) & 1));//get bit j of this i
			System.out.println(String.valueOf(chars));
		}
	}
	private static int setReplaceLoc(char[] str, int[] locs) {
		int num = 0;
		for (int i = 0; i < str.length; i++)
			if (str[i] == '?') {
				locs[num] = i;
				num++;
			}
		return num;
	}//</editor-fold>

	//Solution_2, use iterative array, least copy
	public static void generate2(char[] cs){//<editor-fold defaultstate="collapsed" desc="comment">
		System.out.println(">>>>>> generate2");
		generate2Aux(cs, 0);
	}
	public static void generate2Aux(char[] cs, int i) {
		if (i >= cs.length) {
			System.out.println(String.valueOf(cs));
			return;
		}
		while (i<cs.length && cs[i] != '?')			i++;
		if (i < cs.length) {
			cs[i] = '0';
			generate2Aux(cs, i + 1);//0
			cs[i] = '1';
			generate2Aux(cs, i + 1);//1
			cs[i] = '?';
		}else{
			generate2Aux(cs, i + 1);//means everything is printed, print list
		}

	}//</editor-fold>

	//Solution_3, use string
	public static void generate3(String str) {//<editor-fold defaultstate="collapsed" desc="comment">
		String str0 = str.replaceFirst("?", "0");
		if (str0.equals(str)) {
			System.out.println(str);
		} else {
			generate3(str0);
			String str1 = str.replaceFirst("?", "1");
			generate3(str1);
		}
	}//</editor-fold>

	//@test
	public static void main(String[] argv) {
		char[] str1 = "a?bc?def?g".toCharArray();
		generate1(str1);
		char[] str2 = "a?bc?def?g".toCharArray();
		generate2(str2);
		//generate3(template);
	}
}
