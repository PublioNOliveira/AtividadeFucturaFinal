package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Endereco;
import util.ConexaoMySQL;


public class EnderecoDAOImpl implements EnderecoDAO {

	public void inserir(Endereco endereco) {

		String sql = "insert into ENDERECO (logradouro, numero, cep, bairro, cidade, estado, pais)"
				+ "values"
				+ "(?, ?, ?, ?, ?, ?, ?";

		Connection conexao;
		try {
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			prep.setString(1, endereco.getLogradouro());
			prep.setInt(2, endereco.getNumero());
			prep.setString(3, endereco.getCep());
			prep.setString(4, endereco.getBairro());
			prep.setString(5, endereco.getCidade());
			prep.setString(6, endereco.getEstado());
			prep.setString(7, endereco.getPais());
			prep.execute();
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Endereco endereco) {

		String sql = "UPDATE ENDERECO SET logradouro = ?, numero = ? , cep = ? , bairro = ?, cidade = ?, estado = ?, pais = ?"
				+ " where cep = ?";
		
		Connection conexao;
		try {
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			
			prep.setString(1, endereco.getLogradouro());
			prep.setInt(2, endereco.getNumero());
			prep.setString(3, endereco.getCep());
			prep.setString(4, endereco.getBairro());
			prep.setString(5, endereco.getCidade());
			prep.setString(6, endereco.getEstado());
			prep.setString(7, endereco.getPais());
			prep.setString(8, endereco.getCep());
			prep.execute();
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Endereco endereco) {

		String sql = "DELETE FROM ENDERECO WHERE cep = ?";

		Connection conexao;
		try {
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			
			prep.setString(1, endereco.getCep());

			prep.execute();
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Endereco pesquisar(String cep) {

		String sql = "select e.logradouro e.numero, e.cep, e.bairro, e.cidade, e.estado, e.pais from ENDERECO e where cep = ?";	
		
		Endereco endereco = null;
		
		Connection conexao;
		try {
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			
			prep.setString(1, cep);

			ResultSet result = prep.executeQuery();

			while (result.next()) {
				endereco = new Endereco();
				
				endereco.setLogradouro(result.getString("LOGRADOURO"));
				endereco.setNumero(result.getInt("NUMERO"));
				endereco.setCep(result.getString("CEP"));
				endereco.setBairro(result.getString("BAIRRO"));
				endereco.setCidade(result.getString("CIDADE"));
				endereco.setEstado(result.getString("ESTADO"));
				endereco.setPais(result.getString("PAIS"));
					
				
			 }
			
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return endereco;
	}

	
	
	public List<Endereco> listarTodos() {

		String sql = "select * from endereco";
		
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		
		Connection conexao;
		try {
			
			//conexao = ConexaoUtil.getConexao();  
			conexao = ConexaoMySQL.getConexaoMySQL();   
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			ResultSet result = prep.executeQuery();

			while (result.next()) {
				
				Endereco endereco = new Endereco();
				endereco.setLogradouro(result.getString("LOGRADOURO"));
				endereco.setNumero(result.getInt("NUMERO"));
				endereco.setCep(result.getString("CEP"));
				endereco.setBairro(result.getString("BAIRRO"));
				endereco.setCidade(result.getString("CIDADE"));
				endereco.setEstado(result.getString("ESTADO"));
				endereco.setPais(result.getString("PAIS"));
				listaEndereco.add(endereco);
			 }
			
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaEndereco;

	}

	

}
