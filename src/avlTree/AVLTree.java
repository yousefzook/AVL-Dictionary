package avlTree;

import avlTree.Node;
import interfaces.IAVLTree;
import interfaces.INode;

public class AVLTree<T extends Comparable<T>> implements IAVLTree<T> {

	private static final int ALLOWED_IMBALANCE = 1;
	private Node<T> root;
	private int size;
	boolean found = false;
	boolean inserted = false;
	private String content = "";

	public AVLTree() {
		size = 0;
	}

	@Override
	public void insert(T key) {
		inserted = false;
		root = ins(root, key);
		if (!inserted)
			size++;
	}

	private Node<T> ins(Node<T> x, T key) {
		if (x == null)
			return new Node<T>(key);
		int comp = key.compareTo(x.getValue());
		if (comp == 0)
			inserted = true;
		if (comp < 0)
			x.setLeft(ins(((Node<T>) x.getLeftChild()), key));
		else if (comp > 0)
			x.setRight(ins(((Node<T>) x.getRightChild()), key));
		return balance(x);
	}

	private Node<T> balance(Node<T> t) {
		if (t == null)
			return t;
		if (findHeight((Node<T>) t.getLeftChild()) - findHeight((Node<T>) t.getRightChild()) > ALLOWED_IMBALANCE) {
			if (findHeight((Node<T>) t.getLeftChild().getLeftChild()) >= findHeight(
					(Node<T>) t.getLeftChild().getRightChild()))
				t = rotateWithLeftChild(t);
			else
				t = doubleWithLeftChild(t);
		} else if (findHeight((Node<T>) t.getRightChild()) - findHeight((Node<T>) t.getLeftChild()) > ALLOWED_IMBALANCE)
			if (findHeight((Node<T>) t.getRightChild().getRightChild()) >= findHeight(
					(Node<T>) t.getRightChild().getLeftChild()))
				t = rotateWithRightChild(t);
			else
				t = doubleWithRightChild(t);
		t.setH(Math.max(findHeight((Node<T>) t.getLeftChild()), findHeight((Node<T>) t.getRightChild())) + 1);
		return t;
	}

	private Node<T> doubleWithRightChild(Node<T> t) {
		t.setRight(rotateWithLeftChild((Node<T>) t.getRightChild()));
		return rotateWithRightChild(t);
	}

	private Node<T> rotateWithRightChild(Node<T> k2) {
		Node<T> k1 = (Node<T>) k2.getRightChild();
		k2.setRight((Node<T>) k1.getLeftChild());
		k1.setLeft(k2);
		k2.setH(Math.max(findHeight((Node<T>) k2.getLeftChild()), findHeight((Node<T>) k2.getRightChild())) + 1);
		k1.setH(Math.max(k2.geth(), findHeight((Node<T>) k1.getRightChild())) + 1);
		return k1;
	}

	private Node<T> doubleWithLeftChild(Node<T> t) {
		t.setLeft(rotateWithRightChild((Node<T>) t.getLeftChild()));
		return rotateWithLeftChild(t);
	}

	private Node<T> rotateWithLeftChild(Node<T> k2) {
		Node<T> k1 = (Node<T>) k2.getLeftChild();
		k2.setLeft((Node<T>) k1.getRightChild());
		k1.setRight(k2);
		k2.setH(Math.max(findHeight((Node<T>) k2.getLeftChild()), findHeight((Node<T>) k2.getRightChild())) + 1);
		k1.setH(Math.max(findHeight((Node<T>) k1.getLeftChild()), k2.geth()) + 1);
		return k1;
	}

	private int findHeight(Node<T> t) {
		return t == null ? -1 : t.geth();
	}

	@Override
	public boolean delete(T key) {
		found = false;
		root = del(root, key);
		if (found)
			size--;
		return found;
	}

	private Node<T> del(Node<T> t, T key) {

		if (t == null)
			return t;
		int compareResult = key.compareTo(t.getValue());
		if (compareResult == 0)
			found = true;
		if (compareResult < 0)
			t.setLeft(del(((Node<T>) t.getLeftChild()), key));
		else if (compareResult > 0)
			t.setRight(del(((Node<T>) t.getRightChild()), key));
		else if (t.getLeftChild() != null && t.getRightChild() != null) // Two
		{
			t.setValue(findMin((Node<T>) t.getRightChild()).getValue());
			t.setRight(del(((Node<T>) t.getRightChild()), t.getValue()));
		} else
			t = (Node<T>) ((t.getLeftChild() != null) ? t.getLeftChild() : t.getRightChild());
		return balance(t);
	}

	private Node<T> findMin(Node<T> x) {

		while (x.getLeftChild() != null)
			x = (Node<T>) x.getLeftChild();
		return x;
	}

	@Override
	public boolean search(T key) {

		INode<T> x = root;
		while (x != null) {
			int cmp = key.compareTo(x.getValue());
			if (cmp < 0)
				x = x.getLeftChild();
			else if (cmp > 0)
				x = x.getRightChild();
			else if (cmp == 0)
				return true;
		}
		return false;

	}

	@Override
	public int height() {

		return root == null ? -1 : root.geth();
	}

	public int size() {

		return size;
	}

	public String loadContent() {
		content = "";
		printInOrder(root);
		return content;
	}

	private void printInOrder(Node<T> r) {
		if (r != null) {
			if (r.getLeftChild() != null)
				printInOrder((Node<T>) r.getLeftChild());

			content += r.getValue() + "\n";
			if (r.getRightChild() != null)
				printInOrder((Node<T>) r.getRightChild());
		}
	}

	@Override
	public INode<T> getTree() {
		return root;
	}

}
