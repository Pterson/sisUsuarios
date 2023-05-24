package repository;

import java.util.List;

import model.Usuario;

public class RepositorioUsuario implements InterfaceUsuario {
	
	DaoUsuario daoUsuario = new DaoUsuario();

	@Override
	public boolean salvarUsuario(Usuario usuario) {
		
		return daoUsuario.persistirUsuario(usuario);
	}

	@Override
	public List<Usuario> retornaUsuarios() {
		
		return daoUsuario.retornarListaUsuarioDao();
	}

	@Override
	public Usuario buscarUsuario(String matricula) {
		
		for (Usuario usuarioBusca: retornaUsuarios()) {
			if(matricula.equals(usuarioBusca.getMatricula())) {
				return usuarioBusca;
			}
		}
		
		return null;
	}	

}
