package dictionaryGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dictionary.Dictionary;

public class ButtonHandler implements ActionListener {

	private Dictionary dic;
	private DicPanel panel;

	public ButtonHandler(DicPanel p) {
		panel = p;
		dic = Dictionary.getDic();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		String txt = panel.inputField.getText();
		if (s.equals(panel.search)) {
			if (dic.exists(txt))
				panel.res.setText("True");
			else
				panel.res.setText("False");
		} else if (s.equals(panel.insert)) {
			if (dic.insert(txt))
				panel.res.setText("True");
			else
				panel.res.setText("False");
			panel.outputField.setText(dic.loadContent());
		} else if (s.equals(panel.delete)) {
			if (dic.delete(txt))
				panel.res.setText("True");
			else
				panel.res.setText("False");
			panel.outputField.setText(dic.loadContent());
		} else if (s.equals(panel.height)) {
			panel.res.setText(Integer.toString(dic.height()));
		} else if (s.equals(panel.size)) {
			panel.res.setText(Integer.toString(dic.size()));
		}

	}

}
