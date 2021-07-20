package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Cliente;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;


public class PantallaRegistro extends JPanel {
	
	private JTextField textFieldNombre;
	private JTextField textFieldApellido1;
	private JTextField textFieldEmail;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JTextField textFieldApellido2;
	private Ventana ventana;
	private JTextField textFieldDni;
	private JTextField textFieldDireccion;

	
	public PantallaRegistro(Ventana v) {
		ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setBackground(Color.white);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		
		// Etiquetas
		
		JLabel etiquetatitulo = new JLabel("Registro");
		etiquetatitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetatitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(etiquetatitulo, BorderLayout.NORTH);
		
		JLabel etiquetaNombre = new JLabel("Nombre:");
		etiquetaNombre.setBounds(89, 30, 57, 19);
		etiquetaNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(etiquetaNombre);
		
		JLabel etiquetaUsuario = new JLabel("Alias/Usuario:");
		etiquetaUsuario.setBounds(291, 30, 87, 19);
		etiquetaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(etiquetaUsuario);
		
		JLabel etiquetaApellido1 = new JLabel("Primer apellido:");
		etiquetaApellido1.setBounds(69, 79, 97, 19);
		etiquetaApellido1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(etiquetaApellido1);
		
		JLabel etiquetaEmail = new JLabel("Correo electrónico:");
		etiquetaEmail.setBounds(255, 79, 121, 19);
		etiquetaEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(etiquetaEmail);
		
		JLabel etiquetaApellido2 = new JLabel("Segundo apellido:");
		etiquetaApellido2.setBounds(62, 128, 112, 19);
		etiquetaApellido2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(etiquetaApellido2);
		
		JLabel etiquetaContraseña = new JLabel("Contraseña:");
		etiquetaContraseña.setBounds(295, 128, 79, 19);
		etiquetaContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(etiquetaContraseña);
		
		JLabel etiquetaDni = new JLabel("DNI:");
		etiquetaDni.setBounds(102, 177, 31, 19);
		etiquetaDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(etiquetaDni);
		
		JLabel etiquetaDireccion = new JLabel("Dirección:");
		etiquetaDireccion.setBounds(303, 177, 62, 19);
		etiquetaDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(etiquetaDireccion);
		
		// Campos
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(32, 54, 172, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(255, 54, 159, 20);
		panel_1.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldApellido1 = new JTextField();
		textFieldApellido1.setBounds(32, 103, 172, 20);
		panel_1.add(textFieldApellido1);
		textFieldApellido1.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(255, 103, 159, 20);
		panel_1.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldApellido2 = new JTextField();
		textFieldApellido2.setBounds(32, 152, 172, 20);
		panel_1.add(textFieldApellido2);
		textFieldApellido2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(255, 152, 159, 20);
		passwordField.setText("");
		panel_1.add(passwordField);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(32, 201, 172, 20);
		panel_1.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(255, 201, 159, 20);
		panel_1.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JLabel etiquetaFondo = new JLabel("New label");
		etiquetaFondo.setIcon(new ImageIcon(".\\login.jpg"));
		etiquetaFondo.setBounds(0, 0, 450, 273);
		panel_1.add(etiquetaFondo);
		
		// Botones
		
		JButton botonAtras = new JButton("Atrás");
		botonAtras.setBackground(Color.red);
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantallaPrincipal();
			}
		});
		botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(botonAtras);
		
		JButton botonRegistro = new JButton("Registro");
		botonRegistro.setBackground(Color.green);
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldNombre.getText().isBlank() || textFieldUsuario.getText().isBlank() ||
						textFieldApellido1.getText().isBlank() || textFieldApellido2.getText().isBlank()||
						textFieldEmail.getText().isBlank()||passwordField.getPassword().toString().isBlank()) {
					JOptionPane.showMessageDialog(ventana, "Todos los campos deben estar llenos","No se pudo registrar",
							JOptionPane.ERROR_MESSAGE);
				} else {//Se puede registrar
					try {
					Cliente clienteRegistrado = new Cliente(textFieldNombre.getText(), textFieldApellido1.getText(), 
							textFieldApellido2.getText(), textFieldEmail.getText(), textFieldUsuario.getText(),
							passwordField.getPassword().toString(), textFieldDni.getText(), textFieldDireccion.getText());

						Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoprog",
								"root", "ithinkaboutyou");

					Statement smt = conexion.createStatement();
					smt.executeUpdate("insert into Cliente values('" + textFieldNombre.getText() + "','"
							+ textFieldUsuario.getText() + "','" + textFieldApellido1.getText() + "','"
							+ textFieldApellido2.getText() +"','" + textFieldDireccion.getText() +"','"
							+ textFieldEmail.getText() + "','" + textFieldDni.getText() + "','"
							+ new String (passwordField.getPassword()) +"')");
					JOptionPane.showMessageDialog(ventana, "Usuario registrado correctamente", "¡Bienvenido/a!",
							JOptionPane.YES_NO_CANCEL_OPTION);

					ventana.irASeleccionVuelo();
					smt.close();
					conexion.close();
										
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(ventana, e1.getMessage(),"No se pudo registrar",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		botonRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(botonRegistro);
		

		

		


	}

}
