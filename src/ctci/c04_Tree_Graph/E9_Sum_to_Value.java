package t04_Tree_Graph;

import org.junit.Test;

public class E9_Sum_to_Value {

	/* =================================================
	
	My Solution: Print all path and its value:	
	
	*/
	class ValuePath{
		String sumC = "";
		String path = "";
		
		void add(char c){
			sumC += c;
			path += " -> " + c;			
		}
		
		@Override
		public String toString(){			//return Integer.toString(sum) + " : " + path;
			return sumC + " : " + path;
		}
		
		@Override
		public ValuePath clone() throws CloneNotSupportedException{
			ValuePath vp = new ValuePath();
			vp.path = path; vp.sumC = sumC;
			return vp;
		}
	}
	
	//pre-order traversal
	void printHelper_my(Td r, String expected, ValuePath vp) throws CloneNotSupportedException{
		if(r != null) {
			vp.add(r.data);
			if(expected.equals(vp.sumC)) System.out.println(vp);
			printHelper_my(r.left, expected, vp.clone());
			printHelper_my(r.right, expected, vp.clone());
		}
	}
	
	//in-order traversal
	void print_my(Td r, String expected) throws CloneNotSupportedException{
		if(r != null){
			print_my(r.left, expected);
			printHelper_my(r, expected, new ValuePath());
			print_my(r.right, expected);
		}
	}
	
	/* =================================================
	
	Solution 2: Solution from book
	
	*/
	void printPath_bk(Td r, int expected){
		if(null != r) {
			int depth = getMaxDepth(r);
			int[] path = new int[depth];
			printPathHelper_bk(r, expected, path,0);
		}
	};
	
	private void printPathHelper_bk(Td r, int expected, int[]path, int i) {
		if(null == r) return;
		path[i] = r.data;
		print_bk(expected, path, i);
		printPathHelper_bk(r.left, expected, path, i+1);
		printPathHelper_bk(r.right, expected, path, i+1);		
	}

	private void print_bk(int expected, int[] path, int i) {
		int sum = 0;
		for(int j = 0; j <= i; j++){
			sum += path[j];
			if(expected == sum) System.out.println(sum);
		}
	}

	int getMaxDepth(Td r){
		if(null == r) return 0;
		return Math.max(getMaxDepth(r.left), getMaxDepth(r.right)) + 1;
	}
	
	/* =================================================
	Test
	*/	
	@Test
	public void test() throws CloneNotSupportedException{
		Td node = Graph.createTestGraph().root;
		print_my(node, "BCD");
	}
}