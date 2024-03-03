package dsa.stack;

import dsa.linkedlist.node.NodeSingly;

public class StackWithMinValueQuestion {


	public static void main(String[] args){
		StackWithMinValueQuestion stackWithMinValueQuestion=new StackWithMinValueQuestion();

		stackWithMinValueQuestion.push(4);
		stackWithMinValueQuestion.push(2);
		stackWithMinValueQuestion.push(3);
		stackWithMinValueQuestion.push(5);
		stackWithMinValueQuestion.push(1);
		stackWithMinValueQuestion.push(7);
		stackWithMinValueQuestion.push(9);
		stackWithMinValueQuestion.push(2);
		System.out.println(stackWithMinValueQuestion);
		System.out.println(stackWithMinValueQuestion.min);

		stackWithMinValueQuestion.pop();
		stackWithMinValueQuestion.pop();
		stackWithMinValueQuestion.pop();
		stackWithMinValueQuestion.pop();
		System.out.println(stackWithMinValueQuestion);
		System.out.println(stackWithMinValueQuestion.min);

	}


	private NodeSingly<Integer> top = null; //stack one for values

	private NodeSingly<Integer> min = null; //stack tracking minimum



	/**
	 * Return minimum value in stack
	 *
	 * @return min
	 */
	public Integer min() {
		return min.getValue();
	}


	public void push(Integer value) {


		if(min==null){
			min=new NodeSingly<>(value);
		} else if (value<min.getValue()) {
			min=new NodeSingly<>(value,min);
		}else{
			min=new NodeSingly<>(min.getValue(),min);
		}


		top=new NodeSingly<>(value,top);
	}


	public Integer pop() {
		min=min.getNext();

		int value= top.getValue();
		top=top.getNext();
		return value;
	}

	@Override
	public String toString() {
		if (top==null) {
			return "Stack is empty";
		}
		NodeSingly<Integer> jumper = this.top;
		StringBuilder sb = new StringBuilder("Main ");
		while (jumper != null) {
			sb.append(jumper.getValue());
			sb.append("<-");
			jumper = jumper.getNext();
		}
		sb.deleteCharAt(sb.length() - 2);
		sb.deleteCharAt(sb.length() - 1);
		sb.append("|");

		NodeSingly<Integer> jumperMin = this.min;
		StringBuilder sbmin = new StringBuilder("  MIN ");
		while (jumperMin != null) {
			sbmin.append(jumperMin.getValue());
			sbmin.append("<-");
			jumperMin = jumperMin.getNext();
		}
		sbmin.deleteCharAt(sbmin.length() - 2);
		sbmin.deleteCharAt(sbmin.length() - 1);
		sbmin.append("|");

		return sb.toString()+ sbmin.toString();
	}
}
