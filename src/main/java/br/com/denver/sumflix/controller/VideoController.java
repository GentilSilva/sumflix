package br.com.denver.sumflix.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.denver.sumflix.form.VideoForm;
import br.com.denver.sumflix.model.dto.VideoDto;
import br.com.denver.sumflix.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {

	@Autowired
	VideoService videoService;
	
	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public VideoDto register(@RequestBody @Valid VideoForm form) {
		return videoService.createVideo(form);
	}
	
	@GetMapping
	@Transactional
	public List<VideoDto> videoList() {
		return videoService.findAllVideos();
	}
	
	@GetMapping("/{id}")
	@Transactional
	public VideoDto videoById(@PathVariable("id") Long id) {
		return videoService.findVideosById(id);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public VideoDto updateVideoById(@RequestBody @Valid VideoForm form, @PathVariable("id") Long id) {
		return videoService.updateVideo(form, id);
	}
	
	@DeleteMapping("{id}")
	public void removeVideo(@PathVariable("id") Long id) {
		videoService.deleteVideo(id);
	}
}
