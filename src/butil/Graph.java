/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package butil;

import java.util.ArrayList;

/**
 *
 * @author andy
 */
public class Graph<T> {

	public enum State {
		fresh, visiting, visited;
	}

	public static class Node<T> {
		public State state = State.fresh;
		public ArrayList<Node<T>> adjNodes = new ArrayList<>();
	}

	public void draw(Node<T> n) {
	}

	public void drawLine(Node<T> m, Node<T> n) {
	}
}
