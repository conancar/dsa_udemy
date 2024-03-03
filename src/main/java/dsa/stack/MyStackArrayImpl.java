package dsa.stack;

import java.io.Serializable;
import java.lang.reflect.Array;


public class MyStackArrayImpl<T extends  Serializable> implements MyStack<T>{

	private T[] array;
	private int topOfStack; //helps to define how stack if "filled", acts as "index" of stack.

	public MyStackArrayImpl(Class<T> clazz, int capacity) {
		this.array= (T[]) Array.newInstance(clazz, capacity);
		this.topOfStack=-1;
	}

	@Override
	public void push(T value) {
		if(topOfStack==array.length-1){
			throw new IllegalArgumentException("Stack is full cannot add!");
		}
		topOfStack++;
		array[topOfStack]=value;
	}

	@Override
	public T pop() {
		final T elementOnTop = this.peek();
		array[topOfStack]=null; // dereference to help garbage collection
		topOfStack--;
		return elementOnTop;
	}

	@Override
	public T peek() {
		if(this.isEmpty()){
			throw new IllegalArgumentException("Stack is empty");
		}
		return array[topOfStack];
	}

	@Override
	public boolean isEmpty() {
		return this.topOfStack==-1;
	}

	@Override
	public boolean isFull() {
		return array.length-1==topOfStack;
	}

	@Override
	public void clear() {
		final Class<?> componentType = array.getClass().getComponentType();
		int length=this.array.length;

		this.array=null;  //O(1) SOLUTION
		this.array= (T[]) Array.newInstance(componentType, length);
		topOfStack=-1;

//		for(int i=0;i<=topOfStack;i++){  //O(N) solution
//			array[i]=null;
//		}

	}

	@Override
	public String toString() {
		if(this.isEmpty()){
			return "Stack is empty";
		}

		StringBuilder sb=new StringBuilder("|");
		for(int i =0;i<=topOfStack;i++){
			sb.append(array[i]);
			if(i<topOfStack){
				sb.append("->");
			}
		}
		return sb.toString();
	}
}
