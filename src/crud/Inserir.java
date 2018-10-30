package crud;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import bancoDeDados.ConexaoBanco;
import usuario.Pessoa;

public class Inserir {

	public boolean cadastrarPessoa(Pessoa p) {


		//criacao do comando a ser executado pelo banco de dados
		String insertSql  = "INSERT INTO PESSOA VALUES(?,?,?);";


		//abertura da conexã usando a classe ja montada
		Connection conexao = new ConexaoBanco().openConexao();

		try {
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertSql);
			//passando os valores para ser salvos no banco de dados
			ps.setString(1,  p.getNome());
			ps.setString(2, p.getEmail());
			ps.setString(3, p.getSenha());

			//Execução do comando de banco de dados e teste do que retorna
			if(ps.executeUpdate() !=0) {
				//ou seja se alterou uma linha, entao o insert deu certo
				conexao.close();
				return true;
			}
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}
}
