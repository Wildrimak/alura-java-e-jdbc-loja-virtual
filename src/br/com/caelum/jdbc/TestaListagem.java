package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	
	private static ConnectionPool connectionPool = new ConnectionPool();

	public static void main(String[] args) throws SQLException {

		try (Connection connection = connectionPool.getConnection()) {

			try (Statement statement = connection.createStatement()) {
				boolean resultado = statement.execute("Select * from Produto");

				try (ResultSet resultSet = statement.getResultSet()) {

					System.out.println(resultado);

					while (resultSet.next()) {

						int id = resultSet.getInt("id");
						String nome = resultSet.getString("nome");
						String descricao = resultSet.getString("descricao");

						System.out.println(id + ": " + nome + ": " + descricao);
					}

				}
			}
		}
	}

}
