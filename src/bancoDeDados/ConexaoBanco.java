package bancoDeDados;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConexaoBanco {

	//criando conexao
	private  Connection connection = null;  
	
	
	//metodo para abrir conexão com o banco
	public Connection openConexao() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String nomeServidor = /*"127.0.0.1:3307";*/"esn509vmysql"; // caminhao do bd
			String mydatabase = "eximio"; // nome do seu bancp de dados
			String url = "jdbc:mysql://" + nomeServidor + "/" + mydatabase;
			String username = /*"root";*/"aluno"; //nome usuario do bd
			String password = "Senai1234"; //senha
			
			connection = (Connection) DriverManager.getConnection(url, username, password);
		
		if(connection != null) {
			System.out.println("Conectado com sucesso");
		}
		else {
			System.out.println("não foi possivel connectar");
		}
		
		return connection;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("o driver nao foi encontrado");
			return null;
		}catch(SQLException e) {
			System.out.println("Não foi possivel conectara ao banco de Dados");
			return null;
		}
		
	}
	public void close() {
		try {
			connection.close();
			System.out.println("Desconectou");
		}catch(SQLException erro) {
			
		}
	}
	
	//metodo para fecar conexao
	
	//teste da classe
	
	public static void main(String[] args) {
		new ConexaoBanco().openConexao();
	}
	
	
	
}