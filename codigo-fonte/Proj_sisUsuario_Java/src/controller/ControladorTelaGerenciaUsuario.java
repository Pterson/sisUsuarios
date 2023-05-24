package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import view.TelaCadastroUsuario;

public class ControladorTelaGerenciaUsuario implements ActionListener {
	
	Usuario usuarioRecebido;
	JFrame frameTelaLoginRecebido;
	JTextField textRespostaRecebido;
	JFrame frameTelaGerenciaUsuarioRecebido;
	

	public ControladorTelaGerenciaUsuario(Usuario usuarioRecebido, JFrame frameTelaLoginRecebido,
			JTextField textRespostaRecebido, JFrame frameTelaGerenciaUsuarioRecebido) {
		
		this.usuarioRecebido = usuarioRecebido;
		this.frameTelaLoginRecebido = frameTelaLoginRecebido;
		this.textRespostaRecebido = textRespostaRecebido;
		this.frameTelaGerenciaUsuarioRecebido = frameTelaGerenciaUsuarioRecebido;
	}
	
	TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario();
	
//	TelaAdministraUsuario telaAdministraUsuario = new TelaAdministraUsuario();

	@Override
	public void actionPerformed(ActionEvent botaoAcionado) {
		
		if(botaoAcionado.getActionCommand().equals("ENVIAR")) {
			
			if(textRespostaRecebido.getText().equals("1") || textRespostaRecebido.getText().equals("2")) {
				
				if(textRespostaRecebido.getText().equals("1")) {
					System.out.println("Botão Enviar Apertado");
//					cadastroUsuario.cadastrarUsuario(usuarioRecebido, frameTelaGerenciaUsuarioRecebido);
					frameTelaGerenciaUsuarioRecebido.setVisible(false);					
				}
				
				if(textRespostaRecebido.getText().equals("2")) {
					System.out.println("Gerenciar Usuário");
//					telaAdministraUsuario.telaAdmUsuario(usuarioRecebido, frameTelaGerenciaUsuarioRecebido);
				}				
				
			}else {
				JOptionPane.showMessageDialog(null, "Opcao Invalida");
			}
		
	}
	
	if(botaoAcionado.getActionCommand().equals("SAIR")) {
		System.out.println("Botão sair Apertado");
		frameTelaLoginRecebido.setVisible(true);
		frameTelaGerenciaUsuarioRecebido.setVisible(false);
	}	

	}
}
