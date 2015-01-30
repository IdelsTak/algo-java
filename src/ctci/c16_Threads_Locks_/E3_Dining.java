/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t16_Threads_Locks_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andy
 */
public class E3_Dining {

	class ChopStick {

		private Lock lock;

		public ChopStick() {
			lock = new ReentrantLock();
		}

		public void pickUp() {
			lock.lock();
		}

		public boolean pickUpTry() {
			return lock.tryLock();
		}

		public void putDown() {
			lock.unlock();
		}
	}

	public class Philosopher extends Thread {

		private final int bites = 10;
		private final ChopStick left;
		private final ChopStick right;

		Philosopher(ChopStick left, ChopStick right) {
			this.left = left;
			this.right = right;
		}

		public void eat() {
			pickUp();
			chew();
			putDown();
		}

		public void eatTry() {
			if (pickUp()) {
				chew();
				putDown();
			}
		}

		public boolean pickUp() {
			if (!left.pickUpTry()) {
				return false;
			}
			if (!right.pickUpTry()) {
				left.putDown();
				return false;
			}
			return true;
		}

		public void chew() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				Logger.getLogger(E3_Dining.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		public void putDown() {
			left.putDown();
			right.putDown();
		}

		@Override
		public void run() {
			for (int i = 0; i < bites; i++) {
				eat();
			}
		}//run
	}//Philosopher
}
