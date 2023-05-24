package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.ControladorTelaLogin;

public class TelaLogin {

	public void iniciarTelaLogin() {

		String matricula =" MATRICULA:";
		String senha =" SENHA:";
//		String tipo = "TIPO DE USUÁRIO: \n1. ADMIN \n2. COMUM";


//______CRIA O FRAME
		JFrame frameTelaLogin = new JFrame();
		frameTelaLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameTelaLogin.setSize(280, 200);
		frameTelaLogin.setTitle("TELA DE LOGIN");

//______CRIA O PAINEL
		JPanel panelTelaLogin = new JPanel();
		GridLayout grid = new GridLayout(0,1);
		panelTelaLogin.setLayout(grid);

//______CRIA O LABEL(NOME)
		JLabel labelMatricula = new JLabel(matricula);
		panelTelaLogin.add(labelMatricula);
//______CRIA O CAMPO DO TEXTO(USUARIO)
		JTextField textMatricula = new JTextField(10);
		panelTelaLogin.add(textMatricula);

		
//______JLABEL(SENHA)	
		JLabel labelSenha = new JLabel(senha);
		panelTelaLogin.add(labelSenha);
//______JTEXT(SENHA)
		JTextField textSenha = new JTextField(10);
		panelTelaLogin.add(textSenha);
		
/*		
//______JLABEL(TIPO DE USUARIO)	
		JLabel labelTipo = new JLabel(tipo);
		panelTelaLogin.add(labelTipo);
//______JTEXT(TIPO DE USUARIO)	
		JTextField textTipo = new JTextField(10);
		panelTelaLogin.add(textTipo);			
*/		

		JButton buttonLogin = new JButton("LOGIN");
		panelTelaLogin.add(buttonLogin); // Adiciona o botão no panelMenuPrincipal
		

		frameTelaLogin.add(panelTelaLogin);
		frameTelaLogin.setVisible(true);
		
		ControladorTelaLogin controladorTelaLogin = new ControladorTelaLogin(textMatricula, textSenha, frameTelaLogin);
		controladorTelaLogin.actionPerformed(null); 


	}

}
