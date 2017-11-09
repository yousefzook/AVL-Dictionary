package dictionaryGui;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DictionaryFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menu;
	private JMenu file;
	private DicPanel panel;
	JMenuItem open, save, load, exit;

	public DictionaryFrame() {
		super("Dictionary");
		initialGUI();
	}

	private void initialGUI() {
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		// here goes models
		panel = new DicPanel(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		createMenu();
	}

	private void createMenu() {

		menu = new JMenuBar();
		setJMenuBar(menu);
		file = new JMenu("File");
		file.setFont(new Font("Arial", Font.PLAIN, 18));
		menu.add(file);
		ImageIcon icon = new ImageIcon(getClass().getResource("openfolder.png"));
		open = new JMenuItem("Open", icon);
		open.setFont(new Font("Arial", Font.PLAIN, 16));
		load = new JMenuItem("Load");
		load.setFont(new Font("Arial", Font.PLAIN, 16));
		icon = new ImageIcon(getClass().getResource("save.png"));
		save = new JMenuItem("Save", icon);
		save.setFont(new Font("Arial", Font.PLAIN, 16));
		exit = new JMenuItem("Exit");
		exit.setFont(new Font("Arial", Font.BOLD, 16));
		file.add(open);
		file.addSeparator();
		file.add(save);
		file.add(load);
		file.addSeparator();
		file.add(exit);
		addlistners();
	}

	private void addlistners() {
		Listner ls = new Listner(this, panel);
		open.addActionListener(ls);
		load.addActionListener(ls);
		save.addActionListener(ls);
		exit.addActionListener(ls);
	}
}
