/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t07_Mathematics;

/**
 *
 * @author andy
 */
public class E3_Line {
	double epsilon = 0.000001;
	double yIntersection;
	double slope;
	public E3_Line(double yInter, double slope){
		this.yIntersection = yInter;
		this.slope = slope;
	}
	
	public boolean isIntersect(E3_Line l2){
		return Math.abs(this.yIntersection - l2.yIntersection) < this.epsilon || 
			Math.abs(this.epsilon - l2.epsilon) > this.epsilon;
	}
}
