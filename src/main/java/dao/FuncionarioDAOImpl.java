package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Endereco;
import entidades.Funcionario;
import entidades.Telefone;
import util.ConexaoMySQL;


public class FuncionarioDAOImpl implements FuncionarioDAO {

	public void inserir(Funcionario funcionario) {

		String sql = "insert into FUNCIONARIO (nome, email, senha, cpf, matricula, logradouro, numero, cep, bairro, cidade, estado, pais)"
				+ "values"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				

		Connection conexao;
		try {
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			prep.setString(1, funcionario.getNome());
			prep.setString(2, funcionario.getEmail());
			prep.setString(3, funcionario.getSenha());
			prep.setString(4, funcionario.getCpf());
			prep.setString(5, funcionario.getMatricula());
			prep.setString(6, funcionario.getEndereco().getLogradouro());
			prep.setInt(7, funcionario.getEndereco().getNumero());
			prep.setString(8, funcionario.getEndereco().getCep());
			prep.setString(9, funcionario.getEndereco().getBairro());
			prep.setString(10, funcionario.getEndereco().getCidade());
			prep.setString(11, funcionario.getEndereco().getEstado());
			prep.setString(12, funcionario.getEndereco().getPais());
					
			prep.execute();
			
			String sql2 =  "insert into telefone (ddd, numero, tipo, cpf_func) values (?, ?, ?, ?)";	
					
				PreparedStatement prepared = conexao.prepareStatement(sql2);
				prepared.setInt(1, funcionario.getTelefone().getDdd());
				prepared.setInt(2, funcionario.getTelefone().getNumero_tel());
				prepared.setString(3, funcionario.getTelefone().getTipo());
				prepared.setString(4, funcionario.getCpf());
				prepared.execute();
			
			
			prep.close();
			prepared.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void alterar(Funcionario funcionario) {

		String sql = "UPDATE FUNCIONARIO SET nome = ?, email = ?, senha = ?, matricula = ?, "
				+ "logradouro = ?, numero = ? , cep = ? , bairro = ?, cidade = ?, estado = ?, pais = ?"
				+ " where cpf = ?";
		
		Connection conexao;
		try {
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			
			prep.setString(1, funcionario.getNome());
			prep.setString(2, funcionario.getEmail());
			prep.setString(3, funcionario.getSenha());
			prep.setString(4, funcionario.getMatricula());
			prep.setString(5, funcionario.getEndereco().getLogradouro());
			prep.setInt(6, funcionario.getEndereco().getNumero());
			prep.setString(7, funcionario.getEndereco().getCep());
			prep.setString(8, funcionario.getEndereco().getBairro());
			prep.setString(9, funcionario.getEndereco().getCidade());
			prep.setString(10, funcionario.getEndereco().getEstado());
			prep.setString(11, funcionario.getEndereco().getPais());
			prep.setString(12, funcionario.getCpf());
			prep.execute();
			
			String sql2 = "UPDATE telefone SET ddd = ?, tipo = ?, numero = ?, cpf_func = ? where numero = ?";
			PreparedStatement prepared = conexao.prepareStatement(sql2);
			prepared.setInt(1, funcionario.getTelefone().getDdd());
			prepared.setInt(2, funcionario.getTelefone().getNumero_tel());
			prepared.setString(3, funcionario.getTelefone().getTipo());
			prepared.setString(4, funcionario.getCpf());
			prepared.setInt(5, funcionario.getTelefone().getNumero_tel());
			prepared.execute();
			
			
			prep.close();
			prepared.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Funcionario funcionario) {

		String sql = "DELETE FROM FUNCIONARIO WHERE cpf = ?";

		Connection conexao;
		try {
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			
			prep.setString(1, funcionario.getCpf());

			prep.execute();
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Funcionario pesquisar(Funcionario funcionario) {

		String sql = "select * from FUNCIONARIO where cpf = ?";	
				
		Connection conexao;
		try {
			ArrayList<Telefone> listaTelefone = new ArrayList<Telefone>();
			conexao = ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			
			prep.setString(1, funcionario.getCpf());

			ResultSet result = prep.executeQuery();

			while (result.next()) {
				funcionario = new Funcionario();
				Endereco endereco = new Endereco();
				
				funcionario.setNome(result.getString("NOME"));
				funcionario.setEmail(result.getString("EMAIL"));
				funcionario.setSenha(result.getString("SENHA"));
				funcionario.setCpf(result.getString("CPF"));
				funcionario.setMatricula(result.getString("MATRICULA"));
			
				endereco.setLogradouro(result.getString("LOGRADOURO"));
				endereco.setNumero(result.getInt("NUMERO"));
				endereco.setCep(result.getString("CEP"));
				endereco.setBairro(result.getString("BAIRRO"));
				endereco.setCidade(result.getString("CIDADE"));
				endereco.setEstado(result.getString("ESTADO"));
				endereco.setPais(result.getString("PAIS"));
				funcionario.setEndereco(endereco);	
			 }
			
			
			
			String sql2 = "select * from telefone where cpf_func = ?";	
			PreparedStatement prepared = conexao.prepareStatement(sql2);
			prepared.setString(1, funcionario.getCpf());
			
			ResultSet result2 = prepared.executeQuery();

			while (result2.next()) {
				Telefone telefone = new Telefone();
				telefone.setDdd(result2.getInt("ddd"));
				telefone.setNumero_tel(result2.getInt("numero"));
				telefone.setTipo(result2.getString("tipo"));
				listaTelefone.add(telefone);
			}
			
			funcionario.setListaTelefone(listaTelefone);
			
			prep.close();
			prepared.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return funcionario;
	}

	
	
	public List<Funcionario> listarTodos() {

		String sql = "select * from funcionario";
						
		
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		
		
		Connection conexao;
		try {
			
			 
			conexao = ConexaoMySQL.getConexaoMySQL();   
			
			PreparedStatement prep = conexao.prepareStatement(sql);
			ResultSet result = prep.executeQuery();

			while (result.next()) {
				
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(result.getString("NOME"));
				funcionario.setEmail(result.getString("EMAIL"));
				funcionario.setSenha(result.getString("SENHA"));
				funcionario.setCpf(result.getString("CPF"));
				funcionario.setMatricula(result.getString("MATRICULA"));
				
				Endereco endereco = new Endereco();
				endereco.setLogradouro(result.getString("LOGRADOURO"));
				endereco.setNumero(result.getInt("NUMERO"));
				endereco.setCep(result.getString("CEP"));
				endereco.setBairro(result.getString("BAIRRO"));
				endereco.setCidade(result.getString("CIDADE"));
				endereco.setEstado(result.getString("ESTADO"));
				endereco.setPais(result.getString("PAIS"));
				funcionario.setEndereco(endereco);
							
				listaFuncionario.add(funcionario);
			 }
			
			prep.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaFuncionario;


	}
	
	
			
}
