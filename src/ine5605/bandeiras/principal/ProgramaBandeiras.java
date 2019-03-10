package ine5605.bandeiras.principal;

import ine5605.bandeiras.igu.InterfaceComUsuario;
import ine5605.bandeiras.logica.Paises;

public class ProgramaBandeiras {

	public static void main(String[] args) {
		String[] bandeiras = new String[] { 
				"Alemanha", "bandeiras/Alemanha.png", 
				"Canadá",   "bandeiras/Canada.png", 
				"China", 	"bandeiras/China.png",
				"Cuba", 	"bandeiras/Cuba.png",
				"Gr�cia", 	"bandeiras/Grecia.png",
				"Irlanda", 	"bandeiras/Irlanda.png",
				"Jamaica", 	"bandeiras/Jamaica.png",
				"Letônia", 	"bandeiras/Letonia.png",
				"Nepal", 	"bandeiras/Nepal.png",
				"Noruega", 	"bandeiras/Noruega.png",
				"Nova Zelândia", 	"bandeiras/NovaZelandia.png",
				"Paquistão", 	"bandeiras/Paquistao.png",
				"Polônia", 	"bandeiras/Polonia.png",
				"Portugal", 	"bandeiras/Portugal.png",
				"Rússia", 	"bandeiras/Russia.png",
				"Senegal", 	"bandeiras/Senegal.png",
				"Suécia", 	"bandeiras/Suecia.png",
				"Turquia", 	"bandeiras/Turquia.png",
				"Uruguai", 	"bandeiras/Uruguai.png",
				"Zâmbia", 	"bandeiras/Zambia.png",
				};
		Paises paises = new Paises(bandeiras);
		new InterfaceComUsuario(paises);
	}

}
