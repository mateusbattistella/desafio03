package com.clientes.desafio03.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientes.desafio03.dto.ClientDTO;
import com.clientes.desafio03.entities.Client;
import com.clientes.desafio03.exceptions.ResourceNotFoundException;
import com.clientes.desafio03.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public ClientDTO findByID(Long id) {
		Client client = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new ClientDTO(client);
	}

}
