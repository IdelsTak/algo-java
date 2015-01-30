/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t05_Bit;

/**
 *
 * @author andy
 */
public class E6_SwapBit {
	public int swapOddEvenBits(int x){
		return (((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1));
	}
}
