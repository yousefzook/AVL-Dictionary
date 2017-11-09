package avlTree;

import interfaces.INode;

public class Node<T extends Comparable<T>> implements INode<T> {

	private Node<T> left;
	private Node<T> right;
	private Node<T> parent;
	private T value;
	private int height;

	public Node(T v) {
		left = null;
		right = null;
		parent = null;
		value = v;
		height = 0;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	@Override
	public INode<T> getLeftChild() {
		// TODO Auto-generated method stub
		return this.left;
	}

	@Override
	public INode<T> getRightChild() {
		// TODO Auto-generated method stub
		return this.right;
	}

	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}

	@Override
	public void setValue(T value) {
		// TODO Auto-generated method stub
		this.value = value;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public int geth() {
		return height;
	}

	public void setH(int h) {
		this.height = h;
	}

}
