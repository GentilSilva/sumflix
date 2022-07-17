package br.com.denver.sumflix.model.dto;

import br.com.denver.sumflix.model.Video;

public class VideoDto {

	private String titulo;
	private String categoriaTitulo;
	private String descricao;
	private String url;
	
	public VideoDto() {}
	
	public VideoDto(Video video) {
		this.titulo = video.getTitulo();
		this.categoriaTitulo = video.getCategoria().getTitulo();
		this.descricao = video.getDescricao();
		this.url = video.getUrl();
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoriaTitulo() {
		return categoriaTitulo;
	}

	public void setCategoriaTitulo(String categoriaTitulo) {
		this.categoriaTitulo = categoriaTitulo;
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
