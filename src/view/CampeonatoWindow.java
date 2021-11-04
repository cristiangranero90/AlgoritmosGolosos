package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class CampeonatoWindow {

	private JFrame frmTp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CampeonatoWindow window = new CampeonatoWindow();
					window.frmTp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CampeonatoWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTp = new JFrame();
		frmTp.setIconImage(Toolkit.getDefaultToolkit().getImage(CampeonatoWindow.class.getResource("/view/images.jpg")));
		frmTp.setTitle("TP 3 - ALGORITMO GOLOSO");
		frmTp.setBounds(100, 100, 533, 396);
		frmTp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTp.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 46, 79, 22);
		frmTp.getContentPane().add(comboBox);
		comboBox.addItem(1);comboBox.addItem(2);comboBox.addItem(3);
		comboBox.addItem(4);comboBox.addItem(5);comboBox.addItem(6);
		comboBox.addItem(7);comboBox.addItem(8);comboBox.addItem(9);
JLabel lblNewLabel = new JLabel("Seleccionar fecha");
lblNewLabel.setBounds(10, 21, 111, 14);
frmTp.getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("");
lblNewLabel_1.setIcon(new ImageIcon(CampeonatoWindow.class.getResource("/view/images.jpg")));
lblNewLabel_1.setBounds(131, 0, 386, 357);
frmTp.getContentPane().add(lblNewLabel_1);
	}
}
