package br.com.caelum.jdbc.modelo;

public class Produto {
	private Integer id;
	private String nome;
	private String descricao;

	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
