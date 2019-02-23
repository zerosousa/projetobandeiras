package ine5605.bandeiras.igu;

import ine5605.bandeiras.logica.Pais;
import ine5605.bandeiras.logica.Paises;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelPrincipal extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	enum Acoes {
		PESQUISAR,
		CONTINUAR;
	}
	final Color COR_INDEFINIDO = Color.GRAY;
	final Color COR_ACERTOU = Color.GREEN;
	final Color COR_ERROU = Color.RED;
	
	JTextField campoNomePais;
	JLabel campoBandeira;
	JButton botaoAcao;
	JPanel campoResultado;
	JLabel rotResultado;
	JLabel rotPais;
	JLabel rotBandeira;
	InterfaceComUsuario iu;
	Pais pais;
	Paises paises;
	
	public PainelPrincipal(InterfaceComUsuario iu, Paises paises) {
		this.iu = iu;
		this.paises = paises;
		
		definaComponentes();
		posicioneComponentes();
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		continueJogando();
	}

	private void posicioneComponentes() {
		GroupLayout gl = new GroupLayout(this);
		setLayout(gl);
		
		gl.setAutoCreateGaps(true);
		gl.setAutoCreateContainerGaps(true);
		
		// horizontal
		{
			ParallelGroup p1; 
			ParallelGroup p2; 
			SequentialGroup s;
			int ps = GroupLayout.PREFERRED_SIZE;
			
			p1 = gl.createParallelGroup(Alignment.TRAILING);
			p1.addComponent(rotBandeira).addComponent(rotPais).addComponent(rotResultado);
			p2 = gl.createParallelGroup(Alignment.LEADING);
			p2.addComponent(campoBandeira).addComponent(campoNomePais).addComponent(botaoAcao).addComponent(campoResultado, ps, ps, ps);
			s = gl.createSequentialGroup();
			s.addGroup(p1).addGroup(p2);
			gl.setHorizontalGroup(s);
		}
		
		// vertical
		{
			ParallelGroup p1;
			ParallelGroup p2;
			ParallelGroup p3;
			SequentialGroup s;
			
			p1 = gl.createParallelGroup(Alignment.CENTER);
			p1.addComponent(rotBandeira).addComponent(campoBandeira);
			
			p2 = gl.createParallelGroup(Alignment.CENTER);
			p2.addComponent(rotPais).addComponent(campoNomePais);

			p3 = gl.createParallelGroup(Alignment.CENTER);
			p3.addComponent(rotResultado).addComponent(campoResultado);
			
			s = gl.createSequentialGroup();
			s.addGroup(p1).addGroup(p2).addGroup(p3).addComponent(botaoAcao);
			gl.setVerticalGroup(s);
		}
		
		
	}

	private void definaComponentes() {
		rotBandeira = new JLabel("Bandeira :");
		rotPais = new JLabel("Que país possui esta bandeira?");
		rotResultado = new JLabel("Resposta :");
		
		campoResultado = new JPanel();
		campoResultado.setPreferredSize(new Dimension(150, 30));
		campoResultado.setBackground(COR_INDEFINIDO);
		
		botaoAcao = new JButton();
		botaoAcao.addActionListener(this);
		
		campoNomePais = new JTextField(20);
		
		campoBandeira = new JLabel();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Acoes acao = Acoes.valueOf(e.getActionCommand());
		
		switch (acao) {
			case PESQUISAR :
				pesquise();
				break;
			case CONTINUAR :
				continueJogando();
				break;
		}
	}

	private void continueJogando() {
		botaoAcao.setText("Ok");
		botaoAcao.setActionCommand(Acoes.PESQUISAR.name());
		campoNomePais.setText("");
		campoNomePais.setEditable(true);
		campoResultado.setBackground(COR_INDEFINIDO);
		pais = paises.retorneUmPaisAoAcaso();
		campoBandeira.setIcon(pais.getBandeira());
		iu.redimensione();
	}

	private void pesquise() {

		if (campoNomePais.getText().equals(pais.getNome()))
			campoResultado.setBackground(COR_ACERTOU);
		else
			campoResultado.setBackground(COR_ERROU);
		campoNomePais.setEditable(false);
		botaoAcao.setText("Novo País");
		botaoAcao.setActionCommand(Acoes.CONTINUAR.name());
		iu.redimensione();
	}

}
