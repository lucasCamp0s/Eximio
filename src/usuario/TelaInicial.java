package usuario;

import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TelaInicial extends JFrame{
	//componentes
	
	private JTextField txt_login;
	private JPasswordField txt_senha;
	private JButton btn_login;
	private JButton btn_cadastrar;
	private JPanel painel;
	JFrame tela;
	JLabel Jimagem;
	ImageIcon icon = new ImageIcon("C:\\Lucas campos\\Java\\Eximio\\src\\img\\cadeado.png");
	 //criando frame da tela
	//construtor
	public TelaInicial(){
		tela = new JFrame("tela login");
		//adicionado imagem;
		Jimagem = new JLabel(icon);
		Jimagem.setBackground(Color.black);
		tela.add(Jimagem);
		Jimagem.setBounds(500, 100, 150, 150);
		//criando panel para dar uma customizado
		painel = new JPanel();
		painel.setBackground(new Color(103, 218, 199));
		tela.add(painel);		
		painel.setBounds(0,0,250,700);
		
		//colocando dados dentro da tela btn,label, etc...
		txt_login = new JTextField("Login");
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
		tela.add(btn_login);
		
		btn_login.setBounds(470,400,90,30);
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//criando botao para fazer cadastro
		btn_cadastrar = new JButton("Cadastro");
		btn_cadastrar.setForeground(Color.white);
		btn_cadastrar.setBackground(new Color(103, 218, 199));
		btn_cadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tela.setVisible(false);
				new TelaCadastro();
				
			}
		});
		tela.add(btn_cadastrar);
		btn_cadastrar.setBounds(579,400,90,30);
	
		
		tela.getContentPane().setBackground(new Color(52, 69, 92));
		tela.setLayout(null);
		tela.setSize(900, 700);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	//criando objetos e add
	
		
	public static void main(String[] args){
		new TelaInicial().tela.setVisible(true);;
		
	}

}
