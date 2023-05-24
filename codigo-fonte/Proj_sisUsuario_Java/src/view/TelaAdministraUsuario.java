package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Usuario;
import repository.RepositorioUsuario;

public class TelaAdministraUsuario {
	
	public void telaAdmUsuario (Usuario usuarioLogado, JFrame frameGerenciaUsuario) {
		
		RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
		
		List<Usuario> listaUsuarios = repositorioUsuario.retornaUsuarios();
		
		int quantidadeLista = listaUsuarios.size();
		
		String [][] tabelaString = new String [quantidadeLista][4];
		
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		
		for (Usuario usuarioTabela : listaUsuarios) {
			
			String nomeColunas [] = {"MATRICULA", "NOME", "EMAIL", "TIPO"};
			
			JTable tabelaUsuario = new JTable(tabelaString, nomeColunas);
			tabelaUsuario.setBounds(30,40,300,300);
			
			JScrollPane scrollPaneTabelaUsuario = new JScrollPane(tabelaUsuario);
			
			JFrame frameAdmUsuario = new JFrame();
			
			frameAdmUsuario.setSize(500,600);
			
			JPanel panelAdmUsuario = new JPanel();
			panelAdmUsuario.add(scrollPaneTabelaUsuario);
			
			frameAdmUsuario.add(panelAdmUsuario);
			frameAdmUsuario.setVisible(true);
		}
	}

}
