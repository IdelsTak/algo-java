/*http://www.careercup.com/question?id=4699414551592960
we have a random list of people. each person knows his own height and the number of tall people in front of him. write a code to make the equivalent queue.
for example :
input: <"Height","NumberOfTall","Name">,
<6,2,"A">,<1,4,"B">,<11,0,"C">,<5,1,"D">,<10,0,"E">,<4,0,"F">
output: "F","E","D","C","B","A" --> end of queue

Height		10	11	5	4	6	1
NumOfTall	0	0	1	0	2	4
Name		B	D	C	A	F	E

 */

package google_interview;

import java.util.Arrays;
import java.util.Comparator;

public class E40218_OrderTallPeople {

	private static class Person{//<editor-fold defaultstate="collapsed" desc="comment">
		// implements Comparable<Person>{
		public String name;
		public int height;
		public int tallCount;

		Person(int h, int t, String n){
			name = n;	height = h;	tallCount = t;
		}

		@Override
		public String toString() {
			return "<"+name+","+height+"," +tallCount+">";
		}//@Override		public int compareTo(Person o) {			if(this.height>o.height) return -1;			else if(this.height<o.height) return 1;			else return 0;		}
	}

	static class HeightComparator implements Comparator<Person> {
		public int compare(Person p1, Person p2){
			int ret  = p2.height - p1.height;
			return (ret == 0)?p2.tallCount - p1.tallCount:ret;
		}
	}//</editor-fold>

	public static class Sol_1{//<editor-fold defaultstate="collapsed" desc="comment">
		public static Person[] order(Person[] a){
			Arrays.sort(a, new HeightComparator());
			System.out.print("Sorted: ");
			System.out.println(Arrays.toString(a));
			int N = a.length, i, j;
			for(i = 1; i<N; i++){
				Person p = a[i];
				if(p.tallCount>0){
					for(j = 0; j<p.tallCount; j++){
						if(i-j-1>=0)
							a[i-j] = a[i-j-1];
						else
							break;
					}
					if(i-p.tallCount<=0) a[0] = p;
					else a[i-p.tallCount] = p;
				}
				System.out.println(Arrays.toString(a));
			}
			return a;
		}
	}//</editor-fold>

	public static void main(String[] args) {
		Person[] a = {
				new Person(5,1,"D"),
				new Person(6,2,"A"),
				new Person(4,0,"F"),
				new Person(11,0,"C"),
				new Person(1,4,"B"),
				new Person(5,3,"K"),
				new Person(10,0,"E"),
		};
		System.out.print("Origin: ");
		System.out.println(Arrays.toString(a));

		a = Sol_1.order(a);
		System.out.print("Final : ");
		System.out.println(Arrays.toString(a));
	}
}
