package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable jtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
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
	public JFListarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 28, 142, 19);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 60, 701, 292);
		contentPane.add(scrollPane);
		
		jtCliente = new JTable();
		jtCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"idCliente", "Nome", "Idade", "Sexo"
			}
		));
		scrollPane.setViewportView(jtCliente);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setBounds(12, 380, 142, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Cliente");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtCliente.getSelectedRow() != 1) {
					JFAtualizarCliente ac = new JFAtualizarCliente((int)jtCliente.getValueAt(jtCliente.getSelectedRow(), 0));
					ac.setVisible(true);	
				}else {
					JOptionPane.showInternalMessageDialog(null, "Selecione um cliente!");
				}
				
				readJTable();
			}
		});
		btnAlterar.setBounds(200, 380, 142, 25);
		contentPane.add(btnAlterar);
		
		JButton btnExcluit = new JButton("Excluir Cliente");
		btnExcluit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(jtCliente.getSelectedRow() != -1) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente selecionado?", "Exclusão", JOptionPane.YES_NO_OPTION);
					
					if(opcao == 0 ) {
						ClienteDAO dao = new ClienteDAO();
						Cliente c = new Cliente();
						c.setIdCliente((int) jtCliente.getValueAt(jtCliente.getSelectedRow(), 0));
						dao.delete(c);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente");
				}
				
				readJTable();
				
				
			}
		});
		btnExcluit.setBounds(390, 380, 130, 25);
		contentPane.add(btnExcluit);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtCliente.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		for(Cliente c : cdao.read()) {
			modelo.addRow(new Object[] {
					c.getIdCliente(),
					c.getNome(),
					c.getIdade(),
					c.isSexo()
			});
		}
	}

}
