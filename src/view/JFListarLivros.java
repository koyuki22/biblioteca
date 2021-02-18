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

import model.bean.Livro;
import model.dao.LivroDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFListarLivros extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable jtLivro;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarLivros frame = new JFListarLivros();
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
	public JFListarLivros() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				readJtable();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setTitle("Listar Livros");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 803, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Livros");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 188, 38);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 723, 332);
		contentPane.add(scrollPane);
		
		jtLivro = new JTable();
        jtLivro.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "ID", "Titulo", "Autor", "Editora", "Edicao", "Ano", "Valor", "Estoque"
            }
        ));
        
        scrollPane.setViewportView(jtLivro);
		
		JButton btnCadastrar = new JButton("Cadastrar Filme");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarLivro cl = new JFCadastrarLivro();
				cl.setVisible(true);
			}
		});
		btnCadastrar.setBounds(20, 434, 125, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Filme");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtLivro.getSelectedRow()!= -1) {
					JFAtualizarLivros al = new JFAtualizarLivros(
				    (int)jtLivro.getValueAt(jtLivro.getSelectedRow(), 0));
					al.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJtable();
			}
		});
		btnAlterar.setBounds(176, 434, 111, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir Filme");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jtLivro.getSelectedRow() != -1) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o filme selecionado?"
							,"Exclusão",JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						LivroDAO dao = new LivroDAO();
						Livro l = new Livro();
						l.setIdLivro((int) jtLivro.getValueAt(jtLivro.getSelectedRow(), 0));
						dao.delete(l);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJtable();
			}
		});
		btnExcluir.setBounds(321, 434, 117, 23);
		contentPane.add(btnExcluir);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(466, 434, 111, 23);
		contentPane.add(btnNewButton);
		
		readJtable();
	}
	
	public void readJtable() {
        DefaultTableModel modelo = (DefaultTableModel) jtLivro.getModel();
        modelo.setNumRows(0);
		LivroDAO ldao = new LivroDAO();
		for(Livro l : ldao.read()) {
			modelo.addRow(new Object[] {
					l.getIdLivro(),
					l.getTitulo(),
					l.getAutor(),
					l.getEditora(),
					l.getEdicao(),
					l.getAno(),
					l.getValor(),
					l.isEstoque()
			});
		}
		
	}
}

	
