/*

 */

package t11_Sorting_and_Teaching;

/**
 *
 * @author andy
 */
public class E8_ {

	static class Node {

		int data;
		int rank;
		Node left;
		Node right;

		public Node(int d) {
			this.data = d;
		}

		private void Add(Node node) {
			Node n = node;
			while (n != null) {
				if (n.data <= data) {
					n.rank++;
					n = n.left;
				} else {
					n = n.right;
				}
			}//while
		}//private
	}

	Node root;

	void Track(int x) {
		if (root == null) {
			root = new Node(x);
		} else {
			root.Add(new Node(x));
		}
	}

	int getRankOfNumber(int x) {
		Node n = root;
		while (n != null) {
			if (n.data == x) {
				return n.rank;
			} else if (n.data < x) {
				n = n.left;
			} else {
				n = n.right;
			}
		}
		return -1;
	}

}
