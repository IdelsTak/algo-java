/*

 */

package ds_yanWeiMi;

import java.util.ArrayList;
import java.util.Stack;

/**
 * TODO: not tested
 */
public class B325_exprEvaluation {

	public static class Sol_1 {

		String run(String str) {
			Stack<String> optr = new Stack<>();
			Stack<String> opnd = new Stack<>();
			Expr expr = new Expr(str);
			int result = 0, i = 0;
			String op = expr.get(i++);
			for (; op != null && (!(op.equals("#") || optr.peek().equals("#"))); op = expr.get(i++)) {
				if (Expr.isOpnd(op)) {
					opnd.push(op);
				} else {
					char prec = Expr.precede(op, optr.pop());
					switch (prec) {
						case '<':
							optr.push(op);
							break;
						case '=':
							optr.pop();
							break;
						case '>':
							String a = opnd.pop();
							String b = opnd.pop();
							String optr1 = optr.pop();
							opnd.push(Expr.operate(a, optr1, b));
							optr.push(op);
							break;
					}//switch
				}//if
			}//for
			return opnd.pop();
		}//run

		public static class Expr extends ArrayList<String> {

			final static String OPTR = "+-*/()";
			final String expr;

			public Expr(String str) {
				this.expr = str;
				int prevIdx = 0;
				for (int i = 0; i < expr.length(); i++) {
					if (isOpnd(expr.charAt(i))) {
						this.add(str.substring(prevIdx, i));
						this.add(str.substring(i, i + 1));
						prevIdx = i + 1;
					}
				}//for
				if (prevIdx < expr.length()) {
					this.add(str.substring(prevIdx));
				}
			}

			static boolean isOpnd(char c) {
				return OPTR.indexOf(c) >= 0;
			}

			static boolean isOpnd(String c) {
				return OPTR.indexOf(c) >= 0;
			}//isOpnd

			static char precede(String oldOptr, String newOptr) {
				if (oldOptr.equals(newOptr)) {//even same, calc the oldOptr first
					return '>';
				}
				return '<';//tobeImpl
			}//isPrecede

			static String operate(String a, String op, String b) {
				return "";//tobeImpl
			}
		}//class expr
	}
}
