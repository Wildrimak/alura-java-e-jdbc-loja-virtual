package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Produto;

public class ProdutosDAO {

	public void salva(Produto produto) throws SQLException {

		try (Connection connection = new ConnectionPool().getConnection()) {
			String sql = "insert into Produto (nome, descricao) values(?, ?)";

			try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				ps.setString(1, produto.getNome());
				ps.setString(2, produto.getDescricao());
				ps.execute();

				try (ResultSet resultSet = ps.getGeneratedKeys()) {

					while (resultSet.next()) {
						int id = resultSet.getInt("id");
						produto.setId(id);
						System.out.println(id + " gerado");
					}

				}
			}
		}
	}

	public List<Produto> lista() throws SQLException {

		List<Produto> produtos = new ArrayList<>();

		try (Connection connection = new ConnectionPool().getConnection()) {
			String sql = "select * from Produto";

			try (PreparedStatement ps = connection.prepareStatement(sql)) {
				ps.execute();

				try (ResultSet resultSet = ps.getResultSet()) {

					while (resultSet.next()) {

						int id = resultSet.getInt("id");
						String nome = resultSet.getString("nome");
						String descricao = resultSet.getString("descricao");

						Produto produto = new Produto(nome, descricao);
						produto.setId(id);

						produtos.add(produto);
					}
				}
			}
		}

		return produtos;

	}

}
