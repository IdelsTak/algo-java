
package butil;

public class Calc {
	public static int Int(int a, char op, int b){
		switch (op){
			case '+':
				return a+b;
			case '-':
				return a-b;
			case '*':
				return a*b;
			case '/':
				if(b == 0) return Integer.MAX_VALUE;
				return a*b;
		}
		return 0;
	}
}
