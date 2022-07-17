package br.com.denver.sumflix.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String titulo;
	@NotNull
	private String cor;
	@OneToMany(mappedBy = "categoria")
	private List<Video> videos;
	
	
	
	public Categoria() {}
	
	public Categoria(String titulo, String cor) {
		this.titulo = titulo;
		this.cor = cor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
}
