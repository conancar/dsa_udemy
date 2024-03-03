package dsa.queue;


import java.io.Serializable;
import java.lang.reflect.Array;

import static java.lang.Math.abs;

/**
 * In CIRCULAR implementation we don't want to shift all elements to the left every time we remove an element from queue (O1 not On),
 * but we shift topOfQueue to 0 index when it is in length-1 if beginningOfQueue is not at 0 index (this means isFull ) end ve move in
 * circles beginning and top index, but beginning must be always one before top(isFull also)
 *
 */
public class MyQueueArrayCircularImpl<T extends Serializable> implements MyQueue<T> {

	private T[] array;
	private int beginningOfQueue;
	private int numberOfElementsInQueue=0;


	public MyQueueArrayCircularImpl(Class<T> clazz, int capacity) {
		this.array= (T[]) Array.newInstance(clazz, capacity);
		beginningOfQueue=0;

	}

	@Override
	public void enQueue(T value) {

		if (this.isFull()) {
			throw new IllegalArgumentException("Queue is full");
		}


		int position = (beginningOfQueue + numberOfElementsInQueue) % array.length;
//		int position = beginningOfQueue + numberOfElementsInQueue; SAME AS MODUO
//		if(position==array.length){
//			position=0;
//		}

		array[position]=value;

		numberOfElementsInQueue++;
	}

	@Override
	public T deQueue() {
		T value=peek();
		array[beginningOfQueue] = null; // dereference to help garbage collection
		beginningOfQueue=(beginningOfQueue+1)%array.length;
		numberOfElementsInQueue--;

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
		return numberOfElementsInQueue==0 ;
	}

	@Override
	public boolean isFull() {

		return numberOfElementsInQueue==array.length;
	}

	@Override
	public void clear() {


		final Class<?> componentType = array.getClass().getComponentType();
		int length=this.array.length;

		this.array=null;  //O(1) SOLUTION
		this.array= (T[]) Array.newInstance(componentType, length);
		numberOfElementsInQueue=0;
		beginningOfQueue=-1;

	}

	@Override
	public String toString(){
		if(this.isEmpty()){
			return "Queue is empty";
		}

		StringBuilder sb=new StringBuilder("beginning<-");

		if((beginningOfQueue+numberOfElementsInQueue)<=array.length){
			for(int i=beginningOfQueue;i<beginningOfQueue+numberOfElementsInQueue;i++){
				sb.append(array[i]);
				sb.append("<-");
			}
			sb.append("|top");
			return sb.toString();
		}else{
			int remain=(beginningOfQueue+numberOfElementsInQueue)%array.length;
			for(int i=beginningOfQueue;i<beginningOfQueue+numberOfElementsInQueue-remain;i++){
				sb.append(array[i]);
				sb.append("<-");
			}
			for(int i=0;i<remain;i++){
				sb.append(array[i]);
				sb.append("<-");
			}
			sb.append("|top");
			return sb.toString();
		}


	}
}
