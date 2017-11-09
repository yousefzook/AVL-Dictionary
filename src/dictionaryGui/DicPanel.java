package dictionaryGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DicPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	JTextField inputField;
	JTextArea outputField;
	JLabel res;
	JButton search, insert, delete, height, size;

	public DicPanel(JFrame fr) {
		frame = fr;
		intitializePanel();
	}

	private void intitializePanel() {

		setButtons();
		addHanler();
		setTextAreas();
		JLabel contentPane = new JLabel();
		contentPane.setLayout(new BorderLayout());
		frame.setContentPane(contentPane);
		frame.getContentPane().add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void setTextAreas() {
		inputField = new JTextField();
		inputField.setFont(new Font("Consolas", Font.PLAIN, 18));
		inputField.setForeground(Color.black);
		inputField.setBackground(Color.WHITE);
		inputField.setPreferredSize( new Dimension( 700, 35 ) );
		outputField = new JTextArea(30,30);
		outputField.setFont(new Font("Consolas", Font.BOLD, 20));
		outputField.setForeground(Color.red);
		outputField.setBackground(Color.WHITE);
		outputField.setEditable(false);
		outputField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		res = new JLabel();
		res.setFont(new Font("Consolas", Font.PLAIN, 18));
		res.setForeground(Color.black);
		JPanel field = new JPanel();
		field.add(inputField);
		add(field);
		JScrollPane scroll = new JScrollPane(outputField);
		scroll.createVerticalScrollBar();
		add(scroll);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		res.setText("0");
		add(res);
	}

	private void setButtons() {
		JPanel butPanel = new JPanel(new GridLayout(1, 5, 0, 40));
		search = new JButton("Search");
		search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		search.setForeground(Color.red);
		search.setContentAreaFilled(false);
		search.setFont(new Font("Arial", Font.PLAIN, 18));
		insert = new JButton("Insert");
		insert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		insert.setForeground(Color.red);
		insert.setContentAreaFilled(false);
		insert.setFont(new Font("Arial", Font.PLAIN, 18));
		delete = new JButton("Delete");
		delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delete.setForeground(Color.red);
		delete.setContentAreaFilled(false);
		delete.setFont(new Font("Arial", Font.PLAIN, 18));
		height = new JButton("Height");
		height.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		height.setForeground(Color.red);
		height.setBackground(Color.black);
		height.setFont(new Font("Arial", Font.PLAIN, 18));
		size = new JButton("Size");
		size.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		size.setForeground(Color.red);
		size.setBackground(Color.black);
		size.setFont(new Font("Arial", Font.PLAIN, 18));
		butPanel.add(search);
		butPanel.add(insert);
		butPanel.add(delete);
		butPanel.add(height);
		butPanel.add(size);
		butPanel.setBorder(BorderFactory.createEmptyBorder(10, 2, 0, 2));
		add(butPanel);

	}

	private void addHanler() {

		ButtonHandler hndlr = new ButtonHandler(this);
		search.addActionListener(hndlr);
		insert.addActionListener(hndlr);
		delete.addActionListener(hndlr);
		height.addActionListener(hndlr);
		size.addActionListener(hndlr);

	}

}
