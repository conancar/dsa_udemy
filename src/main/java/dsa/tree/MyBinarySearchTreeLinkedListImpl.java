package dsa.tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTreeLinkedListImpl<T extends Comparable<T> & Serializable> {

	private MyBinaryTreeNode<T> root;

	public MyBinarySearchTreeLinkedListImpl() {
		this.root = null;
	}


	public void insert(T value) {
		insert(root, value);
	}

	private MyBinaryTreeNode<T> insert(MyBinaryTreeNode<T> currentNode, T value) {
		if (currentNode == null) {
			final MyBinaryTreeNode<T> node = new MyBinaryTreeNode<>(value);
			if (root == null) {
				root = node;
				return root;
			}
			return node;
		} else if (value.compareTo(currentNode.getValue()) < 0 ) {
			currentNode.setLeft(insert(currentNode.getLeft(), value));
			return currentNode;
		} else {
			currentNode.setRight(insert(currentNode.getRight(), value));
			return currentNode;
		}
	}


	public void traverseAllNodesPreOrderStyle(MyBinaryTreeNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.println(node);
		traverseAllNodesPreOrderStyle(node.getLeft());  //O(N/2) time and space on stack
		traverseAllNodesPreOrderStyle(node.getRight()); //O(N/2) time and space on stack
	}


	public void traverseAllNodesInOrderStyle(MyBinaryTreeNode<T> node) {
		if (node == null) {
			return;
		}
		traverseAllNodesInOrderStyle(node.getLeft());  //O(N/2) time and space on stack
		System.out.println(node);
		traverseAllNodesInOrderStyle(node.getRight()); //O(N/2) time and space on stack

	}


	public void traverseAllNodesPostOrderStyle(MyBinaryTreeNode<T> node) {
		if (node == null) {
			return;
		}
		traverseAllNodesPostOrderStyle(node.getLeft());  //O(N/2) time and space on stack
		traverseAllNodesPostOrderStyle(node.getRight()); //O(N/2) time and space on stack
		System.out.println(node);

	}

	public void traverseAllNodesLevelOrderStyle(MyBinaryTreeNode<T> node) {
		Queue<MyBinaryTreeNode<T>> helperQueue = new LinkedList<>();
		helperQueue.add(node);
		while (!helperQueue.isEmpty()) {
			MyBinaryTreeNode<T> currentNode = helperQueue.remove();
			System.out.println(currentNode);
			if (currentNode.getLeft() != null) {
				helperQueue.add(currentNode.getLeft());
			}
			if (currentNode.getRight() != null) {
				helperQueue.add(currentNode.getRight());
			}
		}
	}

	public MyBinaryTreeNode<T> search(MyBinaryTreeNode<T> node, T value) {
		if (node == null) {
			return null;
		} else if (node.getValue().equals(value)) {
			return node;
		} else if (value.compareTo(node.getValue()) < 0) {
			return search(node.getLeft(), value);
		} else {
			return search(node.getRight(), value);
		}
	}

	/*
	 * 2               ┌───┐
	 *                 │ 1 │           ┌───┐        ┌───┐
	 *                 ├───┘           │ 1 │        │ 1 │
	 *               ┌─┘           │   ├───┘        ├───┘
	 *           ┌───┤             │ ┌─┘          ┌─┘
	 *           │ 2 │           ┌─┼─┤        ┌───┤
	 *           ├───┘         ──┼┼┼┼┼────    │ 3 │
	 *         ┌─┘               ├─┼─┘        └───┘
	 *     ┌───┤               ┌─┘ │
	 *     │ 3 │           ┌───┤   │
	 *     └───┘           │ 3 │
	 *                     └───┘
	 */
	public MyBinaryTreeNode<T> deleteNode(MyBinaryTreeNode<T> node, T value) {

		if (node == null) {
			return null;
		}

		if (value.compareTo(node.getValue())<0){
			node.setLeft(deleteNode(node.getLeft(),value));
		} else if (value.compareTo(node.getValue())>0) {
			node.setRight(deleteNode(node.getRight(),value));
		}else{
			//3 situations ,
			if(node.getLeft()!=null && node.getRight()!=null){
				//3  if node for removal has 2 children, find Successor (the smallest node in right subtree)   and switch values
				MyBinaryTreeNode<T> temp=node;
				MyBinaryTreeNode<T> successor=findSuccessorForNode(temp.getRight());
				node.setValue(successor.getValue());
				node.setRight(deleteNode(node.getRight(),value));
			} else if (node.getLeft()!=null) {
				node=node.getLeft();
				//2 if node has 1 child reconnect that child to parent (and node is removed)
			}else if (node.getRight()!=null){
				node=node.getRight();
			}else{
				//1 if node is leaf just remove
				node=null;
			}
		}
			return node;
	}

	//(the smallest node in right subtree, so call this with node.right)
	private MyBinaryTreeNode<T> findSuccessorForNode(MyBinaryTreeNode<T> node){
		if(node.getLeft()==null){
			return node;
		}
		return findSuccessorForNode(node.getLeft());

	}

	public void delete(){
		this.root=null;
	}


	public String toString() {

		StringBuilder sb = new StringBuilder();
		Queue<MyBinaryTreeNode<T>> helperQueue = new LinkedList<>();
		helperQueue.add(this.root);
		while (!helperQueue.isEmpty()) {
			MyBinaryTreeNode<T> currentNode = helperQueue.remove();
			sb.append(currentNode.toString()).append(System.lineSeparator());
			if (currentNode.getLeft() != null) {
				helperQueue.add(currentNode.getLeft());
			}
			if (currentNode.getRight() != null) {
				helperQueue.add(currentNode.getRight());
			}
		}
		return sb.toString();
	}

	public MyBinaryTreeNode<T> getRoot() {
		return root;
	}
}
