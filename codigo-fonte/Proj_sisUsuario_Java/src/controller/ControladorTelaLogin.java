package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ControladorTelaLogin implements ActionListener {
		
	JTextField textUsuarioRecebida;
	JTextField textSenhaRecebida;
	JTextField textTipoRecebida;
	


	public ControladorTelaLogin(JTextField textUsuarioRecebida, JTextField textSenhaRecebida,
			JTextField textTipoRecebida) {

		this.textUsuarioRecebida = textUsuarioRecebida;
		this.textSenhaRecebida = textSenhaRecebida;
		this.textTipoRecebida = textTipoRecebida;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("TESTEOU");

	}
	


}
