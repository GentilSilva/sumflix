package br.com.denver.sumflix.form;

import javax.validation.constraints.NotNull;

public class CategoriaForm {

	@NotNull(message = "Conteúdo não pode estar em branco")
	private String titulo;
	@NotNull(message = "Conteúdo não pode estar em branco")
	private String cor;
	
	
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
