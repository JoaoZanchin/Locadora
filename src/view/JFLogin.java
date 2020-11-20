package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class JFLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario2;
	private JPasswordField passSenha2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFLogin frame = new JFLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Seja bem vindo(a), realize o Login.");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 15));
		lblTitulo.setBounds(12, 13, 355, 34);
		contentPane.add(lblTitulo);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 13));
		lblUsuario.setBounds(22, 60, 136, 26);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 13));
		lblSenha.setBounds(22, 133, 80, 26);
		contentPane.add(lblSenha);
		
		txtUsuario2 = new JTextField();
		txtUsuario2.setBounds(12, 88, 116, 22);
		contentPane.add(txtUsuario2);
		txtUsuario2.setColumns(10);
		
		passSenha2 = new JPasswordField();
		passSenha2.setBounds(12, 164, 116, 22);
		contentPane.add(passSenha2);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogar.setBounds(12, 215, 97, 25);
		contentPane.add(btnLogar);
		
		JButton btnLimpar = new JButton("Limpar dados");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpar.setBounds(135, 215, 147, 25);
		contentPane.add(btnLimpar);
	}
}
