/*
 */

package ctci.c16_Threads_Locks_2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andy
 */
public class ThreadExample extends Thread {

	public int count = 0;

	@Override
	public void run() {
		while (count < 5) {
			try {
				Thread.sleep(500);
				count++;
			} catch (InterruptedException ex) {
				Logger.getLogger(ThreadExample.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public static void main(String[] argc) throws InterruptedException {
		ThreadExample instance = new ThreadExample();
		instance.start();
		while (instance.count < 5) {
			Thread.sleep(250);
		}
	}//public
}
