package dsa.linkedlist.node;

import java.io.Serializable;

public interface MyNode<T extends Serializable > extends Serializable {

	void setValue(T value);

	T getValue();

}
