package dsa.hashing;

import java.io.Serializable;

public interface MyHashing<T extends Serializable> {

	void insert (T value);
	String read();
	boolean find(T value);
	boolean remove(T value);

}
