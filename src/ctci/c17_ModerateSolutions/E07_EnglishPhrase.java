/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package t17_ModerateSolutions;

/**
 *
 * TODO: p442
 */
public class E07_EnglishPhrase {

	static String[] stage = {"", "thousand,", "million,", "gillion,"};
	static String[] oneDigit = "zero one two three four five six sever eight nine".split(" ");
	static String[] twoDigit = "ten eleven twelve thirteen fourteen sixteen seventeen eighteen ninteen".split(" ");
	static String[] tens = "zero ten twenty thirty forty fifty sixty ninty".split(" ");

	public static String getNum(long d) {
		String num = "zero";
		if (d > 0) {
			num = getNumHelper(d, 0);
		}
		System.out.println(num);
		return num;
	}

	private static String getNumHelper(long d, int ratio) {
		if (d == 0) {
			return "";
		}
		String num = String.format("%s %s %s", getNumHelper(d / 1000, ratio + 1), getLT1K((int) (d % 1000)), stage[ratio]);
		return num;
	}

	public static String getLT1K(int d) {
		String num = "";
		if (d >= 100) {
			num += String.format("%s hundred", oneDigit[d / 100]);
		}
		String num2 = "";
		d = d % 100;
		if (1 <= d && d < 10) {
			num2 += oneDigit[d];
		} else if (10 <= d && d < 20) {
			num2 += twoDigit[d - 10];
		} else if (20 <= d && d < 100) {
			num2 += tens[d / 10];
			d = d % 10;
			if (d > 0) {
				num2 += "-" + oneDigit[d];
			}
		}
		if (!"".equals(num) && !"".equals(num2)) {
			num2 = " and " + num2;
		}
		return num + num2;
	}

	public static void main(String[] argv) {
		getNum(121);
		getNum(8);
		getNum(10);
		getNum(11);
		getNum(20);
		getNum(21);
		getNum(121);
		getNum(9121);
		getNum(1234560);
		getNum(1234561);
	}
}
