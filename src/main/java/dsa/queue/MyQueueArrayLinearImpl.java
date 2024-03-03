package dsa.queue;


import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * In LINEAR implementation we don't want to shift all elements to the left every time we remove an element from queue (O1 not On),
 * but in this case when beginningOfQueue value come to length-1 no more space in this queue, that is why we use CIRCULAR queue impl.
 *
 */
public class MyQueueArrayLinearImpl<T extends Serializable> implements MyQueue<T> {

	private T[] array;
	private int beginningOfQueue;
	private int topOfQueue;


	public MyQueueArrayLinearImpl(Class<T> clazz, int capacity) {
		this.array= (T[]) Array.newInstance(clazz, capacity);
		beginningOfQueue=-1;
		topOfQueue=-1;
	}

	@Override
	public void enQueue(T value) {

		if(this.isFull()){
			throw new IllegalArgumentException("Queue is full");
		}
		if(beginningOfQueue==-1){
			beginningOfQueue=0;
		}
		topOfQueue++;
		array[topOfQueue]=value;
	}

	@Override
	public T deQueue() {
		T value=peek();
		array[beginningOfQueue] = null; // dereference to help garbage collection
		beginningOfQueue++;
		if(beginningOfQueue>topOfQueue){
			beginningOfQueue=-1;
			topOfQueue=-1;
		}
		return value;
	}

	@Override
	public T peek() {
		if(this.isEmpty()){
			throw new IllegalArgumentException("Queue is empty");
		}
		return array[beginningOfQueue];
	}


	@Override
	public boolean isEmpty() {
		return beginningOfQueue==-1 ;
	}

	@Override
	public boolean isFull() {
		return topOfQueue==array.length-1;
	}

	@Override
	public void clear() {


		final Class<?> componentType = array.getClass().getComponentType();
		int length=this.array.length;

		this.array=null;  //O(1) SOLUTION
		this.array= (T[]) Array.newInstance(componentType, length);
		topOfQueue=-1;
		beginningOfQueue=-1;

	}

	@Override
	public String toString(){
		if(this.isEmpty()){
			return "Queue is empty";
		}

		StringBuilder sb=new StringBuilder("beginning<-");
		for(int i=beginningOfQueue;i<=topOfQueue;i++){
			sb.append(array[i]);
			if(i<topOfQueue){
				sb.append("<-");
			}
		}
		sb.append("|top");
		return sb.toString();
	}
}
