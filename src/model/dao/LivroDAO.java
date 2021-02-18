package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.bean.Livro;

public class LivroDAO {
	private static final Connection con = null;

	public void create(Livro l) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		     
		try {
			
			stmt = con.prepareStatement("INSERT INTO livro(titulo, autor, editora, edicao, ano, valor, estoque) VALUES" + "(?,?,?,?,?,?,?)");
			
			stmt.setString(1, l.getTitulo());
			stmt.setString(2, l.getAutor());
			stmt.setString(3, l.getEditora());
			stmt.setString(4, l.getEdicao());
			stmt.setInt(5, l.getAno());
			stmt.setString(6, l.getValor());
			stmt.setBoolean(7, l.isEstoque());
		
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Livro salvo com sucesso!");
			
		} catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
			
			
		}finally{
			
			ConnectionFactory.closeConnection(con,stmt);	
			
		}		
	}

	public static Connection getCon() {
		return con;
	}
	
	public List<Livro> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Livro> livros = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM livro;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Livro l = new Livro();
				l.setIdLivro(rs.getInt("idLivro"));
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				l.setEditora(rs.getString("editora"));
				l.setEdicao(rs.getString("edicao"));
				l.setAno(rs.getInt("ano"));
				l.setValor(rs.getString("valor"));
				l.setEstoque(rs.getBoolean("estoque"));
				livros.add(l);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return livros;
	}
	
	public Livro read(int id) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Livro l = new Livro();

		try {
			stmt = con.prepareStatement("SELECT * FROM livro where idLivro = ?;");
			stmt.setInt(1,id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				l.setIdLivro(rs.getInt("idLivro"));
				l.setTitulo(rs.getString("titulo"));
				l.setAutor(rs.getString("autor"));
				l.setEditora(rs.getString("editora"));
				l.setEdicao(rs.getString("edicao"));
				l.setAno(rs.getInt("ano"));
				l.setValor(rs.getString("valor"));
				l.setEstoque(rs.getBoolean("estoque"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		
		return l;
	}
	
	
	public void update(Livro l) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE livro SET titulo=?, autor=?, editora=?, edicao=?, ano=?, valor=?, estoque=? WHERE idlivro=?");
			
			stmt.setString(2, l.getTitulo());
			stmt.setInt(1, l.getIdLivro());
			stmt.setString(3, l.getAutor());
			stmt.setString(4, l.getEditora());
			stmt.setString(5, l.getEdicao());
			stmt.setBoolean(8, l.isEstoque());
			stmt.setString(7, l.getValor());
			stmt.setInt(6, l.getAno());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Mudanças salvas com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar:" + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}

	public void delete(Livro l) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM livro WHERE idLivro=?");
			stmt.setInt(1, l.getIdLivro());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Filme excluído com sucesso!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
}


