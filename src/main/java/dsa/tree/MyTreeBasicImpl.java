package dsa.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class MyTreeBasicImpl<T extends Serializable> implements MyTree<T> {

	private final T data;
	private final ArrayList<MyTree<T>> children;

	public MyTreeBasicImpl(T data) {
		this.data = data;
		children=new ArrayList<>();
	}

	@Override
	public void addChild(MyTree<T> child) {
		this.children.add(child);
	}

	@Override
	public void addChildren(Collection<? extends MyTree<T>> children) {
		this.children.addAll(children);
	}

	@Override
	public String  toString(int depth) {
		String result;

		result="  ".repeat(depth)+this.data + System.lineSeparator();
		for (MyTree<T> child : this.children) {
			result+=child.toString(depth+1);
		}
		return result;

	}

}
