package com.evangelista.projetocurso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evangelista.projetocurso.domain.Categoria;
import com.evangelista.projetocurso.repositories.CategoriaRepository;
import com.evangelista.projetocurso.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
																	id + ", Tipo: " + Categoria.class.getName()));
	}

}
