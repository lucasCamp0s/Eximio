package crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import bancoDeDados.ConexaoBanco;
import usuario.Login;

public class Select {
	
	Connection connection;
	
	
	public Select(){
		
	}
	public boolean procuraUsuario(Login l){
		//retorna dados do banco de dados
		boolean tipoRetorno = false;
			
				try {
					connection = (Connection) new ConexaoBanco().openConexao();
					
					String selectSql = "SELECT * FROM pessoa where  email = ? and senha = ? ";
					PreparedStatement ps = (PreparedStatement) connection.prepareStatement(selectSql);
					ps.setString(1, l.getEmail());
					ps.setString(2, l.getSenha());
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()){
						//System.out.println(rs.getString("email"));
						//System.out.println(rs.getString("senha"));
						tipoRetorno = true;
					}
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return tipoRetorno;
	}
	
}
