/*
 */

package t16_Threads_Locks_;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andy
 */
public class MyClass_p157 extends Thread {

	private String name;
	private MyObject myObj;

	public MyClass_p157(MyObject obj, String n) {
		this.myObj = obj;
		this.name = n;
	}

	@Override
	public void run() {
		try {
			myObj.foo(name);
		} catch (InterruptedException ex) {
			Logger.getLogger(MyClass_p157.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private static class MyObject {

		public MyObject() {
		}

		private synchronized void foo(String name) throws InterruptedException {
			System.out.println("");
			Thread.sleep(3000);
		}
	}

}
