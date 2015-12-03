/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ctci.c16_Threads_Locks_2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andy
 */
public class E5_Thread__semaphore {
	public static class Foo {

		Semaphore s1, s2, s3;
		public Foo() throws InterruptedException {
			s1 = new Semaphore(1);
			s2 = new Semaphore(1);
			s3 = new Semaphore(1);
			s2.acquire();
			s3.acquire();
		}

		public void first() throws InterruptedException {
			s1.acquire();
			System.out.println("1...");
			s2.release();
		}

		public void second() throws InterruptedException {
			s2.acquire();
			System.out.println("2...");
			s3.release();
		}

		public void third() throws InterruptedException {
			s3.acquire();
			System.out.println("3...");
			s1.release();
		}
	}//class

	public static class Runner extends Thread {

		int i;
		Foo foo;

		public void setFoo(int i, Foo foo) {
			this.i = i;
			this.foo = foo;
		}

		@Override
		public void run() {
			try {
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
			} catch (InterruptedException ex) {
				Logger.getLogger(E5_Thread__semaphore.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public static void main(String argv[]) throws InterruptedException {
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
