package interfaces;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;


import clases.Vuelo;


public class Ventana extends JFrame {

	private PantallaLogin login;
	private PantallaRegistro registro;
	private PantallaSeleccionVuelo seleccionVuelo;
	private PantallaPrincipal principal;
	private PantallaListadoVuelos listadoVuelos;
	
	
	public Ventana() {
		this.principal = new PantallaPrincipal(this);	
		this.setSize(450,400);
		this.setLocation(600,300);
		this.setContentPane(this.principal);
		this.setTitle("Sistema de Reserva de Vuelos");
		this.setMinimumSize(new Dimension(450, 400));
		this.setResizable(false);
		
		try {
			Image img = ImageIO.read(new File("rose.png"));
			this.setIconImage(img); // Con todo esto colocamos un icono en la ventana.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void irASeleccionVuelo() {
		if (this.seleccionVuelo == null) {
			this.seleccionVuelo = new PantallaSeleccionVuelo(this);
		}
		if (registro != null) {this.registro.setVisible(false);}
		if (login != null) {this.login.setVisible(false);}
		if (listadoVuelos != null) {this.listadoVuelos.setVisible(false);}
		this.setContentPane(seleccionVuelo);
		this.seleccionVuelo.setVisible(true);
	}
	
	public void irARegistro() {
		if (this.registro == null) {
			this.registro = new PantallaRegistro(this);
		}
		this.principal.setVisible(false);
		this.setContentPane(registro);
		this.registro.setVisible(true);
	}
	
	public void irALogin() {
		if (this.login == null) {
			this.login = new PantallaLogin(this);
		}
		if (this.principal != null) {this.principal.setVisible(false);}
		if (this.seleccionVuelo != null) {this.seleccionVuelo.setVisible(false);}
		this.setContentPane(login);
		this.login.setVisible(true);
	}
	
	public void irAPantallaPrincipal() {
		if(this.principal == null) {
			this.principal = new PantallaPrincipal(this);
		}
		if (login != null) {this.login.setVisible(false);}
		if (registro != null) {this.registro.setVisible(false);}
		this.setContentPane(principal);
		this.principal.setVisible(true);
	}
	
	public void irAPantallaListadoVuelos(String origen) {
		if(this.listadoVuelos == null) {
			this.listadoVuelos = new PantallaListadoVuelos(this,origen);
		}
		this.seleccionVuelo.setVisible(false);
		this.setContentPane(listadoVuelos);
		this.listadoVuelos.setVisible(true);
	}


}


