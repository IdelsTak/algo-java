/*
Solutions to http://www.careercup.com/question?id=6253551042953216
1.[][][]
2.[][[]]
3.[[]][]
4.[[][]]
5.[[[]]]

 */

package google_interview;

public class E40225_Brackoutput {
	public static void main(String[] args) {
		pp(3);
	}

	public static void pp(int n) {
		char buf[] = new char[n * 2];
		pp(buf, 0, n, 0, 0);
	}

	public static void pp(char buf[], int idx, int n, int opn, int cls) {
		if (cls == n) {
			System.out.println(new String(buf));
			return;
		}
		if (opn > cls) {
			buf[idx] = ']';
			pp(buf, idx+1, n, opn, cls+1);
		}
		if (opn < n) {
			buf[idx] = '[';
			pp(buf, idx+1, n, opn+1, cls);
		}
	}//pp
}


