/*
 p55, for 3 balls

 move 1:		a  -> b
 move 2:		a  -> c
 move 1:		b  -> c
 move 3:		a  -> b
 move 1:		c  -> a
 move 2:		c  -> b
 move 1:		a  -> b
 */
package ds_yanWeiMi;

import java.util.Stack;

/**
 *
 * @author andy
 */
public class B33_35_Hanoi {

	public static void main(String[] arg) {
		//move 3 discs from a to b, use c as cache
		System.out.println("Sol_1");
		Sol_1.hanoi(3, 'a', 'b', 'c');

		System.out.println("Sol_2");
		Sol_2_loop_not_intuitive.hanoi(3, 'a', 'b', 'c');

	}

	//use iterative, the simplest solution
	public static class Sol_1 {// <editor-fold defaultstate="collapsed" desc="Hidden Code">

		static void hanoi(int n, char a, char b, char c) {
			if (n == 1) {
				move(1, a, b);
			} else {
				hanoi(n - 1, a, c, b);
				move(n, a, b);
				hanoi(n - 1, c, b, a);
			}
		}//hanoi
	}//class

	static void move(int n, char a, char b) {
		System.out.printf("move %d:    %c -> %c\n", n, a, b);
	}
	// </editor-fold>

	//use stack: this code is only the stack implementation of preious algorithm
	//not very initutive
	public static class Sol_2_loop_not_intuitive {// <editor-fold defaultstate="collapsed" desc="Hidden Code">

		public static class Action {

			int n;
			char a, b, c;

			public Action(int n, char a, char b, char c) {
				this.n = n;
				this.a = a;
				this.b = b;
				this.c = c;
			}
		}

		static void hanoi(int n, char a, char b, char c) {
			Stack<Action> s = new Stack<>();
			s.push(new Action(n, a, b, c));
			while (!s.empty()) {
				Action ac = s.pop();
				if (ac.n == 1) {
					move(ac.n, ac.a, ac.b);
				} else {//action one two three, action three first
					s.push(new Action(ac.n - 1, ac.c, ac.b, ac.a));
					s.push(new Action(1, ac.a, ac.b, ac.c));
					s.push(new Action(ac.n - 1, ac.a, ac.c, ac.b));
				}
			}
		}//hanoi
	}// </editor-fold>

}
