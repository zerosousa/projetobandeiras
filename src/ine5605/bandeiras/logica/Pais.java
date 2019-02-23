package ine5605.bandeiras.logica;

import javax.swing.ImageIcon;

public class Pais {
	String nome;
	ImageIcon bandeira;
	
	public Pais(String nome, ImageIcon bandeira) {
		this.nome = nome;
		this.bandeira = bandeira;
	}

	public String getNome() {
		return nome;
	}

	public ImageIcon getBandeira() {
		return bandeira;
	}		
	
	@Override
	public boolean equals(Object obj) {
		boolean iguais = false;
		
		if (obj != null && obj instanceof Pais)	
			iguais = nome.equals(((Pais)obj).nome);
		
		return iguais;
	}
}
