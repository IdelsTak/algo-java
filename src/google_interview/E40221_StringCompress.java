/*
Solutions to http://www.careercup.com/question?id=u5157655484039168
You are given a string FOOFIGHTERS. You have to come up with an algorithm that will compress this string.

You also have to make sure that you are not using extra memory. For example: FOOFIGHTERS will be compressed as FO2FIGHTERS. You should not use another array or bitfield to keep a frequency count for the individual letters.

FOOOFOOOIGHHTERS
 */

package google_interview;

import java.util.Stack;

public class E40221_StringCompress {
	public static void main(String[] arg){
		String str = "FOOOFOOOIGHHTTTTTTERS";
		System.out.println(str);
		char[] a = str.toCharArray();
		int len = compress(a);
		for(int i = 0; i<len; i++)
			System.out.print(a[i]);
		System.out.println();
	}

	//return the length
	public static int compress(char[] a){
		int i0 = 0, i1=0, j=i0;
		int N = a.length;
		while(i0<N){
			//count
			for(j = i0+1; j<N && a[j]==a[i0]; ) j++;
			j--;
			int n=j-i0 +1;
			//set compress bit
			if(n>2){
				Stack<Integer> stack = new Stack<>();
				while(n>0){
					stack.push(n%10);
					n = n/10;
				}
				a[i1++] = a[i0];
				while(!stack.isEmpty())
					a[i1++] = (char) ('0'+stack.pop());
			}else{
				for(int k = i0; k<=j; k++)
					a[i1++] = a[k];
			}//if
			i0 = j+1;
		}//while
		return i1;
	}
}
