package ine5605.bandeiras.igu;

import ine5605.bandeiras.logica.Paises;

import javax.swing.JFrame;

public class InterfaceComUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InterfaceComUsuario(Paises paises) {
		setTitle("INE5605 - Jogo das Bandeiras");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().add(new PainelPrincipal(this, paises));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	protected void redimensione() {
		validate();
		pack();
	}
}
