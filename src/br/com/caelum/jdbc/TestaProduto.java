package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.caelum.jdbc.modelo.Produto;

public class TestaProduto {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("Celular", "Nokia 2760");

		try (Connection connection = new ConnectionPool().getConnection()) {
			ProdutosDAO dao = new ProdutosDAO(connection);
			dao.salva(produto);

			List<Produto> lista = dao.lista();

			for (Produto p : lista) {
				System.out.println(p.getNome() + " " + p.getDescricao());
			}
		}
	}
}
