package br.com.denver.sumflix.model.dto;

import br.com.denver.sumflix.model.Categoria;

public class CategoriaDto {

	private String titulo;
	private String cor;
	
	public CategoriaDto() {}
	
	public CategoriaDto(Categoria categoria) {
		this.titulo = categoria.getTitulo();
		this.cor = categoria.getCor();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
