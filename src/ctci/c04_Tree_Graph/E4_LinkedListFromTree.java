package t04_Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

public class E4_LinkedListFromTree {
	
	@Test
	public void test(){
		Td node = new Td('A');
		LinkedList<LinkedList<Td>> lists = new LinkedList<>();
		//solutoin 1
		Queue<Td> nodes = new LinkedList<>();
		nodes.add(node);
		createLists_1(nodes, lists);
		//solution 2
		lists.clear();
		createLists_2(node, lists, 0);
	}

	/*
	Solution 1
	*/
	private void createLists_1(Queue<Td> nodes, 
		LinkedList<LinkedList<Td>> lists) {
		
		LinkedList<Td> list = new LinkedList<>();
		nodes.stream().forEach(	(node) -> {	list.add(node); });
		lists.add(list);
		
		Queue<Td> nextQueue = getNextLevelNodes(nodes);
		if(nextQueue.size()>0)
			createLists_1(nextQueue, lists);
	}
	
	private Queue<Td> getNextLevelNodes(Queue<Td> nodes){
		Queue<Td> nextQueue = new LinkedList<>();
		nodes.stream().forEach(	(node) -> {	
			if(null != node.left) nextQueue.add(node.left);
			if(null != node.right) nextQueue.add(node.right);			 
		});
		return nextQueue;
	}
	
	/*
	Solution 2: DFS,  from book
	*/
	private void createLists_2(Td root, 
		LinkedList<LinkedList<Td>> lists, int level) {
		
		if(root == null) return;
		
		LinkedList<Td> list = null;
		if(lists.size() == level){
			list = new LinkedList<>();
		}else{
			list = lists.get(level);
		}
			
		list.add(root);
		createLists_2(root.left, lists, level +1);
		createLists_2(root.right, lists, level + 1);
	}
	
	/*
	Solution 3: BFS, from book
	*/
	private LinkedList<LinkedList<Td>> createLists_3(Td root){
		LinkedList<LinkedList<Td>> result = new LinkedList<>();
		LinkedList<Td> curr = new LinkedList<>();
		if(root != null) curr.add(root);
		while(curr.size() > 0){
			result.add(curr);
			LinkedList<Td> parent = curr;
			curr = new LinkedList<>();
			for(Td node : parent){
				if(node.left != null) curr.add(node.left);
				if(node.right != null) curr.add(node.right);
			}//for
		}//while
		return result;
	}
	
}
