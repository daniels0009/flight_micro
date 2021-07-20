package interfaces;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.swing.SwingConstants;

import clases.Vuelo;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;


public class PantallaSeleccionVuelo extends JPanel {
	
	private Ventana ventana;
	private JTextField textFieldAerolinea;
	private JTextField textFieldFecha;
	private JTextField textFieldOrigen;
	private JTextField textFieldDestino;

	
	public PantallaSeleccionVuelo(Ventana v) {
		ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setBackground(Color.white);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		
		final JComboBox<Vuelo> campoSeleccionReserva = new JComboBox<Vuelo>();
		campoSeleccionReserva.setBounds(225, 209, 149, 22);
		panel_1.add(campoSeleccionReserva);
		
		// Botones
		
		JButton botonAtras = new JButton("Atrás");
		botonAtras.setBackground(Color.red);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irALogin();
			}
		});
		botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(botonAtras);
		
		JButton botonSeleccion = new JButton("Seleccionar");
		botonSeleccion.setBackground(Color.green);
		botonSeleccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldOrigen.getText().isBlank()) {
					JOptionPane.showMessageDialog(ventana, "Debe indicar la ciudad de origen","No se pudo cargar resultados",JOptionPane.ERROR_MESSAGE);
				} else {// Hacer consulta de vuelos
					try {
						Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoprog",
								"root","ithinkaboutyou");
						String consulta = "select * from Vuelo where aeropuertoOrigen = '"+textFieldOrigen.getText()+"'";
						Statement smt = conexion.createStatement();
						
						ResultSet consultaVuelo = smt.executeQuery(consulta);
						if (consultaVuelo.next()) {
							ventana.irAPantallaListadoVuelos(textFieldOrigen.getText());
						} else {
							JOptionPane.showMessageDialog(ventana, "Datos incorrectos","No se pudo mostrar el listado",
									 JOptionPane.ERROR_MESSAGE);
						}
						smt.close();
						conexion.close();
					} catch (SQLException e1) {
						 JOptionPane.showMessageDialog(ventana, e1.getMessage(),"No se pudo mostrar el listado",
								 JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		JButton botonEliminar = new JButton("Eliminar una reserva");
		botonEliminar.setBackground(Color.yellow);
		botonEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vuelo vueloSeleccionado =(Vuelo)campoSeleccionReserva.getSelectedItem();
				campoSeleccionReserva.removeItem(vueloSeleccionado);
				
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoprog",
							"root","ithinkaboutyou");
					Statement smt = conexion.createStatement();
					smt.execute("delete from Vuelo where aeropuertoOrigen='"+textFieldOrigen.getText()+"'");
					
					JOptionPane.showMessageDialog(ventana, "Datos eliminados","Reserva de vuelo eliminada",
							 JOptionPane.YES_NO_CANCEL_OPTION);
					
					
					smt.close();
					conexion.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		botonEliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(botonEliminar);
		botonSeleccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(botonSeleccion);
		
		// Etiquetas
		
		JLabel eiquetaTitulo = new JLabel("Selección de vuelo");
		eiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		eiquetaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(eiquetaTitulo, BorderLayout.NORTH);
		panel_1.setLayout(null);
		
		
		
		JLabel etiquetaOrigen = new JLabel("Ciudad de origen:");
		etiquetaOrigen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		etiquetaOrigen.setBounds(85, 91, 130, 14);
		panel_1.add(etiquetaOrigen);
		
		textFieldOrigen = new JTextField();
		textFieldOrigen.setBounds(225, 91, 149, 20);
		panel_1.add(textFieldOrigen);
		textFieldOrigen.setColumns(10);
		
		JLabel etiquetaDestino = new JLabel("Ciudad de destino:");
		etiquetaDestino.setFont(new Font("Tahoma", Font.PLAIN, 17));
		etiquetaDestino.setBounds(76, 127, 139, 14);
		panel_1.add(etiquetaDestino);
		
		// Campos
		
		textFieldDestino = new JTextField();
		textFieldDestino.setBounds(225, 127, 149, 20);
		panel_1.add(textFieldDestino);
		textFieldDestino.setColumns(10);
		
		JLabel etiquetaFecha = new JLabel("Fecha:");
		etiquetaFecha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		etiquetaFecha.setBounds(165, 163, 50, 14);
		panel_1.add(etiquetaFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(225, 163, 149, 20);
		panel_1.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		
		
		JLabel etiquetaReserva = new JLabel("Vuelos reservados:");
		etiquetaReserva.setFont(new Font("Tahoma", Font.PLAIN, 17));
		etiquetaReserva.setBounds(76, 210, 149, 14);
		panel_1.add(etiquetaReserva);
		
		JLabel etiquetaFondo = new JLabel("New label");
		etiquetaFondo.setIcon(new ImageIcon(".\\login.jpg"));
		etiquetaFondo.setBounds(0, 0, 450, 279);
		panel_1.add(etiquetaFondo);

	}
}
