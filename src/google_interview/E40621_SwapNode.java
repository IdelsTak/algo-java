/*
Solutions to  http://www.careercup.com/question?id=5721462438625280
 Swap 2 nodes in a Binary tree.(May or Maynot be a BST)
 Swap the nodes NOT just their values. (preferably in Java please..(My requirement not theirs :p))
 ex:
 .    5
 .  /    \
 . 3     7
 ./\    / \
 2  4  6  8

 swap 7 and 3
 .    5
 .  /   \
 . 3    7
 ./\   / \
 2  4 6  8

swap 3 & 7;
 .    3
 .  /   \
 . 5    4
 ./\
 2 7
 ./ \
 6  8

swap 5 & 7;
.      7
.    /    \
.   6      5
.  / \
. 3  8
./ \
2  4

 */
package google_interview;

public class E40621_SwapNode {

    public static void main(String[] arg) {
        Node r = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        r = Sol_1.swap(r, n1, n2);
        System.out.println(r);
    }

    public static class Node {

        Node left, right;
    }

    public static class Sol_1 {

        //n1 && n2 should not be null
        public static Node swap(Node r, Node n1, Node n2) {
            if (r == null) {
                return null;
            }
            if (r == n1) {
                r = n2;
                if (childSwap(n1, n2)) {
                    return r;
                }
            } else if (r == n2) {
                r = n1;
                if (childSwap(n2, n1)) {
                    return r;
                }
            }
            r.left = swap(r.left, n1, n2);
            r.right = swap(r.right, n1, n2);
            return r;
        }

        //return true if swapped with child
        private static boolean childSwap(Node r, Node c) {
            if (r.left == c) {
                Node cl = c.left;
                c.left = r;
                r.left = cl;
                return true;
            } else if (r.right == c) {
                Node cr = c.right;
                c.right = r;
                r.right = cr;
                return true;
            }
            return false;
        }
    }

}
