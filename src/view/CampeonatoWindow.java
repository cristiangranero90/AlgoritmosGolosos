package view;

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
import presenter.Presenter;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextPane;

public class CampeonatoWindow implements Contract.View {

	private Presenter presentador;
	private JFrame frmTp;
	private JButton botonAplicar;
	private JButton[] botonesCalendario;
	private JComboBox<String> comboCriterio;
	private JTabbedPane tabsPanel;
	private JLabel labelCriterio;
	private JLabel labelImagen;
	private JPanel Opciones;
	private JPanel Calendario;
	private JPanel Acerca;

	/**
	 * Create the application.
	 */
	public CampeonatoWindow() {
		initialize();
		frmTp.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTp = new JFrame();
		presentador = new Presenter(this);
		
		//Look and Feel
		try {
			UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		 
		//Configuracion de frame principal
		frmTp.setIconImage(Toolkit.getDefaultToolkit().getImage(CampeonatoWindow.class.getResource("/images/WindowIcon.jpg")));
		frmTp.setTitle("TP 3 : La Hora Referi");
		frmTp.setBounds(100, 100, 800, 600);
		frmTp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTp.getContentPane().setLayout(null);
		frmTp.setResizable(false);		
		
		//Tabs panel incializador
		tabsPanel = new JTabbedPane(JTabbedPane.TOP);
		tabsPanel.setBounds(10, 11, 764, 539);
		frmTp.getContentPane().add(tabsPanel);
		
		//Tab opciones
		
		construirTabOpciones();
		
		
		//Tab Calendario
		Calendario = new JPanel();			
		tabsPanel.addTab("Calendario", null, Calendario, null);		
		Calendario.setLayout(new GridLayout(10, 10, 2, 2));	
		
		construirCalendario();		
		
		//TODO Tab Panel Grafico JfreeChart
		
		
		construirGrafico();
	  
		//Fin
		
		
	    //Tab Acerca de 
		construirTabAcercaDe();
		
		
	}

	public void construirTabOpciones() {
		Opciones = new JPanel();
		tabsPanel.addTab("Opciones", null, Opciones, null);
		Opciones.setLayout(null);
		
		botonAplicar = new JButton("Aplicar");
		botonAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				botonAplicarPresionado((String) comboCriterio.getSelectedItem());
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
	}

	protected void botonAplicarPresionado(String selectedItem) {
		presentador.botonAplicar(selectedItem);
		
	}

	public void construirTabAcercaDe() {
		Acerca = new JPanel();
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

	@Override
	public void construirGrafico() {
				
		if (!existenArbitros()) {
			System.out.println(existenArbitros());
			DefaultPieDataset dataset = new DefaultPieDataset( );
		    dataset.setValue("Sin datos", new Double( 100 ) );
		    JFreeChart chart = ChartFactory.createPieChart(
			         "Apariciones de arbitros [SIN ASIGNAR]",   // chart title
			         dataset,          // data
			         true,             // include legend
			         true,
			         false);
			      
			    ChartPanel chartPanel = new ChartPanel(chart)  ;	    
			    tabsPanel.addTab("Grafico", null, chartPanel, null);			
		}
		else {
			
			tabsPanel.setTabComponentAt(2, null);;
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
		    tabsPanel.setComponentAt(2, chartPanel);
		    construirCalendario();
		}
		
	}

	private void construirCalendario() {
		
		if (tabsPanel.getComponentCount() > 2) {
			//System.out.println("Entro tabs");
			Calendario.removeAll();
			Calendario.setLayout(new GridLayout(10, 10, 2, 2));
			tabsPanel.setComponentAt(1, Calendario);
		}
		botonesCalendario = new JButton[presentador.dameCantidadFechas()];
		//System.out.println("Y siguio");
		for (int i = 0; i < botonesCalendario.length ; i++) {
			JButton botonFecha = new JButton("Fecha: " + (i+1) );
			JButton atrasOtro = new JButton("Atras");
			final JPanel panelPartidosOtro = new JPanel();
			panelPartidosOtro.setLayout(new GridLayout(10,10,2,2));			
			
			for (int j = 0; j<presentador.dameCantidadDePartidos(i); j++) {
						
				JLabel nueva = new JLabel(pedirNombrePartidos(i, j));
				nueva.setHorizontalAlignment(SwingConstants.CENTER);
				panelPartidosOtro.add(nueva);				
			}
			
			atrasOtro.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Calendario.revalidate();
					tabsPanel.setComponentAt(1, Calendario);	
					tabsPanel.repaint();
					tabsPanel.revalidate();
				}
				
			});		
			
			botonFecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelPartidosOtro.setEnabled(true);
					panelPartidosOtro.setVisible(true);				
					tabsPanel.getComponentAt(1).setVisible(false);
					tabsPanel.setComponentAt(1, panelPartidosOtro);
					tabsPanel.revalidate();
				
				}
		    });
			panelPartidosOtro.add(atrasOtro);
			Calendario.add(botonFecha);
		}
	}

	@Override
	public String pedirNombrePartidos(int fechaNumero, int partidoNumero) {		
		return presentador.damePartido(fechaNumero, partidoNumero);
	}

	@Override
	public int dameCantidadFechas() {
		return presentador.dameCantidadFechas();
	}

	@Override
	public int dameCantidadDePartidos(int fechaNumero) {
		return presentador.dameCantidadDePartidos(fechaNumero);
	}

	@Override
	public boolean existenArbitros() {
		return presentador.arbitrosAsignados();
	}
}
