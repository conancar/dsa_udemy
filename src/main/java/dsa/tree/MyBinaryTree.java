package dsa.tree;

import java.io.Serializable;

public interface MyBinaryTree<T extends Serializable>{


	void traverseAllNodesPreOrderStyle(MyBinaryTreeNode<T> node);
	void traverseAllNodesInOrderStyle(MyBinaryTreeNode<T> node);

	void traverseAllNodesPostOrderStyle(MyBinaryTreeNode<T> node);

	void traverseAllNodesLevelOrderStyle(MyBinaryTreeNode<T> node);

	Object searchForValue(T value);

	void addNode(T value);

	MyBinaryTreeNode<T> findDeepestNode();

	void removeNode(T value);

	void deleteTree();
}
