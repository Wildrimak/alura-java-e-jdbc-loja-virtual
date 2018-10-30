package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.modelo.Categoria;

public class TestaCategorias {

	public static void main(String[] args) throws SQLException {
	
		try (Connection connection = new ConnectionPool().getConnection()) {
			List<Categoria> categorias = new CategoriasDAO(connection).lista();
			
			for (Categoria categoria : categorias) {
				System.out.println(categoria.getNome());
			}
		
		}
	}
}
