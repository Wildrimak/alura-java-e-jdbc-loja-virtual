package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
	
	private static ConnectionPool connectionPool = new ConnectionPool();
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = connectionPool.getConnection();
		
		Statement stmt = connection.createStatement();
		boolean execute = stmt.execute("delete from Produto where id > 38");
		System.out.println(execute);
		int count = stmt.getUpdateCount();
		
		System.out.println(count + " linhas atualizadas");
		
		stmt.close();
		connection.close();
		
	}
}
