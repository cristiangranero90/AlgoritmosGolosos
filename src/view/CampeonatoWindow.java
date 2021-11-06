package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.Color;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import presenter.Contract;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextPane;

public class CampeonatoWindow implements Contract.View {

	private JFrame frmTp;
	private JButton botonAtras;
	private JButton botonAplicar;
	private JComboBox<String> comboCriterio;
	private JTabbedPane tabsPanel;
	private JLabel labelCriterio;
	private JLabel labelImagen;

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
		try {
			UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		frmTp.setIconImage(Toolkit.getDefaultToolkit().getImage(CampeonatoWindow.class.getResource("/images/WindowIcon.jpg")));
		frmTp.setTitle("TP 3 : La Hora Referi");
		frmTp.setBounds(100, 100, 800, 600);
		frmTp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTp.getContentPane().setLayout(null);
		frmTp.setResizable(false);
		
		
		
		tabsPanel = new JTabbedPane(JTabbedPane.TOP);
		tabsPanel.setBounds(10, 11, 764, 539);
		frmTp.getContentPane().add(tabsPanel);
		
				
		JPanel Opciones = new JPanel();
		tabsPanel.addTab("Opciones", null, Opciones, null);
		Opciones.setLayout(null);
		
		botonAplicar = new JButton("Aplicar");
		botonAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//TODO Aplicar por criterio
			}
		});
		botonAplicar.setBounds(55, 170, 135, 23);
		Opciones.add(botonAplicar);
		
		comboCriterio = new JComboBox<String>();
		comboCriterio.setBounds(12, 124, 228, 23);
		comboCriterio.addItem("Heuristica por apariciones");
		comboCriterio.addItem("Heuristica por otro criterio");
		comboCriterio.addItem("Fuerza Bruta");
		comboCriterio.addItem("Backtracking");
		Opciones.add(comboCriterio);
		
		labelCriterio = new JLabel("Seleccione  criterio:");
		labelCriterio.setBounds(47, 89, 157, 23);
		Opciones.add(labelCriterio);
		
		labelImagen = new JLabel("");
		labelImagen.setIcon(new ImageIcon(CampeonatoWindow.class.getResource("/images/WindowIcon.jpg")));
		labelImagen.setBounds(410, 58, 269, 154);
		Opciones.add(labelImagen);
		
		JPanel Calendario = new JPanel();
		tabsPanel.addTab("Calendario", null, Calendario, null);
		Calendario.setLayout(new GridLayout(10, 10, 0, 0));
		
		//TODO 
		botonAtras = new JButton("Atras");
		JPanel panelPartidos = new JPanel();
		panelPartidos.setLayout(new GridLayout(10,10));
		//while partido has next, add new button seteo el  damePartido(i)
		panelPartidos.add(new JLabel("Boca - River       Arbitro Seleccionado: Jose"));
		panelPartidos.add(new JLabel("Otro"));
		panelPartidos.add(new JLabel("Otro1"));
		panelPartidos.add(new JLabel("Otro2"));
		panelPartidos.add(this.botonAtras);
		
		

		
		//atras.setLabel("Atras");
		botonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelPartidos.setVisible(false);
				//tabbedPane.getComponentAt(1).setVisible(false);
				tabsPanel.setComponentAt(1, Calendario);
				
			}
			
		});
		
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPartidos.setEnabled(true);
				panelPartidos.setVisible(true);
				
				
				tabsPanel.getComponentAt(1).setVisible(false);
				tabsPanel.setComponentAt(1, panelPartidos);
				
			}
		});
		Calendario.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("New button");
		Calendario.add(btnNewButton_3);		
		
		JButton btnNewButton_1 = new JButton("New button");
		Calendario.add(btnNewButton_1);
		
		
		//TODO Panel Grafico JfreeChart
		
		
		DefaultPieDataset dataset = new DefaultPieDataset( );
	    dataset.setValue("Arbitro 1", new Double( 20 ) );
	    dataset.setValue("Arbitro 2", new Double( 20 ) );
	    dataset.setValue("Arbitro 3", new Double( 40 ) );
	    dataset.setValue("Arbitro 4", new Double( 10 ) );

	    JFreeChart chart = ChartFactory.createPieChart(
	         "Apariciones de arbitros",   // chart title
	         dataset,          // data
	         true,             // include legend
	         true,
	         false);
	      
	    ChartPanel chartPanel = new ChartPanel(chart)  ;	    
	    tabsPanel.addTab("Grafico", null, chartPanel, null);
	  
		//Fin
		
		
		JPanel Acerca = new JPanel();
		tabsPanel.addTab("Acerca de", null, Acerca, null);
		Acerca.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Programacion III");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bauhaus 93", Font.BOLD, 44));
		lblNewLabel_1.setBounds(10, 35, 707, 72);
		Acerca.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Trabajo Practico 3, \"La hora, refer\u00ED\"");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(0, 129, 717, 34);
		Acerca.add(lblNewLabel_2);
		
		JTextPane txtpnheuristicaYAlgoritmos = new JTextPane();
		txtpnheuristicaYAlgoritmos.setEditable(false);
		txtpnheuristicaYAlgoritmos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnheuristicaYAlgoritmos.setText("\"Heuristica y algoritmos golosos\"\r\n\r\nAlumnos: \r\nCristian Granero - Lorenzo Ortiz.\r\n\r\nProfesores:\r\nJavier Marenco - Patricia Bagnes\r\n\r\n\r\nUniversidad Nacional de General Sarmiento - A\u00F1o 2021");
		txtpnheuristicaYAlgoritmos.setBounds(179, 175, 399, 181);
		Acerca.add(txtpnheuristicaYAlgoritmos);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(CampeonatoWindow.class.getResource("/images/ungsjpg.jpg")));
		lblNewLabel_3.setBounds(10, 379, 707, 99);
		Acerca.add(lblNewLabel_3);
		
		
	}
}
