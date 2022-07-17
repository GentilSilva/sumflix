package br.com.denver.sumflix.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.denver.sumflix.form.UpdateVideoForm;
import br.com.denver.sumflix.form.VideoForm;
import br.com.denver.sumflix.model.Categoria;
import br.com.denver.sumflix.model.Video;
import br.com.denver.sumflix.model.dto.VideoDto;
import br.com.denver.sumflix.repository.CategoriaRepository;
import br.com.denver.sumflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	VideoRepository videoRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public VideoDto registerVideo(VideoForm form) {
		Video video = convertToVideo(form);
		if(form.getCategoriaId() == null) {
			form.setCategoriaId(1l);
			video = videoRepository.save(video);		
			return convertToDto(video);
		} else {
			Optional<Categoria> categoria = categoriaRepository.findById(form.getCategoriaId());
			if(categoria.isPresent()) {
				video = videoRepository.save(video);
				return convertToDto(video);
			}
		}
		return null;
	}
	
	public List<VideoDto> findAllVideos() {
		List<Video> video = videoRepository.findAll();
		return convertListToDto(video);
	}
	
	public VideoDto findVideosById(Long id) {
		Optional<Video> video = videoRepository.findById(id);
		if(video.isPresent()) {
			return convertToDto(video.get());
		}
		return null;
	}
	
	public List<VideoDto> findVideosByCategoriaId(Long categoriaId) {
		List<Video> videos = videoRepository.findByCategoriaId(categoriaId);
		return convertListToDto(videos);
	}
	
	public VideoDto updateVideo(UpdateVideoForm form, Long id) {
		Optional<Video> video = videoRepository.findById(id);
		if(video.isPresent()) {
			Video videoUpdate = video.get();
			if(form.getTitulo() != null) {
				videoUpdate.setTitulo(form.getTitulo());
			} else {
				videoUpdate.setTitulo(videoUpdate.getTitulo());
			}
			if(form.getDescricao() != null) {
				videoUpdate.setDescricao(form.getDescricao());
			} else {
				videoUpdate.setDescricao(videoUpdate.getDescricao());
			}
			if(form.getUrl() != null) {
				videoUpdate.setUrl(form.getUrl());
			} else {
				videoUpdate.setUrl(videoUpdate.getUrl());
			}
			videoRepository.save(videoUpdate);
			return convertToDto(videoUpdate);
		}
		return null;
	}
	
	public void deleteVideo(Long id) {
		if(videoRepository.existsById(id)) {
			videoRepository.deleteById(id);
		}
	}	
	
	private Video convertToVideo(VideoForm form) {
		Video video = new Video();
		video.setTitulo(form.getTitulo());
		video.setDescricao(form.getDescricao());
		video.setUrl(form.getUrl());
		return video;
	}
	
	private VideoDto convertToDto(Video video) {
		VideoDto dto = new VideoDto();
		dto.setTitulo(video.getTitulo());
		dto.setDescricao(video.getDescricao());
		dto.setUrl(video.getUrl());
		return dto;
	}
	
	private static List<VideoDto> convertListToDto(List<Video> videos) {
		return videos.stream().map(VideoDto::new).collect(Collectors.toList());
	}
	
}
