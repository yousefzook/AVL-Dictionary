package dictionary;

import java.io.File;
import java.util.Scanner;

import interfaces.IDictionary;


public class Dictionary implements IDictionary {

	private static Dictionary dic;
	private AVLTree<String> avl = new AVLTree<String>();

	public static Dictionary getDic() {
		if (dic == null)
			dic = new Dictionary();
		return dic;
	}

	private Dictionary() {

	}

	@Override
	public void load(File file) {
		try (Scanner input = new Scanner(file);) {
			while (input.hasNext()) {
				avl.insert(input.next());
			}
		} catch (Exception e) {
			System.out.println("Bad File !");
		}
	}

	@Override
	public boolean insert(String word) {
		if (avl.search(word))
			return false;
		else {
			avl.insert(word);
			return true;
		}
	}

	@Override
	public boolean exists(String word) {
		return avl.search(word);
	}

	@Override
	public boolean delete(String word) {
		return avl.delete(word);
	}

	@Override
	public int size() {
		return avl.size();
	}

	@Override
	public int height() {
		return avl.height();
	}

	public String loadContent() {
		return avl.loadContent();
	}
}
