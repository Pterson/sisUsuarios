package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Usuario;

public class TelaGerenciaUsuario {
	
	public void telaGerenciarUsuario(Usuario usuarioLogado, JFrame frameTelaLogin) {
		
		String opcao1 = "1. Para Cadastrar";
		String opcao2 = "2. Para Gerenciar";
		
		
//______CRIA FRAME		
		JFrame frameGerenciaUsuario = new JFrame();
		frameGerenciaUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGerenciaUsuario.setSize(400, 250);		
		

//______CRIA PANEL
		JPanel panelGerenciaUsuario = new JPanel();
		GridLayout grid = new GridLayout(0,1);
		panelGerenciaUsuario.setLayout(grid);		
		
		
//______CRIA LABEL
		JLabel labelOpcao1 = new JLabel(opcao1);
		panelGerenciaUsuario.add(labelOpcao1);
		
		JLabel labelOpcao2 = new JLabel(opcao2);
		panelGerenciaUsuario.add(labelOpcao2);
						

//______CRIA TEXT
		JTextField textResposta = new JTextField();
		panelGerenciaUsuario.add(textResposta);
		
		
//______CRIA BUTTON
		JButton botaoEnviar = new JButton("ENVIAR");
		panelGerenciaUsuario.add(botaoEnviar);
		
		JButton botaoSair = new JButton("SAIR");
		panelGerenciaUsuario.add(botaoSair );
		
		
//______ADD FRAME AO PANEL		
		frameGerenciaUsuario.add(panelGerenciaUsuario);
		frameGerenciaUsuario.setVisible(true);
		
		
//______ENVIA PARAMETROS AO CONTROLADOR
		
		
	}

}
