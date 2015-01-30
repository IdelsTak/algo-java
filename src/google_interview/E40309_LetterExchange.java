/*
Solutions to http://www.careercup.com/question?id=5766198755065856

You are given a string which has numbers and letters. Numbers occupy all odd positions and letters even positions. You need to transform this string such that all letters move to front of array, and all numbers at the end.

The relative order of the letters and numbers needs to be preserved

I need to do this in O(n) time and O(1) space.

eg: a1b2c3d4 -> abcd1234 , x3y4z6 -> xyz346

Please don't submit your answers if it is not fulfilling the time-space complexity requirements.
 */

package google_interview;

/*
a1b2c3d4
abcd1234

let n len,
N_numbers = len/2 (4, in this case)
N_letters = len - len/2

if i is original order, we can calculate new order
	if(i%2==1)	pos = i%2;
	else		pos = N_letters + i/2;
if i is new character, we can calculate the source
	if(i<N_Letters)  src = 2*i
	else			 src = (i - N_Letters) *2 +1;
*/

public class E40309_LetterExchange {
	public static void main(String[] arg){
		E40309_LetterExchange letter = new E40309_LetterExchange();
		char[] a4 = "a1b2c3d4".toCharArray();
		letter.shift(a4);
		System.out.println(String.valueOf(a4));
		char[] a8 = "a1b2c3d4e5f6g7h8".toCharArray();
		letter.shift(a8);
		System.out.println(String.valueOf(a8));
	}

	int N_letters;

	int calSrcLoc(int dstLoc){
		int srcLoc;
		if(dstLoc<N_letters) srcLoc = 2*dstLoc;
		else srcLoc = (dstLoc - N_letters)*2+1;
		return srcLoc;
	}

	int calDstLoc(int srcLoc){
		int destLoc;
		if(srcLoc%2==0) destLoc = srcLoc/2;
		else destLoc = N_letters + srcLoc/2;
		return destLoc;
	}

	public void shift(char[] a){
		int N = a.length,  //length
			dstLoc = 1,		//space location, where data is removed
			srcLoc;
		N_letters = N - N/2;
		char tmp = a[dstLoc];		a[dstLoc] = ' ';//for debug
		int tmpDest = calDstLoc(dstLoc);
		while(true){
			if(dstLoc == tmpDest){
				a[dstLoc] = tmp;
				int i = dstLoc+1;
				for(; i<N; i++){
					if((i>N_letters && Character.isLetter(a[i])) ||
						(i<N_letters && Character.isDigit(a[i])) ){
						dstLoc = i;
						tmp = a[dstLoc];		a[dstLoc] = ' ';//for debug
						tmpDest = calDstLoc(dstLoc);
						break;
					}
				}
				if(i == N) return;
			}

			srcLoc = calSrcLoc(dstLoc);
			a[dstLoc] = a[srcLoc];
			dstLoc = srcLoc;		a[dstLoc] = ' ';//for debug
		}
	}
}
