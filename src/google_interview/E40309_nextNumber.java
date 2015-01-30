/*
Solutions to http://www.careercup.com/question?id=4857362737266688
 */

package google_interview;

public class E40309_nextNumber {
	public static void main(String[] arg){
		String[] list = {"52222", "72222", "123"};
		for(String s: list){
			test(s);
		}
	}

	static void test(String a){
		String b = nextInteger(a);
		System.out.printf("%s  %s\n", a, b);
	}

	static String nextInteger(String input){
		//decide wheather add more numbers
		char[] a = input.toCharArray();
		int N = input.length();
		int i = 1;

		while(i<N && a[i]>a[i-1] && a[i]+N-1-i<='9')
			i++;
		if(i==N){
			for(int j = N-1; j>=0;j--){
				if(a[j]+1<='9' && (a[j]+1 + N-1-j)<='9'){
					setRestOfBit(a, j, (char)(a[j]+1));
					return String.valueOf(a);
				}
			}
			//more bit is required
		}else{ //i<N
			if(a[i]<=a[i-1])
				if(a[i-1]+1+ N-1 -i <='9'){
					setRestOfBit(a, i, (char)(a[i-1]+1));
					return String.valueOf(a);
				}
			do{
				--i;
				if(a[i]+1 + N-1 -i<='9'){
					setRestOfBit(a, i, (char)(a[i-1]+1));
					return String.valueOf(a);
				}
			}while(i>0);
		}//for
		if(N<9){
			a = new char[N+1];
			for(int j = 0; j<N+1; j++){
				a[j] = (char)('1'+j);
			}
			return String.valueOf(a);
		}

		return "";
	}//method

	private static void setRestOfBit(char[] a, int i, char val){
		for(int j = i; j<a.length; j++)
			a[j] = (char) (val + j - i);
	}

}
