package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Usuario;

public class UsuarioDao {
	

	public Boolean persistirUsuario (Usuario usuario) {
		
		FabricaConexao fabricaConexao = new FabricaConexao();
		
		String sqlComandoInsert = "INSERT INTO tb_usuario (matricula, nome, email, tipo_usuario, senha) VALUES (?, ?, ?, ?, ?)";
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null;
		
		
		try {
			conexaoRecebida = fabricaConexaoBancoDeDados.criarConexaoDb_usuarios();
			
			declaracaoComando = (PreparedStatement) conexaoRecebida.preparedStatement(sqlComandoInsert);
			
			declaracaoComando.setString(1, usuario.getMatricula());
			declaracaoComando.setString(2, usuario.getNome());
			declaracaoComando.setString(3, usuario.getEmail());
			declaracaoComando.setString(4, usuario.getTipoUsuario());
			declaracaoComando.setString(5, usuario.getSenha());
			
			declaracaoComando.execute();
			
			System.out.println("Usuário Registrado!!!");
			
			
		} catch (Exception e) {

			System.out.println(e);
			System.out.println("ERRO AO REGISTRAR!");
			JOptionPane.showInternalMessageDialog(null, "VERIFIQUE O BANCO DE DADOS!");
			
		} finally {
			
			try {
				if(conexaoRecebida != null) {
					conexaoRecebida.close();
				}
				
				if(declaracaoComando != null) {
					declaracaoComando.close();
				}
			} catch (Exception e) {
				
				System.out.println("ERRO AO FECHAR A CONEXÃO!");
			}
		}
		
		return true;		
	}
	
	public List<Usuario> retornaListaUsuarioDao() {
		
		FabricaConexaoConexaoBancoDeDados fabricaConexaoConexaoBancoDeDados = new FabricaConexaoConexaoBancoDeDados();
		
		String comandoSqlBuscar = "SELECT * FROM tb_usuario";
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null;
		
		ResultSet resultadoTabela = null;
		
		List<Usuario> listaUsuario = new ArrayList<>();
		
		try {
			conexaoRecebida = fabricaConexaoConexaoBancoDeDados.criarConexaoDb_usuarios();
			declaracaoComando = (PreparedStatement)conexaoRecebida.prepareStatement(comandoSqlBuscar);
			
			resultadoTabela = declaracaoComando.executeQuery();
			
			while (resultadoTabela.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setMatricula(resultadoTabela.getString("MATRICULA"));
				usuario.setNome(resultadoTabela.getString("NOME"));
				usuario.setEmail(resultadoTabela.getString("EMAIL"));
				usuario.setTipoUsuario(resultadoTabela.getString("TIPO_USUARIO"));
				usuario.setSenha(resultadoTabela.getString("SENHA"));
				listaUsuario.add(usuario);
			}
			
		} catch (Exception e) {
			
			System.out.println(e);	
			
		}
		
		return listaUsuario;
		
	}
}