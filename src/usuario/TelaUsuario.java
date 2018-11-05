package usuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import manipulandoArquivo.LendoArquivo;


public class TelaUsuario extends JFrame {

	JFrame tela;
	JPanel painel;
	JLabel imagemDousuario;
	JButton btn_adicionarArquivo,btn_sair,btn_arquivos,btn_Adicionar;
	JMenuBar menu;
	JMenu jm_configuracao;
	JMenuItem jmi_conta,jmi_help,jmi_sobre;

	public TelaUsuario() {

		tela = new JFrame("área do usuario");//criando frame da tela

		//adicionando menu principal
		menu = new JMenuBar();
		menu.setLayout(null);
		tela.add(menu);
		menu.setBounds(0,0,1200,40);

		//adicionando sub menus
		jm_configuracao = new JMenu("Configuração");
		menu.add(jm_configuracao);
		jm_configuracao.setBounds(900,0,90,40);


		//sub menu com o campo conta
		jmi_conta = new JMenuItem("Conta");
		jm_configuracao.add(jmi_conta);

		//submenu com o campo
		jmi_help = new JMenuItem("Ajuda");
		jm_configuracao.add(jmi_help);

		//sobre
		jmi_sobre = new JMenuItem("Sobre");
		jm_configuracao.add(jmi_sobre);
		//para adicionar a foto do usuario
		imagemDousuario = new JLabel("img usuario",JLabel.CENTER);
		tela.add(imagemDousuario);
		imagemDousuario.setBounds(0,40,150,100);

		//btnarquivos
		btn_arquivos = new JButton("Arquivos");
		btn_arquivos.setVerticalAlignment(SwingConstants.BOTTOM);
		tela.add(btn_arquivos);
		btn_arquivos.setBounds(0,200,150,100);


		//btn para adicionar arquivos no vos
		btn_Adicionar = new JButton("Add File");
		btn_Adicionar.setVerticalAlignment(SwingConstants.BOTTOM);
		tela.add(btn_Adicionar);
		btn_Adicionar.setBounds(0,300,150,100);
		btn_Adicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//abre o explorador de arquivos*/
				String caminho = null;
				JFileChooser abrir = new JFileChooser();  //cria o from do explorer
				int retorno = abrir.showOpenDialog(null);  //caso algo for selecionado
				if (retorno==JFileChooser.APPROVE_OPTION)  {
					caminho = abrir.getSelectedFile().getAbsolutePath(); //pega a url
					System.out.println(caminho);//printa o caminho
					LendoArquivo la = new LendoArquivo();
					//System.out.println(la.lerArquivo(caminho));

				}

				


			}
		});

		//adicionados os btn do menu
		btn_sair = new JButton("Sair");
		btn_sair.setVerticalAlignment(SwingConstants.BOTTOM);
		tela.add(btn_sair);
		btn_sair.setBounds(0,400,150,100);

		//configurando  jPanel
		painel = new JPanel();
		painel.setSize(150,800);
		painel.setBackground(Color.red);
		tela.add(painel);

		//configurando a tela

		tela.setLayout(null);
		tela.setSize(1200,800);
		tela.setLocationRelativeTo(null);

		tela.setResizable(false);
		tela.setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	


}
