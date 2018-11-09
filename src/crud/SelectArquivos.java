package crud;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import bancoDeDados.ConexaoBanco;
import usuario.Login;

public class SelectArquivos{
	
	private ImageIcon imageIcon;
	private byte[] arquivos;
	private ArrayList<ImageIcon> listaImagens = new ArrayList<ImageIcon>(); 
	public boolean retornaArquivo(Login l){
		Connection connection;
		boolean tipoRetorno = false;
		try {
			connection = (Connection) new ConexaoBanco().openConexao();

			String selectSql = "SELECT * FROM arquivos;";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(selectSql);
			//ps.setString(1, l.getEmail());

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				System.out.println(rs.getString("descricao"));
				System.out.println(rs.getBinaryStream("arquivo"));
				
				//convertendo bytes para arquivo original
				
				InputStream input = rs.getBinaryStream("arquivo");
				if(input != null) {
					ByteArrayOutputStream output = new ByteArrayOutputStream();
					//set read buffer size
					byte[] rb = new byte[1024];
					int ch=0;
					while((ch = input.read(rb)) != -1) {
						output.write(rb,0,ch);
					}//transfer to byte buffer
					byte[] b = output.toByteArray();
					input.close();
					output.close();
					
					System.out.println("Arquivo convertido");
					System.out.println(b);
					setArquivo(b);
					
					
				}
				tipoRetorno = true;
			}
			connection.close();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tipoRetorno;
	}
	//para setar uma imagem
	
	public void setArquivo(byte[] a) {
		this.arquivos = a;
	}
	
	
	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public byte[] getArquivos() {
		return arquivos;
	}

	public ImageIcon getArquivo() {
		if(getArquivos() != null) {
		imageIcon = new ImageIcon();
		imageIcon = new ImageIcon(getArquivos());
		
		}
		return imageIcon;
	}
	public static void main(String[] args) {
		Login l = new Login("lucas@gmail.com","deuCerto");
		new SelectArquivos().retornaArquivo(l);
	}
}
