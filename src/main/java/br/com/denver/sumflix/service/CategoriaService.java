package br.com.denver.sumflix.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.denver.sumflix.form.CategoriaForm;
import br.com.denver.sumflix.model.Categoria;
import br.com.denver.sumflix.model.dto.CategoriaDto;
import br.com.denver.sumflix.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
		
	public CategoriaDto registerCategoria(CategoriaForm form) {
		Categoria categoria = convertToCategoria(form);
		categoriaRepository.save(categoria);
		return convertToDto(categoria);
	}

	public List<CategoriaDto> findAllCategorias() {
		List<Categoria> categoria = categoriaRepository.findAll();
		return convertToListDto(categoria);
	}
	
	public CategoriaDto findCategoriaById(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(categoria.isPresent()) {
			return convertToDto(categoria.get());
		}
		return null;
	}
	
	private Categoria convertToCategoria(CategoriaForm form) {
		Categoria categoria = new Categoria();
		categoria.setTitulo(form.getTitulo());
		categoria.setCor(form.getCor());
		return categoria;
	}

	private CategoriaDto convertToDto(Categoria categoria) {
		CategoriaDto dto = new CategoriaDto();
		dto.setTitulo(categoria.getTitulo());
		dto.setCor(categoria.getCor());
		return dto;
	}

	private List<CategoriaDto> convertToListDto(List<Categoria> categoria) {
		return categoria.stream().map(CategoriaDto::new).collect(Collectors.toList());
	}
	
}
