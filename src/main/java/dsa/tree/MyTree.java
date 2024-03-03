package dsa.tree;

import java.io.Serializable;
import java.util.Collection;

public interface MyTree<T extends Serializable> {

	void addChild(MyTree<T> child);

	void addChildren(Collection<? extends MyTree<T>> children);

	String toString(int depth);
}
