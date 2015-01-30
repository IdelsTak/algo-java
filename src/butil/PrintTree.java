/* BasedOn  http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
 */

package butil;

import java.util.ArrayList;

public class PrintTree {

	static class BT<T>{
		BT left, right;
		T d;
		BT(T val){
			d = val;
		}
	}


	public static class Printer<T>{
		public void print(BT<T> t) {
			print(t, "", true);
		}

		private void print(BT<T> t, String prefix, boolean isTail) {
			System.out.println(prefix + (isTail ? "└── " : "├── ") + t.d);
			ArrayList<BT<T>> children = new ArrayList<>();
			children.add(t.left);
			children.add(t.right);
			for (int i = 0; i < children.size() - 1; i++) {
				print(children.get(i), prefix + (isTail ? "    " : "│   "), false);
			}
			if (children.size() >= 1) {
				print(children.get(children.size() - 1), prefix + (isTail ?"    " : "│   "), true);
			}
		}//print
	}
}
