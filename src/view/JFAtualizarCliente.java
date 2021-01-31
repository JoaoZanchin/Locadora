package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;

public class JFAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(id);
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
	public JFAtualizarCliente(int id) {
		setTitle("Alterar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 27, 174, 16);
		contentPane.add(lblNewLabel);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		
		JLabel lblNewLabel_5 = new JLabel("ID do cliente");
		lblNewLabel_5.setBounds(153, 56, 81, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(246, 56, 56, 16);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(12, 56, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(12, 89, 249, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Endere\u00E7o");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(12, 124, 81, 16);
		contentPane.add(lblNewLabel_2);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(12, 144, 268, 34);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Idade");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(12, 204, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		JSpinner spIdade = new JSpinner();
		spIdade.setBounds(12, 233, 43, 43);
		contentPane.add(spIdade);
		
		JLabel lblNewLabel_4 = new JLabel("Sexo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(163, 204, 56, 16);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(153, 233, 127, 25);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(153, 263, 127, 25);
		contentPane.add(rdbtnFeminino);
		
		ButtonGroup sexo = new ButtonGroup();
		sexo.add(rdbtnMasculino);
		sexo.add(rdbtnFeminino);
		
		lblId.setText(String.valueOf(c.getIdCliente()));
		txtNome.setText(c.getNome());
		txtEndereco.setText(c.getEndereco());
		spIdade.setValue(c.getIdade());
		if(c.isSexo() == true) {
			rdbtnFeminino.setSelected(true);
		}else if(c.isSexo() == false) {
			rdbtnMasculino.setSelected(true);
		}
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setIdCliente(Integer.parseInt(lblId.getText()));
				c.setNome(txtNome.getText());
				c.setEndereco(txtEndereco.getText());
				c.setIdade(Integer.parseInt(spIdade.getValue().toString()));
				if(rdbtnMasculino.isSelected()) {
					c.setSexo(false);
				}else if (rdbtnFeminino.isSelected()) {
					c.setSexo(true);
				}
				
				dao.update(c);
				dispose();
			}
		});
	
		btnAlterar.setBounds(12, 326, 97, 25);
		contentPane.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNome.setText ( null );
				txtEndereco.setText ( null );
				spIdade.setValue ( 0 );
				sexo.clearSelection();
				
			}
		});
		btnLimpar.setBounds(163, 326, 97, 25);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener ( new  ActionListener () {
			public  void  actionPerformed ( ActionEvent  e ) {
				dispose();
			}
		});
		btnCancelar.setBounds(320, 326, 97, 25);
		contentPane.add(btnCancelar);
		
		
		
	}
}
