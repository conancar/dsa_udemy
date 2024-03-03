package dsa.tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

public class MyAVLTreeLinkedListImpl<T extends Comparable<T> & Serializable> {

	private MyBinaryTreeNode<T> root;

	public MyAVLTreeLinkedListImpl() {
		this.root = null;
	}


	public int getHeight(MyBinaryTreeNode<T> currentNode) {
		if (currentNode == null) {
			return 0;
		}
		return currentNode.getHeigthForAVLTree();
	}

	public void insert(T value) {
		root=insertInternal(root,value);
	}


	/*
	 *              Rotate                                               Rotate
	 *             Right                                                   Left
	 *           ┌──────────┐                                         ┌──────────┐
	 *           │          │                                         │          │
	 *           │  ┌───┐   ▼        ┌───┐                            ▼  ┌───┐
	 *              │ 30│            │ 20│                               │ 30│                       ┌───┐
	 *              ├───┘            ├───┤                               └───┤                       │40 │
	 *        ┌───┬─┘          ┌───┬─┘   └─┬───┐                             └─┬───┐                 ├───┤
	 *        │ 20│            │ 10│       │30 │                               │ 40│           ┌───┬─┘   └─┬───┐
	 *        ├───┘            └───┘       └───┘                               └───┤           │ 30│       │ 50│
	 * ┌───┬──┘                                                                    └─┬───┐     └───┘       └───┘
	 * │ 10│                                                                         │50 │
	 * └───┘                                                                         └───┘
	 */
	private MyBinaryTreeNode<T> rotateRight(MyBinaryTreeNode<T> currentNode) {
		MyBinaryTreeNode<T> newRoot = currentNode.getLeft();
		currentNode.setLeft(currentNode.getLeft().getRight());
		newRoot.setRight(currentNode);
		currentNode.setHeigthForAVLTree(1 + max(getHeight(currentNode.getLeft()), getHeight(currentNode.getRight())));
		newRoot.setHeigthForAVLTree(1 + max(getHeight(newRoot.getLeft()), getHeight(newRoot.getRight())));
		return newRoot;
	}

	private MyBinaryTreeNode<T> rotateLeft(MyBinaryTreeNode<T> currentNode) {
		MyBinaryTreeNode<T> newRoot = currentNode.getRight();
		currentNode.setRight(currentNode.getRight().getLeft());
		newRoot.setLeft(currentNode);
		currentNode.setHeigthForAVLTree(1 + max(getHeight(currentNode.getLeft()), getHeight(currentNode.getRight())));
		newRoot.setHeigthForAVLTree(1 + max(getHeight(newRoot.getLeft()), getHeight(newRoot.getRight())));
		return newRoot;
	}

	private int getBalance(MyBinaryTreeNode<T> currentNode){
		if (currentNode==null){
			return 0;
		}

		return getHeight(currentNode.getLeft()) - getHeight(currentNode.getRight());
	}
	private MyBinaryTreeNode<T> insertInternal(MyBinaryTreeNode<T> currentNode, T value) {
		//recursive exit condition
		if (currentNode == null) {
			final MyBinaryTreeNode<T> node = new MyBinaryTreeNode<>(value);
			node.setHeigthForAVLTree(1);
			return node;
		} else if (value.compareTo(currentNode.getValue()) < 0) {
			currentNode.setLeft(insertInternal(currentNode.getLeft(), value));
		} else {
			currentNode.setRight(insertInternal(currentNode.getRight(), value));
		}
		//update height for current node
		currentNode.setHeigthForAVLTree(1 + max(getHeight(currentNode.getLeft()), getHeight(currentNode.getRight())));

		int balance =getBalance(currentNode);

		//left-left condition
		if(balance >1 && value.compareTo(currentNode.getLeft().getValue())<0){
			return rotateRight(currentNode);
		}

		//left-right condition
		if(balance >1 && value.compareTo(currentNode.getLeft().getValue())>0){
			currentNode.setLeft(rotateLeft(currentNode.getLeft()));
			return rotateRight(currentNode);
		}

		//right-right condition
		if(balance <-1 && value.compareTo(currentNode.getRight().getValue())>0){
			return rotateLeft(currentNode);
		}

		//right-left condition
		if(balance <-1 && value.compareTo(currentNode.getRight().getValue())<0){
			currentNode.setRight(rotateRight(currentNode.getRight()));
			return rotateLeft(currentNode);
		}

		return currentNode;

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


	public MyBinaryTreeNode<T> deleteNode(MyBinaryTreeNode<T> node, T value) {

		if (node == null) {
			return null;
		}

		if (value.compareTo(node.getValue()) < 0) {
			node.setLeft(deleteNode(node.getLeft(), value));
		} else if (value.compareTo(node.getValue()) > 0) {
			node.setRight(deleteNode(node.getRight(), value));
		} else {
			//3 situations ,
			if (node.getLeft() != null && node.getRight() != null) {
				//3  if node for removal has 2 children, find Successor (the smallest node in right subtree)   and switch values
				MyBinaryTreeNode<T> temp = node;
				MyBinaryTreeNode<T> successor = findSuccessorForNode(temp.getRight());
				node.setValue(successor.getValue());
				node.setRight(deleteNode(node.getRight(), value));
			} else if (node.getLeft() != null) {
				node = node.getLeft();
				//2 if node has 1 child reconnect that child to parent (and node is removed)
			} else if (node.getRight() != null) {
				node = node.getRight();
			} else {
				//1 if node is leaf just remove
				node = null;
			}
		}
		return node;
	}

	//(the smallest node in right subtree, so call this with node.right)
	private MyBinaryTreeNode<T> findSuccessorForNode(MyBinaryTreeNode<T> node) {
		if (node.getLeft() == null) {
			return node;
		}
		return findSuccessorForNode(node.getLeft());

	}

	public void delete() {
		this.root = null;
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
