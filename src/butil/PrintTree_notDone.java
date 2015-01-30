/* http://leetcode.com/2010/09/how-to-pretty-print-binary-tree.html

 */

package butil;

import java.util.Iterator;
import java.util.LinkedList;

public class PrintTree_notDone {
	static class BT{
		BT left, right;
		int data;
		BT(int val){
			data = val;
		}
	}

	static int maxHeight(BT p){
		if(null == p) return 0;
		int leftHeight = maxHeight(p.left);
		int rightHeight = maxHeight(p.right);
		return Math.max(leftHeight, leftHeight) + 1;
	}

	static String intToString(int val){
		return String.valueOf(val);
	}

	//print the arm branches (eg, /    \ ) on a line
	static void printBranches(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel,	LinkedList<BT> ndQ) {
		String fmt; int w;
		Iterator<BT> iter = ndQ.iterator();
		for (int i = 0; i < nodesInThisLevel / 2; i++) {
			//out << set(w) << "" << ((*iter++) ? "/" : " ");
			w = (i == 0) ? startLen-1 : nodeSpaceLen-2;
			fmt = String.format("%%%ds%%%ds", w, w);
			System.out.print(String.format(fmt, "", null!=iter.next() ? "/" : " "));
			//out << setw(2) << "" << ((*iter++) ? "\\" : " ");
			w = 2*branchLen+2;
			fmt = String.format("%%%ds%%%ds", w, w);
			System.out.println(String.format(fmt, "", null!=iter.next()? "\\" : " "));
		}
		System.out.println("");
	}

// Print the branches and node (eg, ___10___ )
	static void printNodes(int branchLen, int nodeSpaceLen, int startLen, int nodesInThisLevel, LinkedList<BT> ndQ) {
		Iterator<BT> iter = ndQ.iterator();
		String fmt, str1, str2, str3; int w; BT bt;
		for (int i = 0; i < nodesInThisLevel; i++) {
			bt = iter.next();
			//out<<setw(w) << "" << ((*iter && (*iter)->left) ? setfill('_') : setfill(' '));
			fmt = String.format("%%%ds", (i == 0) ? startLen : nodeSpaceLen);
			str1 = String.format(fmt, "");
			if(bt!=null && bt.left!=null) str1 = str1.replace(" ", "_");
    		//out<<setw(w) << ((*iter) ? intToString((*iter)->data) : "");
			fmt = String.format("%%%ds", branchLen+2);
			w = branchLen+2;
			str2 = String.format(fmt, (null!=bt)? intToString(bt.data) : "");
			//out<<((*iter && (*iter)->right) ? setfill('_') : setfill(' ')) << setw(branchLen) << "" << setfill(' ');
			str3 = "";
			if(branchLen>0){
				fmt = String.format("%%%ds", branchLen);
				str3 = String.format(fmt, "");
				if(bt!=null && bt.right!=null) str3 = str3.replace(" ", "_");
			}
			System.out.print(str1 + str2 + str3);
		}
		System.out.println("");
	}


	// Print the leaves only (just for the bottom row)
	static void printLeaves(int indentSpace, int level, int nodesInThisLevel, LinkedList<BT> ndQ){ //, ostream& out) {
		Iterator<BT> iter = ndQ.iterator();
		int w; String str, fmt; BT bt;
		for (int i = 0; i < nodesInThisLevel; i++) {
			w = (i == 0) ? (indentSpace+2) : (2*level+2);
			fmt = String.format("%%%ds", w);
			bt = iter.next();
			//System.out.println(fmt);//------------------
			str = String.format(fmt, (bt != null) ? intToString(bt.data) : "");
			System.out.print(str);
		}
		System.out.println("");
	}


	/* Pretty formatting of a binary tree to the output stream
		@ param
	level: Control how wide you want the tree to sparse
			(eg, level 1 has the minimum space between nodes, while level 2 has a larger space between nodes)
	indentSpace: Change this to add some indent space to the left
			(eg, indentSpace of 0 means the lowest level of the left node will stick to the left margin)*/
	static void printPretty(BT root, int level, int indentSpace) {
		int h = maxHeight(root);
		int nodesInThisLevel = 1;
		// eq of the length of branch for each node of each level
		int branchLen = 2*((int)Math.pow(2.0,h)-1) - (3-level)*(int)Math.pow(2.0,h-1);
		// distance between left neighbor node's right arm and right neighbor node's left arm
		int nodeSpaceLen = 2 + (level+1)*(int)Math.pow(2.0,h);
		// starting space to the first node to print of each level (for the left most node of each level only)
		int startLen = branchLen + (3-level) + indentSpace;
		LinkedList <BT> ndQ = new LinkedList<>();
		ndQ.addLast(root);
		for (int r = 1; r < h; r++) {
			printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, ndQ);//, out);
			branchLen = branchLen/2 - 1;
			nodeSpaceLen = nodeSpaceLen/2 + 1;
			startLen = branchLen + (3-level) + indentSpace;
			printNodes(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, ndQ);//, out);
			for (int i = 0; i < nodesInThisLevel; i++) {
				BT currNode = ndQ.removeFirst();
				if (currNode !=null) {
					ndQ.addLast(currNode.left);
					ndQ.addLast(currNode.right);
				} else {
				  ndQ.addLast(null);
				  ndQ.addLast(null);
				}
			}//for
			nodesInThisLevel *= 2;
		}
		printBranches(branchLen, nodeSpaceLen, startLen, nodesInThisLevel, ndQ);//, out);
		printLeaves(indentSpace, level, nodesInThisLevel, ndQ);//, out);
	}

	public static void main(String[] arg){
		BT root = new BT(30);
		root.left = new BT(20);
		root.right = new BT(40);
		root.left.left = new BT(10);
		root.left.right = new BT(25);
		root.right.left = new BT(35);
		root.right.right = new BT(50);
		root.left.left.left = new BT(5);
		root.left.left.right = new BT(15);
		root.left.right.right = new BT(28);
		root.right.right.left = new BT(41);

		System.out.println("Tree pretty print with level=1 and indentSpace=0\n");
		// Output to console
		printPretty(root, 1, 0);

		System.out.print("\n\nTree pretty print with level=5 and indentSpace=3,\noutput to file \"tree_pretty.txt\".\n\n");
		// Create a file and output to that file 		ofstream fout("tree_pretty.txt");
		// Now print a tree that's more spread out to the file
		//printPretty(root, 5, 0);
	}
}


/*
        ______30______
       /              \
    __20__          __40__
   /      \        /      \
  10      25      35      50
 /  \       \            /
 5  15      28          41


              ______________30______________
             /                              \
      ______20______                  ______40______
     /              \                /              \
  __10__            25__            35            __50
 /      \               \                        /
 5      15              28                      41
*/