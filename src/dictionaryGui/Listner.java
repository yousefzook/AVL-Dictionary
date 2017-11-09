package dictionaryGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

import dictionary.Dictionary;

public class Listner implements ActionListener {

	private Dictionary dic;
	private DicPanel panel;
	private DictionaryFrame dicFrame;

	public Listner(DictionaryFrame df, DicPanel p) {
		dicFrame = df;
		panel = p;
		dic = Dictionary.getDic();
	}

	public File getFile() {
		JFileChooser test = new JFileChooser();
		test.showDialog(null, "Load");
		File file = test.getSelectedFile();
		if (file == null)
			return null;

		return file;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		Object s = event.getSource();
		if (s == dicFrame.open) {

		} else if (s == dicFrame.save) {

		} else if (s == dicFrame.load) {
			File file = getFile();
			dic.load(file);
			panel.outputField.setText(dic.loadContent());
			dicFrame.setVisible(true);
		} else if (s == dicFrame.exit)
			System.exit(0);

	}

}
