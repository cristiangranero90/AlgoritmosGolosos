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
import javax.swing.JCheckBox;
import javax.swing.JSlider;

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
	private JCheckBox checkBoxNombres;
	private JSlider slider;
	private JButton botonSalir;

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
		tabsPanel.addTab("Calendario", null, Calendario, "Calendario de partidos ");		
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
		tabsPanel.addTab("Opciones", null, Opciones, "Opciones para obtener una solucion");
		Opciones.setLayout(null);
		
		botonAplicar = new JButton("Aplicar");
		botonAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				botonAplicarPresionado((String) comboCriterio.getSelectedItem());
			}
		});
		botonAplicar.setBounds(486, 259, 135, 23);
		Opciones.add(botonAplicar);
		
		comboCriterio = new JComboBox<String>();
		comboCriterio.setBounds(446, 101, 228, 23);
		comboCriterio.addItem("Heuristica por apariciones");
		comboCriterio.addItem("Heuristica por premiacion");
		comboCriterio.addItem("Fuerza Bruta");
		comboCriterio.addItem("Backtracking");
		Opciones.add(comboCriterio);
		
		labelCriterio = new JLabel("Seleccione  criterio:");
		labelCriterio.setBounds(513, 67, 98, 23);
		Opciones.add(labelCriterio);
		
		labelImagen = new JLabel("");
		labelImagen.setIcon(new ImageIcon(CampeonatoWindow.class.getResource("/images/WindowIcon.jpg")));
		labelImagen.setBounds(44, 101, 269, 154);
		Opciones.add(labelImagen);
		
		JLabel labelTituloOpciones = new JLabel("La Hora, referi");
		labelTituloOpciones.setForeground(Color.BLACK);
		labelTituloOpciones.setBackground(Color.WHITE);
		labelTituloOpciones.setFont(new Font("Arial", Font.BOLD, 29));
		labelTituloOpciones.setBounds(77, 11, 228, 46);
		Opciones.add(labelTituloOpciones);
		
		JLabel labelSolucion = new JLabel("Opciones para obtener una solucion:");
		labelSolucion.setBounds(463, 20, 189, 41);
		Opciones.add(labelSolucion);
		
		checkBoxNombres = new JCheckBox("Asignar nombres ");
		checkBoxNombres.setBounds(500, 218, 111, 23);
		Opciones.add(checkBoxNombres);
		
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMaximum(45);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(3);
		slider.setMajorTickSpacing(6);
		slider.setMinimum(3);
		slider.setBounds(403, 160, 310, 41);
		Opciones.add(slider);		
		
		JLabel labelCantArbitros = new JLabel("Cantidad de arbitros");
		labelCantArbitros.setBounds(510, 135, 111, 14);
		Opciones.add(labelCantArbitros);
		
		botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTp.dispose();
			}
		});
		botonSalir.setBounds(486, 293, 135, 23);
		Opciones.add(botonSalir);
	}

	public void construirTabAcercaDe() {
		Acerca = new JPanel();
		tabsPanel.addTab("Acerca de", null, Acerca, "Acerca de " );
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
		txtpnheuristicaYAlgoritmos.setText("\n\"Heuristica y algoritmos golosos\"\r\n\r\nAlumnos: \r\nCristian Granero - Lorenzo Ortiz.\r\n\r\nProfesores:\r\nJavier Marenco - Patricia Bagnes\r\n\r\n");
		txtpnheuristicaYAlgoritmos.setBounds(240, 192, 242, 157);
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
			DefaultPieDataset dataset = new DefaultPieDataset( );
		    dataset.setValue("Sin datos", 100.0 );
		    JFreeChart chart = ChartFactory.createPieChart(
			         "Repeticiones de arbitros por club [SIN ASIGNAR]",   // chart title
			         dataset,          // data
			         true,             // include legend
			         true,
			         false);
			      
			    ChartPanel chartPanel = new ChartPanel(chart)  ;	    
			    tabsPanel.addTab("Grafico", null, chartPanel, "Muestra la estadistica de las apariciones de arbitros");			
		}
		
		else {
			
			tabsPanel.setTabComponentAt(2, null);;
			DefaultPieDataset dataset = new DefaultPieDataset();
			double[] valores = pedirEstadisticas();
			String[] nombres = pedirNombres();
			
			for (int i = 0; i < nombres.length ; i++) {
				dataset.setValue(nombres[i] , valores[i]);
			}
			
		    JFreeChart chart = ChartFactory.createPieChart(
		         "Repeticiones de arbitros por cada club",   // chart title
		         dataset,          // data
		         true,             // include legend
		         true,
		         false);
		      
		    ChartPanel chartPanel = new ChartPanel(chart)  ;	    
		    tabsPanel.setComponentAt(2, chartPanel);
		    
		}
		
	}

	@Override
	public String[] pedirNombres() {		
		return presentador.dameClubs();
	}

	@Override
	public void construirCalendario() {
		
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

	protected void botonAplicarPresionado(String selectedItem) {
		crearArbitros(checkBoxNombres.isSelected(), slider.getValue());
		presentador.botonAplicar(selectedItem);
		Exito nuevo = new Exito();
		nuevo.habilitar();
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

	@Override
	public double[] pedirEstadisticas() {
		return presentador.dameEstadistica();
	}

	@Override
	public void crearArbitros(boolean nombres, int cantidad) {
		presentador.construirArbitros(nombres, cantidad);		
	}
}
