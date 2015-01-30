/*
Solutions to http://www.careercup.com/question?id=5924407818059776

Given a complete binary tree, print the outline of the tree in
anti-clockwise direction, starting from the root.
I.e. first print all the nodes on the left

edge of the tree going downwards,
then print all the leaves going left to right
(including leaves on both the last and the 2nd last level if necessary),
then
print the nodes on the right edge of the tree going upwards.

Example tree:
A
/ \
/ \
B C
/ \ / \
D E F G
/ \ /
H I J

Expected Output: ABDHIJFGC
 */

package google_interview;

public class E40618_antiClockWise_BST {

	static class Node{
		Node left, right;
		char data;
		public Node(char d, Node l, Node r){
			this.data = d;
			this.left = l;
			this.right = r;
		}

		public Node(char d){
			this(d, null, null);
		}
	}


	/*
	solution 1: 1. print left, leaf, right
	    for this solution, it's unnecessary to complete
	*/
	public static class Sol_1{//<editor-fold defaultstate="collapsed" desc="sol_1">
		public void print(Node r){
			printLeft(r);
			printLeaf(r);
			printRight(r.right);
			System.out.println("");
		}

		private void printLeft(Node r) {
			for(;r.left!=null;r=r.left)
				System.out.print(r.data);
		}
		private void printRight(Node r) {
			if(r == null || r.right==null) return;
			printRight(r.right);
			System.out.print(r.data);
		}
		private void printLeaf(Node r) {
			if(r == null) return;
			if(r.left != null) printLeaf(r.left);
			if(r.right != null) printLeaf(r.right);
			if(r.left==null && r.right==null ) System.out.print(r.data);
		}
	}//</editor-fold>

	/*
	//maintain list of node in every layer
	*/
	public static class Sol_2{
		public void print(Node r){
		}
	}//sol_2

	public static void main(String[] a){
		Node root = getSampleTree();
		Sol_1 s1 = new Sol_1();
		s1.print(root);
		Sol_2 s2 = new Sol_2();
		s2.print(root);
	}

	public static Node getSampleTree(){
		Node D = new Node('D', new Node('H'), new Node('I'));
		Node E = new Node('E', new Node('J'), null);
		Node B = new Node('B', D, E);
		Node C = new Node('C', new Node('F'), new Node('G'));
		Node A = new Node('A', B, C);
		return A;
	}
}
