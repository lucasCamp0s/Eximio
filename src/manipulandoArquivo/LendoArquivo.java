package manipulandoArquivo;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.zip.InflaterInputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import crud.Inserir;

public class LendoArquivo {




	public byte[] selecionarArquivo() {
		JFileChooser fileChooser = new JFileChooser();
		FileInputStream file ;
		
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileFilter(new FileNameExtensionFilter("png", "png"));
		fileChooser.setFileFilter(new FileNameExtensionFilter("jpeg", "jpg"));

		javax.swing.filechooser.FileFilter filter = new javax.swing.filechooser.FileFilter(){
			
			public boolean accept(File f){
				return fileChooser.isDirectorySelectionEnabled() || fileChooser.getName().toLowerCase().endsWith(".txt");
				
			}
			public String getDescrion(){
				return "(*.txt)";
			}
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		fileChooser.addChoosableFileFilter(filter);
		
		int returnVal = fileChooser.showDialog(null, "open");
		
		if(returnVal == JFileChooser.APPROVE_OPTION){
			String caminho;
			System.out.println(caminho=fileChooser.getSelectedFile().getAbsolutePath());
			try {
				//file = new FileInputStream(caminho);
				File arq = new File(caminho);
				int len = (int) arq.length();
				byte[] sendBuf = new byte[len];
				FileInputStream infile = null;
				
				//tenta exeutar
				infile = new FileInputStream(arq);
				infile.read(sendBuf,0,len);
				
				System.out.println(sendBuf);
				return sendBuf;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(returnVal == JFileChooser.CANCEL_OPTION){
			return null;
		}
		else if(returnVal == JFileChooser.UNDEFINED_CONDITION){
			return null;
		}
		return null;
	}
	public static void main(String[] args) {
		new LendoArquivo().selecionarArquivo();
	}
}