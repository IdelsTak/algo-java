/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t14_Java;

import java.util.Iterator;

/**
 *
 * @author andy
 */
public class E6_CircularArray<T> implements Iterable<T> {

	private T[] items;
	private int head = 0;

	public E6_CircularArray(int size) {
		items = (T[]) new Object[size];
	}

	private int convert(int index) {
		return (head + index + items.length) % items.length;
	}

	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}

	public T get(int i) {
		if (i < 0 || i >= items.length) {
			throw new java.lang.IndexOutOfBoundsException("...");
		}
		return items[convert(i)];
	}

	public void set(int i, T item) {
		items[convert(i)] = item;
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator<>(this);
		//return new CircularArrayIterator<>();
	}

	private class CircularArrayIterator<TI> implements Iterator<TI> {

		private int _current = -1;
		private TI[] _items;

		private CircularArrayIterator(E6_CircularArray<TI> aThis) {	//private CircularArrayIterator() {
			_items = aThis.items;
		}

		@Override
		public boolean hasNext() {
			return _current < items.length - 1;
		}

		@Override
		public TI next() {
			TI item = (TI) _items[convert(++_current)];
			return item;
		}
	}//class

}
