package br.com.denver.sumflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.denver.sumflix.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{

}
