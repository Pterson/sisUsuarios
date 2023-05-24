package service;

import model.Usuario;
import repository.RepositorioUsuario;

public class GerenciaSessao {
	
	RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
	
	public Usuario validaUsuario(String matricula, String senha) {
		
		Usuario usuarioEncontrado = repositorioUsuario.buscarUsuario(matricula);
		
		if(usuarioEncontrado != null) {
			
			if(usuarioEncontrado.getSenha().equals(senha)) {
				
				return usuarioEncontrado;
			}
		}
		
		return null;		
	}

}
