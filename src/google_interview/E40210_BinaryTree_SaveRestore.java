/*
Solutions for http://www.careercup.com/question?id=5765091433644032

Given a binary tree, how would you copy it from one machine to the other, 
assume you have a flash drive. I believe we should write the binary tree 
to file and have the other machine de-serialize it. But how should we do it?

based on E40210_BinaryTree_SaveRestore
 */

package google_interview;

import butil.TreeNode;
import butil.TreeUtil;
import java.util.ArrayList;

public class E40210_BinaryTree_SaveRestore {

	public static void main(String[] arg){
		//get tree
		Integer[] ints = butil.SortUtil.getArrayRndObj(0, 10);
		System.out.println(java.util.Arrays.toString(ints));
		TreeNode<Integer> node = TreeUtil.getInorderTree(ints);
		//save
		System.out.println("\n>>>>>>>>>>>>>>>Solution 2");
		String str2_1 = Sol_2.toString(node);
		System.out.println(str2_1);
		//retrieve again
		System.out.println(">>> retrieve tree from string");
		TreeNode<Integer> node2 = Sol_2.toNode(str2_1);
		String str2_2 = Sol_2.toString(node2);
		System.out.println(str2_2);
	}

	static class Sol_2{//<editor-fold defaultstate="collapsed" desc="comment">
		public static String toString(TreeNode<Integer> tn){
			if(tn == null) return "";
			String str = tn.data.toString();
			String strLe = toString(tn.left);
			String strRi = toString(tn.right);
			if(!"".equals(strLe) || !"".equals(strRi)){
				str = String.format("%s(%s,%s)", str, strLe, strRi);
			}
			return str;
		}

		public static TreeNode<Integer> toNode(String s){//<editor-fold defaultstate="collapsed" desc="comment">
			TreeNode<Integer> root = null;
			if(s.indexOf('(')==-1){
				if(!"".equals(s)) root = new TreeNode<>(Integer.parseInt(s));
				return root;
			}

			//extract value
			int idx = s.indexOf('(');
			int value = Integer.parseInt(s.substring(0, idx));
			//remove parenthesis
			s = s.substring(idx+1, s.length()-1);
			//find all brackets and its location
			ArrayList<Integer> parthe = new ArrayList<>();
			ArrayList<Integer> parIdx = new ArrayList<>();
			for(int i = 0; i<s.length(); i++){
				if(s.charAt(i)=='(') {
					parthe.add(1);
					parIdx.add(i);
				} else if(s.charAt(i)==')'){
					parthe.add(-1);
					parIdx.add(i);
				}
			}
			//find the middle location
			int midLoc = 0;
			if(parthe.isEmpty()){
				midLoc = s.indexOf(',');
			}else{
				int sum = 0;
				for(int i = 0; i<parthe.size(); i++){
					sum += parthe.get(i);
					if(sum == 0){
						midLoc = parIdx.get(i) + 1;//this is where "," is located;
						break;
					}
				}//for
			}
			String strLeft = s.substring(0, midLoc);
			String strRight = s.substring(midLoc+1);
			//define node
			TreeNode<Integer> left = toNode(strLeft);
			TreeNode<Integer> right = toNode(strRight);
			root = new TreeNode<>(value, left, right);
			return root;
		}//</editor-fold>

	}//</editor-fold>

}
