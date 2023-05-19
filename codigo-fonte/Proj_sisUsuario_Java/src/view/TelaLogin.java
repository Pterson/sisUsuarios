package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TelaLogin {

	public void iniciarTelaLogin() {

		String nome =" USUARIO:";
		String senha =" SENHA:";


//______CRIA O FRAME
		JFrame frameTelaLogin = new JFrame();
		frameTelaLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frameTelaLogin.setSize(280, 200);
		frameTelaLogin.setTitle("TELA DE LOGIN");

//______CRIA O PAINEL
		JPanel panelTelaLogin = new JPanel();
		GridLayout grid = new GridLayout(0,1);
		panelTelaLogin.setLayout(grid);

//______CRIA O LABEL
		JLabel labelNome = new JLabel(nome);
		panelTelaLogin.add(labelNome);

//______CRIA O CAMPO DO TEXTO
		JTextField textUsuario = new JTextField(10);
		panelTelaLogin.add(textUsuario);

		JLabel labelSenha = new JLabel(senha);
		panelTelaLogin.add(labelSenha);

		JTextField textSenha = new JTextField(10);
		panelTelaLogin.add(textSenha);

		JButton buttonLogin = new JButton("LOGIN");
		panelTelaLogin.add(buttonLogin); // Adiciona o botão no panelMenuPrincipal

		frameTelaLogin.add(panelTelaLogin);
		frameTelaLogin.setVisible(true);


	}

}
