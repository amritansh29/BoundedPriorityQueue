import java.util.Iterator;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BoundedPriorityQueue<T> {
	
	private PriorityQueue <T> q;
	private int maxSize;
		
	public BoundedPriorityQueue(int size) throws IllegalArgumentException{
		if (size <= 0) {
			throw new IllegalArgumentException();
		}
		q = new PriorityQueue<T>();
		maxSize = size;
	}
	
	public void enqueue(T element) {
		q.add(element);
		if (q.size() >= maxSize) {	
			q.remove(getLast());;
		}
	}
	
	public T getLast() {
		if (q.size() == 0) {
			return null;
		}
		PriorityQueue<T> copy = new PriorityQueue<T>(q);
		int size = 0;
		while (size++ < q.size() - 1) {
			copy.poll();
		}
		return copy.peek();
	}

	public T dequeue() {
		if (q.size() == 0) {
			return null;
		}
		return q.poll();
	}

	public T first() {
		if (q.size() == 0) {
			return null;
		}
		return q.peek();
	}

	public boolean contains(T element) {
		Iterator<T>  iterator = q.iterator();
		while(iterator.hasNext()) {
			if (iterator.next().equals(element)) {
				return true;
			}
		}
		return false;	
	}

	public int size() {
		return q.size();
	}

	public boolean isEmpty() {
		return q.size() == 0;
	}

	public Iterator<T> iterator() {
		return new PQueueIterator();
	}
	
	private class PQueueIterator implements Iterator<T> {
		int startSize = q.size();
		ArrayList<T> arr = new ArrayList<T>();
		Iterator<T> it;
		{
			PriorityQueue<T> copy = new PriorityQueue<T>(q);
			int size = 0;
			while (size++ < q.size()) {
				arr.add(copy.poll());
			}
			it = arr.iterator();
			
		}
		
		@Override
		public boolean hasNext() {
			if (startSize != q.size()) {
				throw new java.util.ConcurrentModificationException();
			}
			return it.hasNext();
		}
		
		public T next() {
			if (startSize != q.size()) {
				throw new java.util.ConcurrentModificationException();
			}
			return it.next();	
		}	
	}

		
}
