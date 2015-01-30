package google_interview;

/*
Solutions to http://www.careercup.com/question?id=5173972006076416
 May 31, 2014

 Quest: create a Random number generator without using the java in build Random class?
 its a class to generate random numbers but the problem is It always starts with 0...!
 Can someone add some more to this code.??

 result: note fully done
 */

public class E40531_GenerateRandomNumbers {

	public static int seed = 10;

	public void generateInt(int num) {
		seed = num;
		for (int i = 1; i < num; i++) {
			seed = ((int) System.nanoTime() % (i));
			if (seed <= 0)
				seed = ((int) System.currentTimeMillis() % i);
			System.out.println(seed);
		}
	}

	public void generateInt_my(int num) {
		seed = num;
		for (int i = 1; i < num; i++) {
			seed = (int) (System.nanoTime() % num);
			System.out.println(seed);
		}
	}

	public static void main(String[] args) {
		new E40531_GenerateRandomNumbers().generateInt_my(20);
	}

}
