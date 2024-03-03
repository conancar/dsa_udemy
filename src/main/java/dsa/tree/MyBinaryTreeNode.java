package dsa.tree;

import java.io.Serializable;

public class MyBinaryTreeNode<T extends Serializable> {

	private T value;

	private MyBinaryTreeNode<T> left;

	private MyBinaryTreeNode<T> right;

	private int heigthForAVLTree;  //distance from node to leaf

	public MyBinaryTreeNode(T value, MyBinaryTreeNode<T> left, MyBinaryTreeNode<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public MyBinaryTreeNode(T value) {
		this.value = value;
		heigthForAVLTree =0;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public MyBinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(MyBinaryTreeNode<T> left) {
		this.left = left;
	}

	public MyBinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(MyBinaryTreeNode<T> right) {
		this.right = right;
	}

	public int getHeigthForAVLTree() {
		return heigthForAVLTree;
	}

	public void setHeigthForAVLTree(int heigthForAVLTree) {
		this.heigthForAVLTree = heigthForAVLTree;
	}

	public String  toString() {
		String result="   "+this.value + System.lineSeparator();
		result=result+(this.left==null?"":this.left.value)+"<-";
		result=result+"->"+(this.right==null?"":this.right.value);
		return result;

	}
}
