package com.evangelista.projetocurso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evangelista.projetocurso.domain.Cliente;
import com.evangelista.projetocurso.repositories.ClienteRepository;
import com.evangelista.projetocurso.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
																	id + ", Tipo: " + Cliente.class.getName()));
	}

}
