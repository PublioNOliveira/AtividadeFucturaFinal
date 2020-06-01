package util;

//Classes necessárias para uso de Banco de dados //

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	public static String status = "Não conectou...";

	public ConexaoMySQL() {

	}

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null; 

		try {


			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			String url = "jdbc:mysql://localhost:3306/teste2";

			String username = "root"; 
			
			String password = "12345"; 
			
			connection = DriverManager.getConnection(url, username, password);

			return connection;

		} catch (ClassNotFoundException e) { // Driver não encontrado

			System.out.println("O driver expecificado nao foi encontrado.");

			return null;

		} catch (SQLException e) {

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;

		}

	}

	public static String statusConection() {

		return status;

	}

	

	public static boolean FecharConexao() {

		try {

			ConexaoMySQL.getConexaoMySQL().close();

			return true;

		} catch (SQLException e) {

			return false;

		}

	}

	
	public static java.sql.Connection ReiniciarConexao() {

		FecharConexao();

		return ConexaoMySQL.getConexaoMySQL();

	}

}
