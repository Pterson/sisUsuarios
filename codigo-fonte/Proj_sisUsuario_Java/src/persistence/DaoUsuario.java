package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connectionFactory.FabricaConexaoBancoDeDados;
import model.Usuario;

public class DaoUsuario {
	

	
	public Boolean persistirUsuario (Usuario usuario) {
		
		FabricaConexaoBancoDeDados fabricaConexaoBancoDeDados = new FabricaConexaoBancoDeDados();
		
		String sqlComandoInsert = "INSERT INTO tb_usuarios (matricula, nome, email, tipo_usuario, senha) VALUES (?, ?, ?, ?, ?)";
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null;
		
		
		try {
			conexaoRecebida = fabricaConexaoBancoDeDados.criarConexaoDb_usuarios();
			
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(sqlComandoInsert);
			
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
		
		FabricaConexaoBancoDeDados fabricaConexaoBancoDeDados = new FabricaConexaoBancoDeDados();
		
		String comandoSqlBuscar = "SELECT * FROM tb_usuario";
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null;
		
		ResultSet resultadoTabela = null;
		
		List<Usuario> listaUsuario = new ArrayList<>();
		
		try {
			conexaoRecebida = fabricaConexaoBancoDeDados.criarConexaoDb_usuarios();
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
	
	
	public boolean deletarUsuario (Usuario usuario) {
		
		FabricaConexaoBancoDeDados fabricaConexaoBancoDeDados = new FabricaConexaoBancoDeDados();
		
		String comandoSqlDeletar = "DELETE FROM tb_usuario WHERE matricula = ?";
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null;
		boolean resposta = false;
		
		try {
			conexaoRecebida = fabricaConexaoBancoDeDados.criarConexaoDb_usuarios();
			
			declaracaoComando = (PreparedStatement)conexaoRecebida.prepareStatement(comandoSqlDeletar);
			declaracaoComando.setString(1, usuario.getMatricula());
			
			declaracaoComando.execute();
			resposta = true;
		
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("ERRO AO DELETAR");
			JOptionPane.showInternalMessageDialog(null, "VERIFIQUE O BANCO DE DADOS!");
			resposta = false;
			
		} finally {
			try {

				if (conexaoRecebida != null) {
					conexaoRecebida.close();
				}
				
				if(declaracaoComando != null) {
					declaracaoComando.close();
				}
			} catch (Exception e) {
				System.out.println("ERRO AO FECHAR CONEXÃO!");
			}
		}		
		
		return resposta;		
		
	}
	
	
	public boolean alterarUsuario (Usuario usuario) {
		
		FabricaConexaoBancoDeDados fabricaConexaoBancoDeDados = new FabricaConexaoBancoDeDados();
		
		String sqlComando = "UPDATE tb_usuario SET matricula = ?, nome = ?, email = ? , tipo_usuario = ?, senha = ? WHERE matricula = ?";
		
		Connection conexaoRecebida = null;
		PreparedStatement declaracaoComando = null;
		boolean reposta = false;
		
		try {
			conexaoRecebida = fabricaConexaoBancoDeDados.criarConexaoDb_usuarios();
			
			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(sqlComando);
			
			declaracaoComando.setString(1, usuario.getMatricula());
			declaracaoComando.setString(2, usuario.getNome());
			declaracaoComando.setString(3, usuario.getEmail());
			declaracaoComando.setString(4, usuario.getTipoUsuario());
			declaracaoComando.setString(5, usuario.getSenha());
			declaracaoComando.setString(6, usuario.getMatricula());
			
			declaracaoComando.execute();
			
			System.out.println("USUARIO REGISTRADO!!");
			 reposta = true;
		}catch (Exception erro) {
			System.err.println(erro);
			System.out.println("Erro ao registrar");
			JOptionPane.showInternalMessageDialog(null, "VERIFIQUE O BANCO DE DADOS!");
			
		}finally {
			try {
				if(conexaoRecebida != null) {
					conexaoRecebida.close();
				}
				
				if(declaracaoComando != null) {
					declaracaoComando.close();
				}
				
			} catch (Exception e) {
				System.out.println("ERRO AO FECHAR CONEXÃO!");
			}
		}
		
		
		return false;
		
	}
}
