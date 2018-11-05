package usuario;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import crud.Select;

public class TelaInicial extends JFrame{
	//componentes
	
	private JTextField txt_login;
	private JPasswordField txt_senha;
	private JButton btn_login;
	private JButton btn_cadastrar;
	private JPanel painel;
	private JButton btn_educacao,btn_PequenaEmpresa,btn_GrandeEmpresa,btn_UsoPessoal;
	JFrame tela;
	JLabel Jimagem;
	ImageIcon icon = new ImageIcon("C:\\Lucas c\\TrabalhoFinal\\src\\img\\cadeado.png");
	ImageIcon haticon = new ImageIcon("C:\\Lucas c\\TrabalhoFinal\\src\\img\\hat.png");
	ImageIcon handbagicon = new ImageIcon("C:\\Lucas c\\TrabalhoFinal\\src\\img\\handbag.png");	
	ImageIcon companyicon = new ImageIcon("C:\\Lucas c\\TrabalhoFinal\\src\\img\\company.png");
	ImageIcon peopleicon = new ImageIcon("C:\\Lucas c\\TrabalhoFinal\\src\\img\\people.png");
	//criando frame da tela
	//construtor
	public TelaInicial(){
		tela = new JFrame("tela login");
		tela.getContentPane().setBackground(new Color(52, 69, 92));
		tela.setLayout(null);
		tela.setSize(900, 700);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//adicionado imagem;
		Jimagem = new JLabel(icon);
		Jimagem.setBackground(Color.black);
		tela.add(Jimagem);
		Jimagem.setBounds(500, 100, 150, 150);
		//criando panel para dar uma customizado
		painel = new JPanel();
		painel.setBackground(new Color(103, 218, 199));
		painel.setLayout(null);
		tela.add(painel);		
		painel.setBounds(0,0,250,tela.getHeight());
		
		//colocando botoes de publicacao no jpanel
		
		btn_educacao = new JButton("Educação (professor ou aluno)",haticon);
		btn_educacao.setHorizontalAlignment(SwingConstants.LEFT);
		btn_educacao.setBackground(new Color(103, 218, 199));
		btn_educacao.setForeground(Color.white);
		btn_educacao.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 204, 136)));
		painel.add(btn_educacao);
		btn_educacao.setBounds(0,100,250,40);
		
		btn_PequenaEmpresa = new JButton("Pequena empresa (startup)",handbagicon);
		btn_PequenaEmpresa.setHorizontalAlignment(SwingConstants.LEFT);
		btn_PequenaEmpresa.setBackground(new Color(103, 218, 199));
		btn_PequenaEmpresa.setForeground(Color.white);
		btn_PequenaEmpresa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 204, 136)));
		painel.add(btn_PequenaEmpresa);
		btn_PequenaEmpresa.setBounds(0,141,250,40);
		
		btn_GrandeEmpresa = new JButton("Grande empresa (100 people +)",companyicon);
		btn_GrandeEmpresa.setHorizontalAlignment(SwingConstants.LEFT);
		btn_GrandeEmpresa.setBackground(new Color(103, 218, 199));
		btn_GrandeEmpresa.setForeground(Color.white);
		btn_GrandeEmpresa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 204, 136)));
		painel.add(btn_GrandeEmpresa);
		btn_GrandeEmpresa.setBounds(0,182,250,40);
		
		btn_UsoPessoal = new JButton("Uso pessoal",peopleicon);
		btn_UsoPessoal.setHorizontalAlignment(SwingConstants.LEFT);
		btn_UsoPessoal.setBackground(new Color(103, 218, 199));
		btn_UsoPessoal.setForeground(Color.white);
		btn_UsoPessoal.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 204, 136)));
		painel.add(btn_UsoPessoal);
		btn_UsoPessoal.setBounds(0, 223, 250, 40);
		//colocando dados dentro da tela btn,label, etc...
		txt_login = new JTextField("Email");
		txt_login.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(116,125,140)));
		txt_login.setBackground(new Color(52, 69, 92));
		txt_login.setForeground(Color.white);
		
		tela.add(txt_login);
		txt_login.setBounds(470, 300, 200, 30);
		
		txt_senha = new JPasswordField("Senha");
		txt_senha.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(116,125,140)));
		txt_senha.setBackground(new Color(52,69,92));
		txt_senha.setForeground(Color.white);
		tela.add(txt_senha);
		txt_senha.setBounds(470, 350, 200, 30);
		
		//criando botao para fazer login 
		btn_login = new JButton("Entrar");
		btn_login.setForeground(Color.white);
		btn_login.setBackground(new Color(103, 218, 199));
		btn_login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tela.add(btn_login);
		
		btn_login.setBounds(470,400,90,30);
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				
				//validando email

				boolean validaEmail;
				boolean validaSenha;
				String email;
				String senha;
				
				//ve se o campo do login ta vazio
				if((txt_login.getText().length() >1) &&
						(txt_login.getText().indexOf("@")>=1 && 
						(txt_login.getText().indexOf(".")>=1
								))&& txt_login.getText().length() < 50) {
					System.out.println("Email Valido");
					validaEmail = true;
					email= txt_login.getText();//coloco o texto do Jtextfield dentro da variavel	
				}
				else {
					JOptionPane.showMessageDialog(null, "Informe um Email válido");
					txt_login.requestFocus();
					validaEmail = false;
					
				}
				//ve se o campo da senha esta vazio
				if(txt_senha.getText().equals("") || txt_senha.getText().length() < 6 || txt_senha.getText().length() > 20) {
					JOptionPane.showMessageDialog(null, "Informe uma Senha com mais Segurança");
					txt_senha.requestFocus();
					validaSenha = false;
				}
				else {
					validaSenha = true;
					senha = txt_senha.getText();
				}
				if(validaSenha && validaEmail ){
					
					Login login = new Login(txt_login.getText(), txt_senha.getText());
					
					//procurando dentro do banco de dados o usuario
					Select procura = new Select();
					if(procura.procuraUsuario(login)){
						System.out.println("Encontrei");
						tela.setVisible(false);
						new TelaUsuario().tela.setVisible(true);
						
						
					}else{
						JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
					}
					
				}
			}
		});
		
		//criando botao para fazer cadastro
		btn_cadastrar = new JButton("Cadastro");
		btn_cadastrar.setForeground(Color.white);
		btn_cadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cadastrar.setBackground(new Color(103, 218, 199));
		btn_cadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		tela.add(btn_cadastrar);
		btn_cadastrar.setBounds(579,400,90,30);
	
		
	
		
	}
	
	
	//criando objetos e add
	
		
	public static void main(String[] args){
		new TelaInicial().tela.setVisible(true);;
		 
	
	}

}
