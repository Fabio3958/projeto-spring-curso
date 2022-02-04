package com.evangelista.projetocurso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evangelista.projetocurso.domain.Pedido;
import com.evangelista.projetocurso.repositories.PedidoRepository;
import com.evangelista.projetocurso.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
																	id + ", Tipo: " + Pedido.class.getName()));
	}

}
