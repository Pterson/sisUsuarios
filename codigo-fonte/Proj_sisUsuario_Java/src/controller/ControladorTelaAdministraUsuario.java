package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import repository.RepositorioUsuario;
import view.TelaAlteraUsuario;

public class ControladorTelaAdministraUsuario implements ActionListener {
	
	JTextField textMatriculaRecebida;
	JFrame frameMenuUsuario;
	JFrame frametelaAdmUsuario;
	
		
	public ControladorTelaAdministraUsuario(JTextField textMatriculaRecebida, JFrame frameMenuUsuario,
			JFrame frametelaAdmUsuario) {
		
		this.textMatriculaRecebida = textMatriculaRecebida;
		this.frameMenuUsuario = frameMenuUsuario;
		this.frametelaAdmUsuario = frametelaAdmUsuario;
	}

	
	RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
	TelaAlteraUsuario telaAlteraUsuario = new TelaAlteraUsuario();



	@Override
	public void actionPerformed(ActionEvent botaoAcionado) {

		String botao = botaoAcionado.getActionCommand();
		
		switch (botao) {
		
		case "Deletar":
			System.out.println("Deletar a "+ textMatriculaRecebida.getText());
			
			if(deletarUsuario(validaExistenciaUsuario())) {
				frameMenuUsuario.setVisible(true);
				frametelaAdmUsuario.setVisible(false);
			}
			
			break;
			
		case "Alterar":
			System.out.println("Alterar a "+ textMatriculaRecebida.getText());
			
			if(validaExistenciaUsuario() != null) {
			frametelaAdmUsuario.setVisible(false);
			telaAlteraUsuario.telaAlterarUsuario(validaExistenciaUsuario(), frameMenuUsuario);
			}
			
			break;
		case "Voltar":
			frameMenuUsuario.setVisible(true);
			frametelaAdmUsuario.setVisible(false);
		}
			
	}
		
		
		public boolean deletarUsuario(Usuario usuario) {
			boolean resposta = false;
			
			if(usuario != null) {
				resposta = repositorioUsuario.deletarUsuario(usuario);
				
				if(resposta) {
					JOptionPane.showMessageDialog(null, "UUARIO DELETADO COM SUCESSO");
				}else {
					JOptionPane.showMessageDialog(null, "ERRO AO DELETAR VERIFIQUE COM O ADM");
				}
			}
			return resposta;
		}
		
		public Usuario validaExistenciaUsuario() {
			Usuario usuarioRecebido = repositorioUsuario.buscarUsuario(textMatriculaRecebida.getText());
			
			if(usuarioRecebido == null) {
			   JOptionPane.showMessageDialog(null, "MATRICULA NÃO ENCONTRADA");
			   return null;
			}
			
			return usuarioRecebido;
		}

}
