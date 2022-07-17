package br.com.denver.sumflix.form;

public class UpdateVideoForm {

	private String titulo;
	private Long categoriaId;
	private String descricao;
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

	public void setCategoriaTitulo(Long categoriaId) {
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
