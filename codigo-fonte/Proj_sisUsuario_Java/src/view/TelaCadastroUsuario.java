package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.ControladorCadastroUsuario;
import model.Usuario;

public class TelaCadastroUsuario {
	
	public void cadastrarUsuario(Usuario usuarioLogado, JFrame frameMenuUsuario) {
	
//	String matricula = "Informe a matrícula: ";
	String nome = "Informe o nome: ";
	String email = "Informe o email: ";
	String tipoUsuario = "Informe o tipo de acesso: ";
	
	
//***********************************************************************************	
	JFrame frameCadastrarUsuario = new JFrame();
	
	frameCadastrarUsuario.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frameCadastrarUsuario.setSize(330, 300);
	frameCadastrarUsuario.setTitle("TELA DE CADASTRO DE USUARIOS");
	
	
	JPanel panelCadastrarUsuario = new JPanel();
	GridLayout grid = new GridLayout(0,1);
	panelCadastrarUsuario.setLayout(grid);	
//***********************************************************************************
	
	
/*//__MATRICULA	
	JLabel labelMatricula = new JLabel(matricula);
	panelCadastrarUsuario.add(labelMatricula);
	
	JTextField textMatricula = new JTextField();
	panelCadastrarUsuario.add(textMatricula);
*/	
	
//__NOME
	JLabel labelNome = new JLabel(nome);
	panelCadastrarUsuario.add(labelNome);
	
	JTextField textNome = new JTextField();
	panelCadastrarUsuario.add(textNome);
	
//__EMAIL
	JLabel labelEmail = new JLabel(email);
	panelCadastrarUsuario.add(labelEmail);
		
	JTextField textEmail = new JTextField();
	panelCadastrarUsuario.add(textEmail);
	
//__TIPO
	JLabel labelTipoUsuario = new JLabel(tipoUsuario);
	panelCadastrarUsuario.add(labelTipoUsuario);
	
	JTextField textTipoUsuario = new JTextField();
	panelCadastrarUsuario.add(textTipoUsuario);
	

//__BOTÃO
	JButton botaoEnviar = new JButton("ENVIAR");
	panelCadastrarUsuario.add(botaoEnviar);
	
	JButton botaoSair = new JButton("VOLTAR");
	panelCadastrarUsuario.add(botaoSair );
	
//__ADD FRAME AO PANEL	
	frameCadastrarUsuario.add(panelCadastrarUsuario);
	frameCadastrarUsuario.setVisible(true);
		
	
//__CRIAÇÃO DO OBJETO Criação de uma instância de ControladorCadastrarUsuario E ATRIBUINDO AS VARIÁVEIS
	ControladorCadastroUsuario controladorCadastroUsuario = new ControladorCadastroUsuario(textNome, textEmail, textTipoUsuario, frameMenuUsuario, frameCadastrarUsuario);
	
//__ADICIONANDO CONTROLADOR COMO OUVINTE OS BOTÕES botaoEnviar e botaoSair
	botaoEnviar.addActionListener(controladorCadastroUsuario);
	botaoSair.addActionListener(controladorCadastroUsuario);	
	
	}
	

}
