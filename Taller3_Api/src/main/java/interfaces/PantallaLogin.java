package interfaces;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Cliente;


import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;


public class PantallaLogin extends JPanel {
	
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private Ventana ventana;

	public PantallaLogin(Ventana v)  {
		ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		add(panelBotones, BorderLayout.SOUTH);
		panelBotones.setBackground(Color.white);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		
		
		JLabel etiquetaTitulo = new JLabel("Iniciar Sesión");
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(etiquetaTitulo, BorderLayout.NORTH);
		
		JLabel etiquetaEmail = new JLabel("Correo electrónico:");
		etiquetaEmail.setBounds(155, 60, 165, 19);
		etiquetaEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(etiquetaEmail);
		
		JLabel etiquetaContraseña = new JLabel("Contraseña:");
		etiquetaContraseña.setBounds(180, 139, 110, 19);
		etiquetaContraseña.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(etiquetaContraseña);
		
		// Campos
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 163, 200, 20);
		panel.add(passwordField);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(120, 84, 200, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel etiquetaFondo = new JLabel("New label");
		etiquetaFondo.setIcon(new ImageIcon(".\\login.jpg"));
		etiquetaFondo.setBounds(0, 0, 450, 278);
		panel.add(etiquetaFondo);
		
		// Botones
		
		JButton botonSalir = new JButton("Atrás");
		botonSalir.setBackground(Color.red);
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantallaPrincipal();
			}
		});
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBotones.add(botonSalir);
		
		JButton botonIniciar = new JButton("Entrar");
		botonIniciar.setBackground(Color.green);
		botonIniciar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (textFieldEmail.getText().isBlank()||passwordField.getPassword().toString().isBlank()) {
					 JOptionPane.showMessageDialog(ventana, "Todos los campos deben estar llenos","No se pudo iniciar sesión",
							 JOptionPane.ERROR_MESSAGE);
				 } {
						{
						
						 } 
						 
							 try {
								 
								 Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoprog",
										 "root","ithinkaboutyou");
								 String consulta = "select nombre,apellido1 from Cliente where email = '"+textFieldEmail.getText()+"'"
									 		+ " and contraseña = '"+new String (passwordField.getPassword())+"'";
								 Statement smt = conexion.createStatement();
								
								 ResultSet consultaUsuario =smt.executeQuery(consulta);
								 if(consultaUsuario.next()) {
								 JOptionPane.showMessageDialog(ventana, "Inicio de sesión realizado","¡Hola de nuevo!",
										 JOptionPane.YES_NO_CANCEL_OPTION);
								 ventana.irASeleccionVuelo();
								 } else {
									 JOptionPane.showMessageDialog(ventana, "Contraseña incorrecta","No se pudo iniciar sesión",JOptionPane.ERROR_MESSAGE);
								 }
								 
								 smt.close();
								 conexion.close();
								 
							 } catch (SQLException e1) {
								 JOptionPane.showMessageDialog(ventana, e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
							 } 
						 }
					
					} 
			
		});
		botonIniciar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBotones.add(botonIniciar);
		
	}
	
		 }

	


