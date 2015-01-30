/*
Solutions to http://www.careercup.com/question?id=6195668792115200

 Write an algorithm to find the ‘next’ node (e.g., post-order successor) of
 a given node in a binary tree and binary search tree
 a.) where each node has a link to its parent.
 b.) without parent pointer

 implement 2 versions of the algorithm: 1.) binary tree 2.) BST
 */
package google_interview;

import butil.TreeNode;
import butil.TreeUtil;
import butil.WrapBool;
import java.util.Stack;

public class E40518_NextTreeNode {

	//for post order search, binary tree, complicity O(n)
	public static class Sol_1_my {//<editor-fold defaultstate="collapsed" desc="comment">

		public static TreeNode next_BT(TreeNode root, TreeNode target, WrapBool found) {
			if (root == null) {
				return null;
			}
			if (root.data == target.data) {
				found.b = true;
				return null;
			}
			if (found.b) {
				return root;
			}

			TreeNode foundNode = next_BT(root.left, target, found);
			if (null == foundNode) {
				foundNode = next_BT(root.right, target, found);
				if (null == foundNode && found.b) {
					foundNode = root;
				}
			}
			return foundNode;
		}
	}//</editor-fold>

	//Binary Search Tree
	public static class Sol_2_my {//<editor-fold defaultstate="collapsed" desc="comment">
		public static TreeNode<Integer> next_BST(TreeNode<Integer> root, TreeNode<Integer> target) {
			Stack<TreeNode> stack = new Stack<>();
			//find the node
			while (root != null && target.data != root.data) {
				stack.push(root);
				if (target.data <= root.data) {
					root = root.left;
				} else {
					root = root.right;
				}
			}//
			//find the next node of this node
			if (null == root) {
				return null;
			} else {//found the node
				TreeNode<Integer> parent = stack.size() > 0 ? stack.pop() : null;
				if (parent == null) {
					return null;
				}
				if (parent.right == root
					|| (parent.left == root && parent.right == null)) {
					return parent;
				}
				return next_BST(parent.right);
			}
		}//method

		static TreeNode<Integer> next_BST(TreeNode<Integer> root) {
			if (root == null) {
				return null;
			}
			while (root.left != null) {
				root = root.left;
			}
			return root;
		}
	}//</editor-fold>

	public static void main(String argv[]) {
		//create post trav tree
		Integer[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		//For binary tree
		TreeUtil.Icreate<Integer> creator = (new TreeUtil()).new Creator_myOptimized_post<>();
		TreeNode<Integer> root = creator.create(ints);

		System.out.println("Non binary search tree");
		for (int i = -5; i < ints.length + 1; i++) {
			TreeNode n = Sol_1_my.next_BT(root, new TreeNode(i), new WrapBool());
			if (null != n) {
				System.out.printf(" %d ", n.data);
			} else {
				System.out.print(" N ");
			}
		}//for

		//For binary search tree
		//create tree
		System.out.println("\n\nbinary search tree");
		//  Integer[] ints = {0, 1, 2, 3, 4, 5, 6,  7, 8, 9};
		Integer[] expected = {2, 4, 1, 7, 5, 3, -1, 9, 6, 8};
		creator = (new TreeUtil()).new Creator_myOptimized_in<>();//create binary search tree
		root = creator.create(ints);
		//search tree
		TreeNode n;
		for (int i = 0; i < expected.length; i++) {
			n = Sol_2_my.next_BST(root, new TreeNode(i));
			System.out.printf(" %d ", (null != n) ? n.data : -1);
		}
	}//main
}
