/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t17_ModerateSolutions;

/**
 *
 * @author andy
 */
public class E12_BiNode_Dlink_2_BiTree {

	BiNode getTree(BiNode head) {
		if (head == null) {
			return null;
		}
		BiNode tail = head;
		while (null != tail.right) {
			tail = tail.right;
		}
		return getTree(head, tail);
	}

	BiNode getTree(BiNode head, BiNode end) {
		BiNode mid = getMiddle(head, end);
		if (mid != null) {
			mid.left = getMiddle(head, mid.left);
			mid.right = getMiddle(mid.right, end);
		}
		return null;
	}

	BiNode getMiddle(BiNode head, BiNode tail) {
		BiNode result;
		if ((null != head) && (null != tail)) {
			result = getMiddle(head.right, head.left);
		} else {
			result = (null != head) ? head : tail;
		}
		return result;
	}
}
