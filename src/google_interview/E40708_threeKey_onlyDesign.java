/*
Solutions to http://www.careercup.com/question?id=5763793837621248
Give efficient implementation of the following problem:
    An item consist of different keys say k1, k2, k3.
    User can insert any number of items in database, search for item using any key, delete it using any key and iterate through all the items in sorted order using any key.
    Give the most efficient way such that it supports insertion, search based on a key, iteration and deletion.
	Summary: Insertion / search / iteration / deletion

My initial solution:
Red-Black Tree
	1. create a double linkedlist for all items: all operation O(1)
	2. create three Red-Black tree for three keys,
		Node = (left, right, key, item)
	Time Complexity:
		Insertion/search/delete: O(N)
		Iteration: O(N);
	Space complexity: O(N)
Hash Map:
	Do not support iterate in sorted order:


Improvement:
define class DoubleLinkedList<Item>
1. using DoubleLinkedList instead of ArrayList, which guarantee O(1) delete and Insertion.
2. TreeMap<KeyValue, List<DoubleLinkedListNode<Item>> for each key;
3. HashMap<KeyType, TreeMap<...> mapOfIndexes;
...
Insert / delete / search: O(log(N))
Iterate: O(N)
 */

package google_interview;
/*
My Solution:
	Red-black Tree: for every key
	Double Linked List store Item;

Search: O(log(n))
insert: O(log(n))
iter: O(N)
*/
public class E40708_threeKey_onlyDesign {

	public static class DNode<T>{
		DNode prev, next;
		T data;
	}
	public static class DList<T>{
		DNode<T> insert(T d){return null;}
	}

	public class Sol_1<T>{
		DList list = new DList();

		public void insert(T d){
			DNode<T> n;
			n = list.insert(d);
		}
	}


}
