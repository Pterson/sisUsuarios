package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import repository.RepositorioUsuario;
import service.GerenciaSessao;
import view.TelaGerenciaUsuario;



public class ControladorTelaLogin implements ActionListener {
		
	JTextField textMatriculaRecebida;
	JTextField textSenhaRecebida;
	JFrame frameTelaLoginRecebida;
	


	public ControladorTelaLogin(JTextField textMatriculaRecebida, JTextField textSenhaRecebida, JFrame frameTelaLogin) {

		this.textMatriculaRecebida = textMatriculaRecebida;
		this.textSenhaRecebida = textSenhaRecebida;
		this.frameTelaLoginRecebida = frameTelaLogin;
	}
	
	RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
	GerenciaSessao gerenciaSessao = new GerenciaSessao();
	
	TelaGerenciaUsuario telaGerenciaUsuario = new TelaGerenciaUsuario();
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Usuario usuarioEncontrado = gerenciaSessao.validaUsuario(textMatriculaRecebida.getText(), textSenhaRecebida.getText());
		
		if(usuarioEncontrado != null) {
			
			JOptionPane.showInternalMessageDialog(null, "Bem Vindo (a) " + usuarioEncontrado.getNome());
			
		}	

	}

}
