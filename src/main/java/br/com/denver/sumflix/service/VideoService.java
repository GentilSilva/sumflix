package br.com.denver.sumflix.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.denver.sumflix.form.VideoForm;
import br.com.denver.sumflix.model.Video;
import br.com.denver.sumflix.model.dto.VideoDto;
import br.com.denver.sumflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	VideoRepository videoRepository;
	
	public VideoDto createVideo(VideoForm form) {
		Video video = convertToVideo(form);
		video = videoRepository.save(video);		
		return convertToDto(video);
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
	
	public VideoDto updateVideo(VideoForm form, Long id) {
		Optional<Video> video = videoRepository.findById(id);
		if(video.isPresent()) {
			Video videoUpdate = video.get();
			videoUpdate.setTitulo(form.getTitulo());
			videoUpdate.setDescricao(form.getDescricao());
			videoUpdate.setUrl(form.getUrl());
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
