package interfaces;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class PantallaPrincipal extends JPanel {
	
	private Ventana ventana;
	private final JButton botonSalir = new JButton("Salir");

	
	public PantallaPrincipal(Ventana v) {
		ventana = v;
		
		setLayout(new BorderLayout(0, 0));
		
		
		
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setBackground(Color.DARK_GRAY);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setLayout(null);
		
		JLabel etiquetaFondo = new JLabel("New label");
		etiquetaFondo.setIcon(new ImageIcon(".\\fondo.jpg"));
		etiquetaFondo.setBounds(0, 0, 450, 303);
		panel_1.add(etiquetaFondo);
		
		// Botones
		
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(botonSalir);
		botonSalir.setBackground(Color.red);
		
		JButton botonLogin = new JButton("Iniciar Sesión");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irALogin();
			}
		});
		botonLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(botonLogin);
		botonLogin.setBackground(Color.cyan);
		
		JButton botonRegistro = new JButton("Registrarse");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irARegistro();
			}
		});
		botonRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(botonRegistro);
		botonRegistro.setBackground(Color.yellow);
		
		
	}

	private void setContentPane(JLabel jLabel) {
		// TODO Auto-generated method stub
		
	}
}
