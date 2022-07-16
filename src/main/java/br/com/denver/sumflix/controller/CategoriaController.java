package br.com.denver.sumflix.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.denver.sumflix.form.CategoriaForm;
import br.com.denver.sumflix.model.dto.CategoriaDto;
import br.com.denver.sumflix.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	
	@PostMapping
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public CategoriaDto createCategoria(@RequestBody @Valid CategoriaForm form) {
		return categoriaService.registerCategoria(form);
	}
	
	@GetMapping
	@Transactional
	public List<CategoriaDto> readCategoriaList() {
		return categoriaService.findAllCategorias();
	}
	
	@GetMapping("/{id}")
	@Transactional
	public CategoriaDto readCategoriaById(@PathVariable("id") Long id) {
		return categoriaService.findCategoriaById(id);
	}
	
}
