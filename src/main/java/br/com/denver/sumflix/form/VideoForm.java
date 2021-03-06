package br.com.denver.sumflix.form;

import javax.validation.constraints.NotBlank;

public class VideoForm {

	@NotBlank(message = "Conteúdo não pode estar em branco")
	private String titulo;
	private Long categoriaId;
	@NotBlank(message = "Conteúdo não pode estar em branco")
	private String descricao;
	@NotBlank(message = "Conteúdo não pode estar em branco")
	private String url;
	
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
}
