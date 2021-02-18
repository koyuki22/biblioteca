package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Livro;
import model.dao.LivroDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textEdic;
	private JTextField textEdit;
	private JTextField textVal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarLivro frame = new JFCadastrarLivro();
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
	public JFCadastrarLivro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Livro");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 66, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 46, 40, 14);
		contentPane.add(lblNewLabel_1);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(10, 61, 141, 20);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Autor");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 103, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textAutor = new JTextField();
		textAutor.setBounds(10, 117, 141, 20);
		contentPane.add(textAutor);
		textAutor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Editora");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(199, 47, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Edi\u00E7\u00E3o");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(199, 103, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textEdic = new JTextField();
		textEdic.setBounds(199, 117, 86, 20);
		contentPane.add(textEdic);
		textEdic.setColumns(10);
		
		textEdit = new JTextField();
		textEdit.setText("");
		textEdit.setBounds(199, 61, 141, 20);
		contentPane.add(textEdit);
		textEdit.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Ano");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 148, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Em estoque?");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(128, 148, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Valor");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(294, 148, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnSim.setBounds(110, 172, 46, 23);
		contentPane.add(rdbtnSim);
		
		JRadioButton rdbtnNao = new JRadioButton("N\u00E3o");
		rdbtnNao.setFont(new Font("Tahoma", Font.BOLD, 10));
		rdbtnNao.setBounds(171, 172, 46, 23);
		contentPane.add(rdbtnNao);
		
		ButtonGroup estoque = new ButtonGroup();
		estoque.add(rdbtnSim);
		estoque.add(rdbtnNao);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(10, 173, 66, 20);
		contentPane.add(spinner);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Livro l = new Livro();
				LivroDAO dao = new LivroDAO();
				l.setTitulo(textTitulo.getText());
				l.setAutor(textAutor.getText());
				l.setEdicao(textEdic.getText());
				l.setEditora(textEdit.getText());
				l.setValor(textVal.getText());
				l.setAno(Integer.parseInt(spinner.getValue().toString()));
				if (rdbtnNao.isSelected()) {
					l.setEstoque(false);
					
				}else{
					
					l.setEstoque(true);
					
				}
				
				dao.create(l);
			}
			
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(10, 215, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(156, 215, 89, 23);
		contentPane.add(btnNewButton_1);

		textVal = new JTextField();
		textVal.setBounds(281, 173, 86, 20);
		contentPane.add(textVal);
		textVal.setColumns(10);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textTitulo.setText(null);
                textAutor.setText(null);
                textEdit.setText(null);
                textEdic.setText(null);
                textVal.setText(null);
                spinner.setValue(0);
                estoque.clearSelection();       
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpar.setBounds(290, 215, 89, 23);
		contentPane.add(btnLimpar);
	}
}
