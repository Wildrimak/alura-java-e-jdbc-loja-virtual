package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	private static ConnectionPool connectionPool = new ConnectionPool();
	
	public static void main(String[] args) throws SQLException {

		Connection connection = connectionPool.getConnection();
		System.out.println("Abrindo e Fechando uma conexão");
		connection.close();
	}
}
