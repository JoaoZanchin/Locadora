package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class JFCadastrarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarFilme frame = new JFCadastrarFilme();
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
	public JFCadastrarFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Filme");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 13, 202, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(12, 63, 92, 16);
		contentPane.add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(12, 92, 229, 45);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sinopse");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(12, 150, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 264, 496, -81);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(12, 264, 104, 16);
		contentPane.add(lblNewLabel_3);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(12, 293, 193, 27);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tempo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(12, 333, 56, 16);
		contentPane.add(lblNewLabel_4);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(12, 362, 46, 51);
		contentPane.add(spinner);
		
		JLabel lblNewLabel_5 = new JLabel("Imagem");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(158, 333, 56, 16);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton rdbtn2d = new JRadioButton("2D");
		rdbtn2d.setBounds(157, 359, 127, 25);
		contentPane.add(rdbtn2d);
		
		JRadioButton rdbtn3d = new JRadioButton("3D");
		rdbtn3d.setBounds(158, 388, 127, 25);
		contentPane.add(rdbtn3d);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2d);
		imagem.add(rdbtn3d);
		
		JLabel lblNewLabel_6 = new JLabel("\u00C1udio");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(321, 333, 56, 16);
		contentPane.add(lblNewLabel_6);
		
		JRadioButton rdbtnDublado = new JRadioButton("Dublado");
		rdbtnDublado.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnDublado.setBounds(255, 362, 127, 25);
		contentPane.add(rdbtnDublado);
		
		JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
		rdbtnLegendado.setBounds(307, 388, 127, 25);
		contentPane.add(rdbtnLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(rdbtnDublado);
		audio.add(rdbtnLegendado);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(12, 465, 97, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(165, 465, 97, 25);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(307, 465, 97, 25);
		contentPane.add(btnCancelar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 179, 547, 82);
		contentPane.add(scrollPane_1);
		
		JTextArea txtSinopse = new JTextArea();
		scrollPane_1.setViewportView(txtSinopse);
	}
}
