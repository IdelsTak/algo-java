/*
Solutions to  http://www.careercup.com/question?id=5749537700315136

 Traveler wants to travel from city “A” to city “D”.
 There is a path from city “A” to city “D”.
 Path consists of steps, i.e. travel from city “A” to city “B”.
 Path is encoded as sequence of steps.
 Sequence is in incorrect order.
 Your task is to restore order of steps in the path.
 Input (unordered sequence):
 C -> D
 A -> B
 B -> C
 Output (Correctly ordered list which represents path):
 A, B, C, D

 Implement following API:

 class Step {
 String start;
 String finish;
 };

 class Node {
 String value;
 Node next;
 }

 List<String> findPath(List<Step> steps) {
 }

 Sol_1: use two Map
 Sol_2: create map:use topological sort
 */
package google_interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class E40620_Path {

	static class Step {

		String start;
		String finish;

		Step(String a, String b) {
			this.start = a;
			this.finish = b;
		}
	}

	static class Node {

		String value;
		Node next;
	}

	public static void main(String[] arg) {
		List<Step> steps = new ArrayList<Step>();
		steps.add(new Step("C", "D"));
		steps.add(new Step("A", "B"));
		steps.add(new Step("B", "C"));
		List<String> list = Sol_1.findPath(steps);
		butil.Print.printList(list);
	}

	public static class Sol_1 {//<editor-fold defaultstate="collapsed" desc="use mapping">
		/*
		 create linked list from A->D
		 inorder for quicker insert, use map<String, Node>
		 output the result
		 */

		static List<String> findPath(List<Step> steps) {
			HashMap<String, String> mapFor = new HashMap<>();
			HashMap<String, String> mapRev = new HashMap<>();
			//put into map
			for (Step step : steps) {
				mapRev.put(step.finish, step.start);
				mapFor.put(step.start, step.finish);
			}
			//find the first node
			String first = mapFor.get(steps.get(0).start);
			while (mapRev.containsKey(first)) {
				first = mapRev.get(first);
			}
			//find the path
			List<String> list = new LinkedList<>();
			String next = first;
			for (; mapFor.containsKey(next); next = mapFor.get(next)) {
				list.add(next);
			}
			list.add(next);
			return list;
		}
	}//</editor-fold>

	public static class Sol_2 {
		//all steps is an untion, merget the union
	}

}
