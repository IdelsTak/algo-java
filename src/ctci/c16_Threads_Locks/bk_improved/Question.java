package t16_Threads_Locks.bk_improved;

public class Question {

	public static void main(String[] args) {
		int[] res1 = {1, 2, 3, 4};
		int[] res2 = {1, 5, 4, 1};
		int[] res3 = {1, 4, 5};
		
		LockFactory.initialize(5 + 1);//in these case, only 5 resources exist
		
		LockFactory lf = LockFactory.getInstance();
		System.out.println(lf.declare("res1", res1));
		System.out.println(lf.declare("res2", res2));
		System.out.println(lf.declare("res2", res3));
		
		System.out.println(lf.getLock("res1", 1));
		System.out.println(lf.getLock("res1", 2));
		System.out.println(lf.getLock("res2", 4));
	}
}
