/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t17_ModerateSolutions;

/* pseudo code
convert(BiNode root){
 .	left = convert(root.left);
 .	right = convert(root.right);
 .	mergeList(left, root, right);
 .	return left;
 }

 */
public class E12_BiNode_BiTree_2_Dlink {

	BiNode convert(BiNode root) {
		if (root == null) {
			return null;
		}
		BiNode left = convert(root.left);
		BiNode right = convert(root.right);
		//merge
		root.left = left;
		root.right = right;
		BiNode head;
		if (left != null) {
			left.right = root;
		}
		if (right != null) {
			right.left = root;
		}

		return (left != null) ? left : root;
	}
}
