/*
Solutions to http://www.careercup.com/question?id=5178446623801344

 Given a string with multiple spaces write a function to in-place trim all spaces leaving a single space between words
 e.g.
 _ _ _ Hello _ _ _ World _ _ _
 Hello _ World _ _ _ _ _ _ _ _ _
 */
package google_interview;

/**
 *
 * @author andy
 */
public class E40609_TrimSpace {

	public static void main(String[] arg) {
		System.out.print(trim("     Hello        World   ".toCharArray()));
		System.out.println("...");
		System.out.print(trim("Hello   World     ".toCharArray()));
		System.out.println("...");
	}

	public static String trim(char[] a) {
		int i = 0, k = 0;
		for (; k < a.length; k++) {
			//find the nonspace first character, @k
			while (k < a.length && a[k] == ' ') {
				k++;
			}
			//copyNonSpaceWord(chs, i, k);
			while (k < a.length && a[k] != ' ') {
				a[i++] = a[k++];
			}//addSpace(chs, i, k);
			if (k < a.length && i < a.length) {
				a[i++] = ' ';
			}
		}
		int len = i;
		if (a[i - 1] == ' ') {
			len = i - 1;
		}
		return new String(a, 0, len);
	}//trim
}