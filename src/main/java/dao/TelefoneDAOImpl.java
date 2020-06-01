package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Telefone;
import util.ConexaoMySQL;


public class TelefoneDAOImpl implements TelefoneDAO {

	public void inserir(Telefone telefone) {

		String sql = "insert into telefone (ddd, numero, tipo, cpf_func) values (?, ?, ?, ?)";

		Connection conexao;
		try {
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			prep.setInt(1, telefone.getDdd());
			prep.setInt(2, telefone.getNumero_tel());
			prep.setString(3, telefone.getTipo());
			prep.setString(4, telefone.getCpf_func());
			prep.execute();
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Telefone telefone) {

		String sql = "UPDATE telefone SET ddd = ?, tipo = ?, numero = ?, cpf_func = ? where numero = ?";
		
		Connection conexao;
		try {
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			
			
			prep.setInt(1, telefone.getDdd());
			prep.setString(2, telefone.getTipo());
			prep.setInt(3, telefone.getNumero_tel());
			prep.setString(4, telefone.getCpf_func());
			prep.setInt(5, telefone.getNumero_tel());
			prep.execute();
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Telefone telefone) {

		String sql = "DELETE FROM telefone WHERE numero = ?";

		Connection conexao;
		try {
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			
			prep.setInt(1, telefone.getNumero_tel());

			prep.execute();
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Telefone pesquisar(Telefone telefone) {

		String sql = "select * from telefone where numero = ?";	
		
		Connection conexao;
		try {
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			
			prep.setInt(1, telefone.getNumero_tel());

			ResultSet result = prep.executeQuery();

			while (result.next()) {
				telefone = new Telefone();
				
				telefone.setDdd(result.getInt("DDD"));
				telefone.setNumero_tel(result.getInt("NUMERO"));
				telefone.setTipo(result.getString("TIPO"));
				telefone.setCpf_func(result.getString("CPF_FUNC"));
							
			 }
			
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return telefone;
	}

	
	
	public List<Telefone> listarTodos() {

		String sql = "select * from telefone";
		
		List<Telefone> listaTelefone = new ArrayList<Telefone>();
		
		Connection conexao;
		try {
			
			 
			conexao = ConexaoMySQL.getConexaoMySQL();   
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			ResultSet result = prep.executeQuery();

			while (result.next()) {
				
				Telefone telefone = new Telefone();
				telefone.setDdd(result.getInt("ddd"));
				telefone.setNumero_tel(result.getInt("numero"));
				telefone.setTipo(result.getString("tipo"));
				telefone.setCpf_func(result.getString("cpf_func"));		
				listaTelefone.add(telefone);
			 }
			
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaTelefone;

	}

	

}
