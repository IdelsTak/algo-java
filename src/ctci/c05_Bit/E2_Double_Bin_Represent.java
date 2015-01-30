/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t05_Bit;

import org.junit.Test;

/**
 *
 * @author andy
 */
public class E2_Double_Bin_Represent {
	String pringBinaryUsingJavaFunc(double d){
		String r = "0b"+Long.toBinaryString(Double.doubleToRawLongBits(d));
		return r;
	}
	
	/*
	Solution 1
	*/
	public static String printBinary(double num){
		if(num >= 1 || num <=0) return "ERROR";
		StringBuilder sb = new StringBuilder();
		sb.append('.');
		while(num > 0){
			num *= 2;
			if(num >= 1){
				sb.append('1');
				num -= 1;
			}else{
				sb.append('0');
			}
			if(sb.length() > 32) return "ERROR";
		}
		return sb.toString();
	}
	
	/*
	Solution 2
	*/
	public static String printBinary_1(double num){
		if(num>=1 && num<=0) return "ERROR";
		double sync = 0.5;
		StringBuilder sb = new StringBuilder();
		sb.append('.');
		while(num>0){
			if(num >= sync){
				sb.append('1');
				num -= sync;
			}else{
				sb.append('0');
			}
			sync /= 2;
			if(sb.length() > 32) return "ERROR";
		}
		return sb.toString();
	}
	 
	@Test
	public void test(){
		System.out.println(pringBinaryUsingJavaFunc(0.72));
	}
}
