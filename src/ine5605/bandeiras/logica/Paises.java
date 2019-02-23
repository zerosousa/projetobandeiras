package ine5605.bandeiras.logica;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;

public class Paises {
	Map<String, Pais> dados;
	String[] chaves; 			// nomes dos países
	Random r;

	public Paises(String[] bandeiras) {
		Pais pais;
		ClassLoader cl = this.getClass().getClassLoader();
		r = new Random();
		dados = new HashMap<String, Pais>();
		chaves = new String[bandeiras.length/2];
		for (int i = 0; i < bandeiras.length; i = i + 2) {
			pais = new Pais(bandeiras[i], new ImageIcon(cl.getResource(bandeiras[i+1])));
			chaves[i/2] = bandeiras[i];
			dados.put(bandeiras[i], pais);
		}
	}
		
	public Pais retorneUmPaisAoAcaso() {
		String chave = chaves[r.nextInt(chaves.length)];
		
		return dados.get(chave);		
	}
	
}
