package interfaces;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


import clases.Aeropuerto;
import clases.Vuelo;

import java.awt.GridBagConstraints;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ImageIcon;


public class PantallaListadoVuelos extends JPanel {

	private Ventana ventana;
	private JTable table;
	
	public PantallaListadoVuelos (Ventana v, String origen) {
		this.ventana = v;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBounds(0, 0, 450, 29);
		panelCentral.add(panelTitulo);
		
		JLabel etiquetaTitulo = new JLabel("Listado de Vuelos:");
		etiquetaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelTitulo.add(etiquetaTitulo);
		
		 
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoprog","root","ithinkaboutyou");
			String consulta = "select aerolinea, fecha, aeropuertoOrigen,aeropuertoDestino from Vuelo where aeropuertoOrigen = '"+origen+"'";
			
			Statement smt = conexion.createStatement();
			ResultSet consultaVuelo = smt.executeQuery(consulta);
			
			String[] nombreCampos = {"fecha","aeropuertoOrigen","aeropuertoDestino"};
			Object [][] vuelos=new Object[5][4];
			
			byte cont = 0;
			while(consultaVuelo.next()) {
				Vuelo vuelo = new Vuelo(null, consultaVuelo.getInt("codVuelo"), new Aeropuerto(consultaVuelo.getString("aeropuertoOrigen")),
						new Aeropuerto(consultaVuelo.getString("aeropuertoDestino")), null);
				
				vuelos[cont][0] = vuelo.getFecha();
				vuelos[cont][1] = vuelo.getAeropuertoOrigen();
				vuelos[cont][2] = vuelo.getAeropuertoDestino();
				cont ++;
			}
			
			smt.close();
			conexion.close();
			table = new JTable(vuelos,nombreCampos);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

		
		
		//select * from vuelo where...
		//for(int i=0;i<nv;i++) {
			//Sacar del resultset los datos del vuelo, y meter el de cada uno de ellos en una de las filas de vuelos.
		//}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 40, 386, 210);
		panelCentral.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		JLabel etiquetaFondo = new JLabel("New label");
		etiquetaFondo.setIcon(new ImageIcon(".\\login.jpg"));
		etiquetaFondo.setBounds(0, 26, 450, 272);
		panelCentral.add(etiquetaFondo);
		
		JPanel panelBotones = new JPanel();
		add(panelBotones, BorderLayout.SOUTH);
		
		JButton botonAtras = new JButton("Atrás");
		botonAtras.setBackground(Color.RED);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irASeleccionVuelo();
			}
		});
		botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBotones.add(botonAtras);
		
		JButton botonReservar = new JButton("Reservar");
		botonReservar.setBackground(Color.GREEN);
		botonReservar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ventana.vuelo = (Vuelo) comboBoxVuelos.getSelectedItem();
				JOptionPane.showMessageDialog(ventana, "Vuelo reservado","¡Disfrute su viaje!",
						 JOptionPane.YES_NO_CANCEL_OPTION);
				ventana.irASeleccionVuelo();
			}
		});
		botonReservar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBotones.add(botonReservar);
		


	}
}
