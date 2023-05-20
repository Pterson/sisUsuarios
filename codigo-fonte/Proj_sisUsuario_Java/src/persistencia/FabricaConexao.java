package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	private static String USUARIO = "root"; // variaveis de configuração sempre em maiuscula e estaticas por boa pratica - usuario
	private static String SENHA = "root"; // senha
	
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/db_usuarios?useTimezone=true&serverTimezone=UTC"; //URL do banco ou seja o endereço
	
	public Connection criarConexao() {
		
		Connection conexao;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); //Indica o driver que será usado pelo Banco
			
			conexao = DriverManager.getConnection(BANCO_URL, USUARIO, SENHA); // Cria conexão 
			
			System.out.println("**CONECTADO AO BANCO**");
		

		}catch (Exception e) {
			conexao = null;

			System.out.println("**NÃO CONECTADO AO BANCO**");
			
			System.out.println(e);
		}
		
		return conexao;
		
		
	}
	

}
