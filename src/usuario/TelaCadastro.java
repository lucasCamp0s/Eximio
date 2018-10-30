package usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.RuntimeErrorException;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import crud.Inserir;

public class TelaCadastro extends JFrame implements ActionListener {
	//adicionando componentes que será usado no cadastro

	JButton btn_cadastro;//criar proprios botoes 
	JLabel lbl_nome,lbl_email,lbl_senha,lbl_ConfirmarSenha,txt_logo;
	JTextField txt_nome,txt_email;
	JPasswordField txt_senha,txt_confirmaSenha;
	JCheckBox ckb_Termos;



	public TelaCadastro() {


		//logo

		txt_logo = new JLabel("Cadastro",JLabel.CENTER);
		txt_logo.setBounds(80, 80, 400, 70);
		txt_logo.setFont(new Font("Vladimir Script",Font.ITALIC,80));
		txt_logo.setForeground(new Color(103, 218, 199));
		add(txt_logo);
		//nome

		lbl_nome = new JLabel("NOME COMPLETO");
		lbl_nome.setForeground(Color.white);
		lbl_nome.setBounds(80,200,400,20);
		add(lbl_nome);

		txt_nome = new JTextField("");
		txt_nome.setForeground(new Color(116, 125, 140));
		txt_nome.setBorder(BorderFactory.createMatteBorder(0, 0, 1,0, new Color(116, 125, 140)));
		txt_nome.setBackground(new Color(52, 69, 92));
		txt_nome.setBounds(80, 220, 420, 20);
		add(txt_nome);
		//email

		lbl_email = new JLabel("E-MAIL");
		lbl_email.setForeground(Color.white);
		lbl_email.setBounds(80,280,400,20);
		add(lbl_email);

		txt_email = new JTextField("");
		txt_email.setForeground(new Color(116, 125, 140));
		txt_email.setBackground(new Color(52, 69, 92));
		txt_email.setBorder(BorderFactory.createMatteBorder(0, 0, 1,0, new Color(116, 125, 140)));
		txt_email.setBounds(80, 300, 420, 20);
		add(txt_email);

		//senha
		lbl_senha = new JLabel("SENHA");
		lbl_senha.setForeground(Color.white);
		lbl_senha.setBounds(80,360,400,20);
		add(lbl_senha);

		txt_senha = new JPasswordField("");
		txt_senha.setBounds(80, 380, 420, 20);
		txt_senha.setForeground(Color.BLACK);
		txt_senha.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(116,125,140)));
		txt_senha.setBackground(new Color(52, 69, 92));
		add(txt_senha);

		//termos
		ckb_Termos = new JCheckBox("Eu concordo com os Termos, Política de Dados e Política de Cookies.");
		ckb_Termos.setBounds(80,440,420,50);
		ckb_Termos.setBackground(new Color(52, 69, 92));
		ckb_Termos.setForeground(new Color(223, 230, 233));
		add(ckb_Termos);

		//botao Cadastro
		btn_cadastro = new JButton("CADASTRAR");
		btn_cadastro.setBounds(80,520,150,30);
		btn_cadastro.setBackground(new Color(103, 218, 199));
		btn_cadastro.setForeground(Color.WHITE);
		btn_cadastro.addActionListener(this);
		add(btn_cadastro);

		/////////////////////////////////////
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(52, 69, 92));
		setSize(600, 700);
		setVisible(true);
		setLocationRelativeTo(null);//centraliza tela no meio
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent a) {
	boolean validaNome = false,validaEmail = false,validaSenha = false,validaTermo = false;//valida para colocar no banco de dados
	String nome = "",email = "";
	String senha = null;
	
		try {
			
				if(txt_nome.getText().equals("") && (txt_nome.getText().length() < 5) && (txt_nome.getText().length() < 40)) {
					JOptionPane.showMessageDialog(null, "Informe um Nome válido");
					txt_nome.requestFocus();
					validaNome = false;
				}
				else {
					validaNome = true;
					nome = txt_nome.getText();//coloco o texto do Jtextfield dentro da variavel
				}
				//validando email

				if((txt_email.getText().length() >1) &&
						(txt_email.getText().indexOf("@")>=1 && 
						(txt_email.getText().indexOf(".")>=1
								))&& txt_email.getText().length() < 50) {
					System.out.println("Email Valido");
					validaEmail = true;
					email = txt_email.getText();//coloco o texto do Jtextfield dentro da variavel	
				}
				else {
					JOptionPane.showMessageDialog(null, "Informe um Email válido");
					txt_email.requestFocus();
					validaEmail = false;
					
				}
				if(txt_senha.getText().equals("") && txt_senha.getText().length() < 6 && txt_senha.getText().length() > 60) {
					JOptionPane.showMessageDialog(null, "Informe com mais Segurança");
					txt_senha.requestFocus();
					validaSenha = false;
				}
				else {
					validaSenha = true;
					senha = txt_senha.getText();
				}
				if(ckb_Termos.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Aceite os Termos");
					validaTermo = false;
				}
				else {
					validaTermo = true;
				}
				//caso tudo esteja certinho o cadastro será efetuado
				
			if(validaNome && validaEmail && validaSenha && validaTermo) {
				//colocar ligacao com banco de dados
				
				Inserir is = new Inserir();//cria objeto da classe inserir
				Pessoa novoUsuario = new Pessoa(nome,email,senha);
				is.cadastrarPessoa(novoUsuario);			
				
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
				setVisible(false);
				new TelaInicial().tela.setVisible(true);;//chamo a tela inicial
				
			}
		}catch(Exception e) {
			new  RuntimeException("Dados Inválidos");
	//comentario
		}


	}

	public static void main(String[] args) {
		new TelaCadastro();
	}




}