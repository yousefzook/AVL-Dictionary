package testavl;

import avlTree.*;
import dictionary.Dictionary;
import interfaces.IAVLTree;
import interfaces.IDictionary;

public class TestRunner {

	public static IAVLTree getImplementationInstance() {
		return new AVLTree();
	}

	public static IDictionary getDicImplementationInstance() {
		return Dictionary.getDic();
	}

}
