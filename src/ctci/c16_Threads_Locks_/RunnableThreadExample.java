/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t16_Threads_Locks_;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andy
 */
public class RunnableThreadExample implements Runnable {

	public int count = 0;

	@Override
	public void run() {
		try {
			while (count < 5) {
				Thread.sleep(500);
				count++;
			}
		} catch (InterruptedException ex) {
			Logger.getLogger(RunnableThreadExample.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void main(String argv[]) throws InterruptedException {
		RunnableThreadExample instance = new RunnableThreadExample();
		Thread thread = new Thread(instance);
		thread.start();
		while (instance.count < 5) {
			System.out.println(instance.count);
			Thread.sleep(250);
		}
	}
}
