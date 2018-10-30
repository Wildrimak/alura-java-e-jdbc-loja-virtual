package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Categoria;

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
}
