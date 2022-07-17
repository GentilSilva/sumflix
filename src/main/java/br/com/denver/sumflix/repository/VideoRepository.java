package br.com.denver.sumflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.denver.sumflix.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{

	public List<Video> findByCategoriaId(Long categoriaId);
	
}
