package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.modelo.Categoria;
import br.com.caelum.jdbc.modelo.Produto;

public class TestaCategorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionPool().getConnection()) {
			List<Categoria> categorias = new CategoriasDAO(connection).listaComProdutos();

			for (Categoria categoria : categorias) {
				System.out.println(categoria.getNome());
				for (Produto produto : categoria.getProdutos()) {
					System.out.println("\t" + categoria.getNome() + " - " + produto.getNome());
				}
			}

		}
	}
}
