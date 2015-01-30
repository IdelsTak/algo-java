/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package butil;

public class TreeUtil {

	public interface Icreate<T> {

		public abstract TreeNode<T> create(T[] a);
	}

	public abstract class Creator_myOptimized_common<T> implements TreeUtil.Icreate<T> {

		public int getLeftSideNode(int nodeToCreate) {
			int nLeft;
			if (nodeToCreate <= 1) {
				nLeft = 0;
			} else if (1 < nodeToCreate && nodeToCreate <= 3) {
				nLeft = 1;
			} else {
				int nLevel = (int) Math.ceil(Math.log(nodeToCreate + 1) / Math.log(2));
				if (nodeToCreate == (int) Math.pow(2, nLevel) - 1) {//full true
					nLeft = (int) Math.pow(2, nLevel - 1) - 1;
				} else {
					int nLastLevel = nodeToCreate - (int) Math.pow(2, nLevel - 1) + 1;
					if (nLastLevel > (int) Math.pow(2, nLevel - 2)) {
						nLeft = (int) Math.pow(2, nLevel - 1) - 1;
					} else {
						nLeft = (int) Math.pow(2, nLevel - 2) - 1 + nLastLevel;
					}
				}
			}
			return nLeft;
		}

		@Override
		public TreeNode<T> create(T[] a) {
			return create(a, a.length, new WrapInt());
		}

		abstract TreeNode<T> create(T[] a, int nodeToCreate, WrapInt wi);
	}

	public /*static*/ class Creator_myOptimized_pre<T> extends Creator_myOptimized_common<T> {

		@Override
		TreeNode create(Object[] a, int nodeToCreate, WrapInt wi) {
			if (wi.n >= a.length) {
				return null;
			}
			int nLeft = getLeftSideNode(nodeToCreate);
			TreeNode node = new TreeNode<>(a[wi.n++]);
			node.left = create(a, nLeft, wi);
			node.right = create(a, nodeToCreate - nLeft - 1, wi);
			return node;
		}
	}

	public /*static*/ class Creator_myOptimized_in<T> extends Creator_myOptimized_common<T> {

		@Override
		TreeNode<T> create(T[] a, int nodeToCreate, WrapInt wi) {
			if (wi.n >= a.length || nodeToCreate == 0) {
				return null;
			}
			int nLeft = getLeftSideNode(nodeToCreate);
			TreeNode<T> left = create(a, nLeft, wi);
			TreeNode<T> root = new TreeNode<>(a[wi.n++], left, null);
			root.right = create(a, nodeToCreate - nLeft - 1, wi);
			return root;
		}
	}

	public /*static*/ class Creator_myOptimized_post<T> extends Creator_myOptimized_common<T> {

		@Override
		TreeNode<T> create(T[] a, int nodeToCreate, WrapInt wi) {
			if (wi.n >= a.length || nodeToCreate == 0) {
				return null;
			}
			int nLeft = getLeftSideNode(nodeToCreate);
			TreeNode<T> left = create(a, nLeft, wi);
			TreeNode<T> right = create(a, nodeToCreate - nLeft - 1, wi);
			TreeNode<T> tn = new TreeNode<>(a[wi.n++], left, right);
			return tn;
		}
	}

	// <editor-fold defaultstate="collapsed" desc="preOrder, inOrder, postOrder Traverse">
	public interface Iter<T> {

		public abstract void run(TreeNode<T> node);
	}

	public /*static*/ class Iter_pre<T> implements Iter<T> {

		@Override
		public void run(TreeNode<T> node) {
			if (node == null) {
				return;
			}
			System.out.print(node.data);
			run(node.left);
			run(node.right);
		}
	}

	public /*static*/ class Iter_in<T> implements Iter<T> {

		@Override
		public void run(TreeNode<T> node) {
			if (node == null) {
				return;
			}
			run(node.left);
			System.out.print(node.data);
			run(node.right);
		}
	}

	public /*static*/ class Iter_post<T> implements Iter<T> {

		@Override
		public void run(TreeNode<T> node) {
			if (node == null) {
				return;
			}
			run(node.left);
			run(node.right);
			System.out.print(node.data);
		}
	}

//	public /*static*/ class NotOptimized {
//// <editor-fold defaultstate="collapsed" desc="My not optimized implementation">
//	public static void testMyNotOptimized() {
//		Integer[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//		TreeNode<Integer> root;
//		System.out.println("\n INVALID  Pre Order");
//		root = Creator_my_TestedToBeInvalid.preOrder(ints, 0);
//		Traverse.preOrder(root);
//
//		System.out.println("\n INVALID  In Order");
//		root = Creator_my_TestedToBeInvalid.inOrder(ints, 0, ints.length - 1);
//		Traverse.inOrder(root);
//
//		System.out.println("\n INVALID  Post Order");
//		root = Creator_my_TestedToBeInvalid.postOrder(ints, 0, ints.length - 1);
//		Traverse.postOrder(root);
//		System.out.println("\nend\n");
//
//		//My Sub OPtimized
//		System.out.println("\n Pre Order");
//		root = Creator_my_subOptimized.preOrder(ints);
//		Traverse.preOrder(root);
//
//		System.out.println("\n In Order");
//		root = Creator_my_subOptimized.inOrder(ints);
//		Traverse.inOrder(root);
//
//		System.out.println("\n Post Order");
//		root = Creator_my_subOptimized.postOrder(ints);
//		Traverse.postOrder(root);
//		System.out.println("\nend\n");
//	}
//
//	public /*static*/ class Traverse {
//
//		public static <T> void preOrder(TreeNode<T> node) {
//			if (node == null) {
//				return;
//			}
//			System.out.print(node.data);
//			preOrder(node.left);
//			preOrder(node.right);
//		}
//
//		public static <T> void inOrder(TreeNode<T> node) {
//			if (node == null) {
//				return;
//			}
//			inOrder(node.left);
//			System.out.print(node.data);
//			inOrder(node.right);
//		}
//
//		public static <T> void postOrder(TreeNode<T> node) {
//			if (node == null) {
//				return;
//			}
//			postOrder(node.left);
//			postOrder(node.right);
//			System.out.print(node.data);
//		}
//	}
//
//	//improved method, create the tree first, then set the values
//	public /*static*/ class Creator_my_subOptimized {
//
//		public static <T> TreeNode<T> preOrder(T[] a) {
//			if (a == null || a.length == 0) {
//				return null;
//			}
//			TreeNode<T> node = create(a[0], 0, a.length);
//			preOrder(node, a, new WrapInt());
//			return node;
//		}
//
//		public static <T> TreeNode<T> inOrder(T[] a) {
//			if (a == null || a.length == 0) {
//				return null;
//			}
//			TreeNode<T> node = create(a[0], 0, a.length);
//			inOrder(node, a, new WrapInt());
//			return node;
//		}
//
//		public static <T> TreeNode<T> postOrder(T[] a) {
//			if (a == null || a.length == 0) {
//				return null;
//			}
//			TreeNode<T> node = create(a[0], 0, a.length);
//			postOrder(node, a, new WrapInt());
//			return node;
//		}
//
//		public static <T> TreeNode<T> create(T value, int n, int size) {
//			if (n >= size) {
//				return null;
//			}
//			TreeNode<T> root = new TreeNode<>(value);
//			root.left = create(value, 2 * n + 1, size);
//			root.right = create(value, 2 * n + 2, size);
//			return root;
//		}
//
//		public static <T> void preOrder(TreeNode<T> node, T[] a, WrapInt wi) {
//			if (node == null) {
//				return;
//			}
//			node.data = a[wi.n++];
//			preOrder(node.left, a, wi);
//			preOrder(node.right, a, wi);
//		}
//
//		public static <T> void inOrder(TreeNode<T> node, T[] a, WrapInt wi) {
//			if (node == null) {
//				return;
//			}
//			inOrder(node.left, a, wi);
//			node.data = a[wi.n++];
//			inOrder(node.right, a, wi);
//		}
//
//		public static <T> void postOrder(TreeNode<T> node, T[] a, WrapInt wi) {
//			if (node == null) {
//				return;
//			}
//			postOrder(node.left, a, wi);
//			postOrder(node.right, a, wi);
//			node.data = a[wi.n++];
//		}
//	}
//
//	public /*static*/ class Creator_my_TestedToBeInvalid {
//
//		public static <T> TreeNode preOrder(T[] a, int n) {
//			if (n > a.length - 1) {
//				return null;
//			}
//			TreeNode<T> root = new TreeNode<>(a[n]);
//			root.left = preOrder(a, 2 * n + 1);
//			root.right = preOrder(a, 2 * n + 2);
//			return root;
//		}
//
//		private static int getMidPos_inOrder(int low, int high) {
//			int allNodes = high + 1 - low;
//			int levels = (int) Math.ceil(Math.log(allNodes) / Math.log(2));
//			int mid;
//			if (allNodes == (int) Math.pow(2, levels) - 1) {
//				mid = low + allNodes / 2;
//			} else {
//				int fullTreeNodes = (int) Math.pow(2, levels - 1) - 1;
//				int secondToLastNodes = (fullTreeNodes + 1) / 2;
//				int lastLevelNodes = allNodes - fullTreeNodes;
//				if (lastLevelNodes >= secondToLastNodes) {//left tree is full, right tree have extra nodes
//					mid = low + fullTreeNodes;//left tree have fullTreeNodes
//				} else {
//					mid = low + lastLevelNodes + secondToLastNodes - 1;
//				}
//			}
//			return mid;
//		}
//
//		public static <T> TreeNode inOrder(T[] a, int low, int high) {
//			if (low > high) {
//				return null;
//			}
//			if (low == high) {
//				return new TreeNode<>(a[low]);
//			}
//			int mid = getMidPos_inOrder(low, high);
//			TreeNode<T> node = new TreeNode<>(a[mid]);
//			node.left = inOrder(a, low, mid - 1);
//			node.right = inOrder(a, mid + 1, high);
//
//			return node;
//		}
//
//		public static <T> TreeNode postOrder(T[] a, int low, int high) {
//			if (low > high) {
//				return null;
//			}
//			if (low == high) {
//				return new TreeNode<>(a[low]);
//			}
//			TreeNode<T> node = new TreeNode<>(a[high]);
//			int mid = getMidPos_inOrder(low, high);
//			node.left = postOrder(a, low, mid - 1);
//			node.right = postOrder(a, mid, high - 1);
//			return node;
//		}
//	}// </editor-fold>
//	}

	/*
	Integer[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	*/
	public static TreeNode<Integer> getInorderTree(Integer[] ints){
		TreeUtil util = new TreeUtil();
		Icreate<Integer> creaters = util.new Creator_myOptimized_in<>();
		TreeNode<Integer> root = creaters.create(ints);
		return root;
	}

	public static void main(String[] argv) {//Character[] chars = "abcdefghijk".toCharArray();
		//NotOptimized.testMyNotOptimized();
		//My Invalid
		TreeUtil util = new TreeUtil();
		Integer[] ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeNode<Integer> root;

		Icreate<Integer>[] creaters = new Icreate[3];
		Iter<Integer>[] iters = new Iter[3];

		creaters[0] = util.new Creator_myOptimized_pre<>();
		creaters[1] = util.new Creator_myOptimized_in<>();
		creaters[2] = util.new Creator_myOptimized_post<>();
		iters[0] = util.new Iter_pre<>();
		iters[1] = util.new Iter_in<>();
		iters[2] = util.new Iter_post<>();

		System.out.println("test optimized\n");
		for (int i = 0; i < creaters.length; i++) {
			System.out.println("");
			root = creaters[i].create(ints);
			iters[i].run(root);
		}
	}
}
