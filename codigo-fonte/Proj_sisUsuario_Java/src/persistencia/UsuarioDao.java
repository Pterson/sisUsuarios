package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDao {
	

	
	public List<Usuario> buscarSenhaUsuarioDb() {
		
		String comandoSqlBuscar = "SELECT * FROM tabela_usuarios";
		
		List<Usuario> listaUsuariosDoBanco = new ArrayList<>();
		
		FabricaConexao fabricaConexao = new FabricaConexao();
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null;
		
		ResultSet resultadoTabela = null;
		
        try {
			
			conexaoRecebida = fabricaConexao.criarConexao();
			
			declaracaoComando = (PreparedStatement)conexaoRecebida.prepareStatement(comandoSqlBuscar); // Preparação do comanda recebe o banco e o comando SQL
			
			resultadoTabela = declaracaoComando.executeQuery(); // recebe o comando executado pela query
			
			while (resultadoTabela.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setMatricula(resultadoTabela.getString("MATRICULA"));
				usuario.setNome(resultadoTabela.getString("NOME"));
				usuario.setEmail(resultadoTabela.getString("EMAIL"));
				usuario.setTipoUsuario(resultadoTabela.getString("TIPO_USUARIO"));
				usuario.setSenha(resultadoTabela.getString("SENHA"));
				
				listaUsuariosDoBanco.add(usuario);
			
			}
			
        } catch (Exception erroCatchBuscaUsuario) {
			
        	System.out.println(erroCatchBuscaUsuario);
        	System.out.println("**ERRO NA BUSCA**");
        	
		} finally {
			try {
				
				if(conexaoRecebida != null) {// Verifica se a conexão é nula
					conexaoRecebida.close();
				}
				
				if (declaracaoComando != null) {
					declaracaoComando.close();
				}
			} catch (Exception erroCatchXconexao) {
				System.out.println(erroCatchXconexao);
				System.out.println("**ERRO PARA FECHAR CONEXÃO**");
			}
		}
		
		return listaUsuariosDoBanco;
	}

}
