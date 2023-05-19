package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TelaCadastroUsuario {
	
	public void telaCadastroUsuario() {
	
	String matricula = "Informe a matrícula: ";
	String nome = "Informe o nome: ";
	String tipoUsuario = "Informe o acesso: ";
	
	
	JFrame frameCadastroUsuario = new JFrame();
	
	frameCadastroUsuario.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frameCadastroUsuario.setSize(330, 300);
	frameCadastroUsuario.setTitle("TELA DE GERENCIA DE USUARIOS");
	
	
	JPanel panelCadastroUsuario = new JPanel();

//__MATRICULA	
	JLabel labelMatricula = new JLabel(matricula);
	panelCadastroUsuario.add(labelMatricula);
	
	JTextField textMatricula = new JTextField();
	panelCadastroUsuario.add(textMatricula);
	
	
//__NOME
	JLabel labelNome = new JLabel(nome);
	panelCadastroUsuario.add(labelNome);
	
	JTextField textNome = new JTextField();
	panelCadastroUsuario.add(textNome);
	
//__TIPO
	JLabel labelTipoUsuario = new JLabel(tipoUsuario);
	panelCadastroUsuario.add(labelTipoUsuario);
	
	JTextField textTipoUsuario = new JTextField();
	panelCadastroUsuario.add(textTipoUsuario);
	

//__BOTÃO
	
	
	
	
	
	
	
	
	}
	

}
