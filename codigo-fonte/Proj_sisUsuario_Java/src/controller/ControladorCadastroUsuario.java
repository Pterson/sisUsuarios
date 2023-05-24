package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import repository.RepositorioUsuario;
import service.ServicoCadastroUsuario;

public class ControladorCadastroUsuario implements ActionListener {
	
	
	
//___VARIÁVEIS RECEBIDAS DA TELA DE CADASTRO USUARIO ATRAVÉS DO CONSTRUTOR	
	
	JTextField textNomeRecebido;
	JTextField textEmailRecebido;
	JTextField textTipoUsuarioRecebido;
	
	JFrame frameMenuUsuarioRecebido;
	JFrame frameCadastrarUsuarioRecebido;
	
	public ControladorCadastroUsuario(JTextField textNomeRecebido, JTextField textEmailRecebido,
			JTextField textTipoUsuarioRecebido, JFrame frameMenuUsuarioRecebido, JFrame frameCadastrarUsuarioRecebido) {
		
		this.textNomeRecebido = textNomeRecebido;
		this.textEmailRecebido = textEmailRecebido;
		this.textTipoUsuarioRecebido = textTipoUsuarioRecebido;
		this.frameMenuUsuarioRecebido = frameMenuUsuarioRecebido;
		this.frameCadastrarUsuarioRecebido = frameCadastrarUsuarioRecebido;
	}

	

//___DECLARANDO E CRIANDO INSTÂNCIAS
	
	ServicoCadastroUsuario servicoCadastroUsuario = new ServicoCadastroUsuario();
	
	RepositorioUsuario repositorioUsuario = new RepositorioUsuario();


//___IMPLEMENTANDO O METODO ActionPerformed  DA INTERFACE ActionListener -- É CHAMADO NA AÇÃO DO BOTÃO
	@Override
	public void actionPerformed(ActionEvent botaoAcionado) {
		
		if(botaoAcionado.getActionCommand().equals("VOLTAR")) {
			frameMenuUsuarioRecebido.setVisible(true);
			frameCadastrarUsuarioRecebido.setVisible(false);
		}
		if(botaoAcionado.getActionCommand().equals("ENVIAR")) {
			System.out.println("Cadastrar!");
			
			boolean salvar = repositorioUsuario.salvarUsuario(popularUsuario());
			if(salvar) {
				frameMenuUsuarioRecebido.setVisible(true);
				frameMenuUsuarioRecebido.setVisible(true);
				JOptionPane.showMessageDialog(null, "USUÁRIO REGISTRADO!!!");
			}else {
				JOptionPane.showMessageDialog(null, "**ERRO** USUÁRIO NÃO REGISTRADO!!!");
			}
				
			}
		}
	
	
	public Usuario popularUsuario() {
		Usuario usuarioCadastrado = new Usuario();
		String matricula = servicoCadastroUsuario.gerarMatricula();
		
		if(textTipoUsuarioRecebido.getText().equals("1") || textTipoUsuarioRecebido.getText().equals("2") ) {
			
			if(textTipoUsuarioRecebido.getText().equals("1")) {
				usuarioCadastrado.setTipoUsuario("ADM");
			}
			
			if(textTipoUsuarioRecebido.getText().equals("2")) {
				usuarioCadastrado.setTipoUsuario("COMUM");
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "TIPO DE USUÁRIO INVÁLIDO!!!");
		}
		
		usuarioCadastrado.setNome(textNomeRecebido.getText());
		usuarioCadastrado.setEmail(textEmailRecebido.getText());
		usuarioCadastrado.setMatricula("matricula");
		usuarioCadastrado.setSenha("Senha");
		
		return usuarioCadastrado ;
	}
		
}
