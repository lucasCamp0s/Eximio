package manipulandoArquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.zip.InflaterInputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import crud.Inserir;

public class LendoArquivo {

	/*public InputStreamReader lerArquivo(String diretorio) {
		InputStreamReader input;
		try {
			FileInputStream arquivo = new FileInputStream(diretorio);
			 input = new InputStreamReader(arquivo);

		//	new Inserir().cadastrarArquivo(input);

		}	catch(Exception e) {
			System.out.println("Falha ao ler o arquivo");

		}
		return input;
	}*/
	
	
	public File selecionarArquivo() {
		JFileChooser fileChooser = new JFileChooser();
		//FileNameExtensionFilter filtro = new FileNameExtensionFilter("Todos os arquivos");
		//fileChooser.addChoosableFileFilter(filtro);
		fileChooser.setAcceptAllFileFilterUsed(true);
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		fileChooser.showOpenDialog(fileChooser);
		
		return fileChooser.getSelectedFile();
	}
	public static void main(String[] args) {
		new LendoArquivo().selecionarArquivo();
	}
}