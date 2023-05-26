package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

	public class FabricaConexaoBancoDeDados {	
		
//		private static String USUARIO = "root"; // variaveis de configuração sempre em maiuscula e estaticas por boa pratica - usuario
//		private static String SENHA = "root"; // senha
		
		private static String USUARIO = "uzs11jxcsg3ojqdr";
		private static String SENHA = "8VYoUALExdUUvN9gbwck";
		
//		private static String BANCO_URL = "jdbc:mysql://localhost:3306/db_usuarios?useTimezone=true&serverTimezone=UTC"; //URL do banco ou seja o endereço
		private static String BANCO_URL = "jdbc:mysql://b9z95uxaicqeqn3anzj9-mysql.services.clever-cloud.com:3306/b9z95uxaicqeqn3anzj9?useTimezone=true&serverTimezone=UTC";

		
		public Connection criarConexaoDb_usuarios() {
			
			Connection conexao;
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver"); //Indica o driver que será usado pelo Banco
				
				conexao = DriverManager.getConnection(BANCO_URL, USUARIO, SENHA); // Cria conexão 
				
				System.out.println("**CONECTADO AO BANCO**");
			

			}catch (Exception e) {
				conexao = null;

				System.out.println("**ERRO, BANCO NÃO CONECTADO**");
				
				System.out.println(e);
			}
			
			return conexao;			
			
		}
}
