package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();
		
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("insert into Produto (nome, descricao) "
				+ "values ('notebook', 'notebook i5')", Statement.RETURN_GENERATED_KEYS);
		System.out.println(resultado);
		statement.close();
		connection.close();
		
	}
}
