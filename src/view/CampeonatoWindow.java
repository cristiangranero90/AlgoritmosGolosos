package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import java.awt.Canvas;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

import java.awt.Font;
import javax.swing.SwingConstants;

public class CampeonatoWindow {

	private JFrame frmTp;
	private JButton atras;

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
		frmTp.setBounds(100, 100, 800, 600);
		frmTp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTp.getContentPane().setLayout(null);
		frmTp.setResizable(false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 764, 539);
		frmTp.getContentPane().add(tabbedPane);
		
				
		JPanel Opciones = new JPanel();
		tabbedPane.addTab("Opciones", null, Opciones, null);
		Opciones.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(29, 163, 89, 23);
		Opciones.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(29, 65, 182, 23);
		Opciones.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(29, 25, 182, 23);
		Opciones.add(lblNewLabel);
		
		JPanel Calendario = new JPanel();
		tabbedPane.addTab("Calendario", null, Calendario, null);
		Calendario.setLayout(new GridLayout(10, 10, 0, 0));
		
		//TODO 
		atras = new JButton("Atras");
		JPanel nuevo = new JPanel();
		nuevo.setLayout(new GridLayout(10,10));
		//while partido has next, add new button seteo el  damePartido(i)
		nuevo.add(new JLabel("Boca - River       Arbitro Seleccionado: Jose"));
		nuevo.add(new JLabel("Otro"));
		nuevo.add(new JLabel("Otro1"));
		nuevo.add(new JLabel("Otro2"));
		nuevo.add(this.atras);
		
		

		
		//atras.setLabel("Atras");
		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nuevo.setVisible(false);
				//tabbedPane.getComponentAt(1).setVisible(false);
				tabbedPane.setComponentAt(1, Calendario);
				
			}
			
		});
		
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo.setEnabled(true);
				nuevo.setVisible(true);
				
				
				tabbedPane.getComponentAt(1).setVisible(false);
				tabbedPane.setComponentAt(1, nuevo);
				
			}
		});
		Calendario.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("New button");
		Calendario.add(btnNewButton_3);		
		
		JButton btnNewButton_1 = new JButton("New button");
		Calendario.add(btnNewButton_1);
		
		
	}
}
