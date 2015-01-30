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
public class E5_Thread__badLock {
	public static class Foo {

		Lock first, second, third;

		public Foo() {
			first = new ReentrantLock();
			second = new ReentrantLock();
			third = new ReentrantLock();
			second.lock();
			third.lock();
		}

		public void first() {
			first.lock();
			try {
				System.out.println("first ...");
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				Logger.getLogger(E5_Thread__badLock.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
			}
			second.unlock();
		}//first

		public void second() {
			try {
				second.lock();
				System.out.println("second...");
				Thread.sleep(100);
				third.unlock();
			} //second
			catch (InterruptedException ex) {
				Logger.getLogger(E5_Thread__badLock.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		public void third() {
			try {
				third.lock();
				System.out.println("third...");
				Thread.sleep(100);
				first.unlock();
			} //thrid
			catch (InterruptedException ex) {
				Logger.getLogger(E5_Thread__badLock.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public static class Runner extends Thread {

		int i;
		Foo foo;

		public void setFoo(int i, Foo foo) {
			this.i = i;
			this.foo = foo;
		}

		@Override
		public void run() {
			int index = i % 3;
			switch (index) {
				case 0:
					foo.first();
					break;
				case 1:
					foo.second();
					break;
				case 2:
					foo.third();
					break;
			}
		}
	}

	public static void main(String argv[]) {
		Foo foo = new Foo();
		int nThreads = 21;
		Runner[] runners = new Runner[nThreads];
		for (int i = 0; i < nThreads; i++) {
			runners[i] = new Runner();
			runners[i].setFoo(i, foo);
			runners[i].start();
		}
	}
}
