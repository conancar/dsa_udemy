package dsa.tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTreeLinkedListImpl<T extends Serializable> implements MyBinaryTree<T> {

	private MyBinaryTreeNode<T> root;

	public MyBinaryTreeLinkedListImpl() {
		this.root = null;
	}

	public void setRoot(MyBinaryTreeNode<T> root) {
		this.root = root;
	}


	@Override
	public void traverseAllNodesPreOrderStyle(MyBinaryTreeNode<T> node) {
		if (node == null) {
			return;
		}
		System.out.println(node);
		traverseAllNodesPreOrderStyle(node.getLeft());  //O(N/2) time and space on stack
		traverseAllNodesPreOrderStyle(node.getRight()); //O(N/2) time and space on stack
	}

	@Override
	public void traverseAllNodesInOrderStyle(MyBinaryTreeNode<T> node) {
		if (node == null) {
			return;
		}
		traverseAllNodesInOrderStyle(node.getLeft());  //O(N/2) time and space on stack
		System.out.println(node);
		traverseAllNodesInOrderStyle(node.getRight()); //O(N/2) time and space on stack

	}

	@Override
	public void traverseAllNodesPostOrderStyle(MyBinaryTreeNode<T> node) {
		if (node == null) {
			return;
		}
		traverseAllNodesPostOrderStyle(node.getLeft());  //O(N/2) time and space on stack
		traverseAllNodesPostOrderStyle(node.getRight()); //O(N/2) time and space on stack
		System.out.println(node);

	}

	@Override
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

	@Override
	public MyBinaryTreeNode<T> searchForValue(T value) {
		Queue<MyBinaryTreeNode<T>> helperQueue = new LinkedList<>();
		helperQueue.add(this.root);
		while (!helperQueue.isEmpty()) {
			MyBinaryTreeNode<T> currentNode = helperQueue.remove();
			if (currentNode.getValue().equals(value)) {
				return currentNode;
			}
			if (currentNode.getLeft() != null) {
				helperQueue.add(currentNode.getLeft());
			}
			if (currentNode.getRight() != null) {
				helperQueue.add(currentNode.getRight());
			}
		}
		return null;
	}

	@Override
	public void addNode(T value) {
		MyBinaryTreeNode<T> newNode = new MyBinaryTreeNode<>(value);
		//first check if root is null, if yes set to root
		if (this.root == null) {
			this.root = newNode;
			return;
		}
		Queue<MyBinaryTreeNode<T>> helperQueue = new LinkedList<>();
		helperQueue.add(this.root);
		while (!helperQueue.isEmpty()) {
			final MyBinaryTreeNode<T> currentNode = helperQueue.remove();
			if (currentNode.getLeft() == null) {
				currentNode.setLeft(newNode);
				return;
			} else if (currentNode.getRight() == null) {
				currentNode.setRight(newNode);
				return;
			} else {
				helperQueue.add(currentNode.getLeft());
				helperQueue.add(currentNode.getRight());
			}
		}
	}

	@Override
	public MyBinaryTreeNode<T> findDeepestNode() {
		Queue<MyBinaryTreeNode<T>> helperQueue = new LinkedList<>();
		helperQueue.add(this.root);
		MyBinaryTreeNode<T> jumperNodeJumpingToDeepest = null;
		while (!helperQueue.isEmpty()) {
			jumperNodeJumpingToDeepest = helperQueue.remove();
			if (jumperNodeJumpingToDeepest.getLeft() != null) {
				helperQueue.add(jumperNodeJumpingToDeepest.getLeft());
			}
			if (jumperNodeJumpingToDeepest.getRight() != null) {
				helperQueue.add(jumperNodeJumpingToDeepest.getRight());
			}
		}
		return jumperNodeJumpingToDeepest;
	}

	@Override
	public void removeNode(T value) {
		if (this.root == null) {
			return;
		}

		//find node to remove
		final MyBinaryTreeNode<T> nodeToRemove = this.searchForValue(value);
		if (nodeToRemove == null) {
			return;
		}
		//remove deepest and return its value
		final MyBinaryTreeNode<T> deepestNode = removeAndReturnDeepestNode();

		//switch values
		nodeToRemove.setValue(deepestNode.getValue());

	}


	public MyBinaryTreeNode<T> removeAndReturnDeepestNode() {

		Queue<MyBinaryTreeNode<T>> queue = new LinkedList<>();
		queue.add(root);
		MyBinaryTreeNode<T> previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				final MyBinaryTreeNode<T> removedNode = new MyBinaryTreeNode<>(previousNode.getRight().getValue());
				removedNode.setLeft(previousNode.getRight().getLeft());
				removedNode.setRight(previousNode.getRight().getRight());

				previousNode.setRight(null);
				return removedNode;
			} else if (presentNode.getRight() == null) {
				final MyBinaryTreeNode<T> removedNode = new MyBinaryTreeNode<>(presentNode.getLeft().getValue());
				removedNode.setLeft(presentNode.getLeft().getLeft());
				removedNode.setRight(presentNode.getLeft().getRight());

				presentNode.setLeft(null);
				return removedNode;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());

		}
		return null;
	}


	@Override
	public void deleteTree() {
		this.root = null;
	}

	@Override
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

}
