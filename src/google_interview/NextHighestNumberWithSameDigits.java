package google_interview;


public class NextHighestNumberWithSameDigits {

	public static void main(String[] args) {
// TODO Auto-generated method stub
		String digit = "21765";
		char[] ch = digit.toCharArray();
		int j = digit.length() - 1;
		int k = -1;
		for (int i = j - 1; i >= 0; i--) {
			if (ch[i] < ch[j]) {
				char temp = ch[i];
				ch[i] = ch[j];
				ch[j] = temp;
				k = i;
				break;
			}
		}
		if (k == -1) {
			System.out.println(digit);
		} else {
			for (int i = k + 1; i < j; i++) {
				if (ch[i] > ch[j]) {
					char temp = ch[i];
					ch[i] = ch[j];
					ch[j] = temp;
				}
			}
			System.out.println("next biggest digit:" + String.valueOf(ch));
		}
	}
// </editor-fold>
}
