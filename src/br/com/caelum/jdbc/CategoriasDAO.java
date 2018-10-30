package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Categoria;
import br.com.caelum.jdbc.modelo.Produto;

public class CategoriasDAO {

	private final Connection connection;

	public CategoriasDAO(Connection con) {
		this.connection = con;
	}

	public List<Categoria> lista() throws SQLException {

		List<Categoria> categorias = new ArrayList<>();

		String sql = "select * from Categoria";

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.execute();

			try (ResultSet resultSet = ps.getResultSet()) {

				while (resultSet.next()) {

					int id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");

					Categoria categoria = new Categoria(id, nome);

					categorias.add(categoria);
				}
			}
		}

		return categorias;

	}

	public List<Categoria> listaComProdutos() throws SQLException {

		List<Categoria> categorias = new ArrayList<>();
		Categoria ultima = null;

		String sql = "select c.id as c_id, c.nome as c_nome, p.id as p_id, p.nome as p_nome, p.descricao as p_descricao from Categoria as c join Produto as p on p.categoria_id = c.id";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {

				while (rs.next()) {

					int id = rs.getInt("c_id");
					String nome = rs.getString("c_nome");

					if (ultima == null || !ultima.getNome().equals(nome)) {
						Categoria categoria = new Categoria(id, nome);
						categorias.add(categoria);
						ultima = categoria;
					}

					int id_p = rs.getInt("p_id");
					String nome_p = rs.getString("p_nome");
					String descricao_p = rs.getString("p_descricao");

					Produto produto = new Produto(nome_p, descricao_p);
					produto.setId(id_p);

					ultima.adiciona(produto);

				}
			}
		}

		return categorias;
	}
}
