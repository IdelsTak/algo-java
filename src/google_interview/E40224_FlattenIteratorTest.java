/*
Solutions to http://www.careercup.com/question?id=5898529851572224
Flatten an iterator of iterators in Java. If the input is [ [1,2], [3,[4,5]], 6], it should return [1,2,3,4,5,6]. Implement hasNext() and next(). Note that the inner iterator or list might be empty.
 */

package google_interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class E40224_FlattenIteratorTest {
	public static void main(String[] arg){
		List<Object> list = Arrays.asList(
			Arrays.asList(1, 2),
			Arrays.asList(3, Arrays.asList(4,5)),
			Collections.emptyList(),
			Arrays.asList(6)
		);

	}

	class FlattenIterator implements Iterator<Integer>{

		LinkedList<Object> elements = new LinkedList<>();
		public FlattenIterator(List<Object> list){
			elements.addAll(list);
			unwrap();
		}

		private void unwrap(){
			while(!elements.isEmpty() && elements.peek() instanceof List){
				List l = (List) elements.poll();
				elements.addAll(0, l);
			}
		}

		@Override
		public boolean hasNext() {
			return !elements.isEmpty();
		}

		@Override
		public Integer next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			Integer val = (Integer) elements.poll();
			unwrap();
			return val;
		}
	}
}
