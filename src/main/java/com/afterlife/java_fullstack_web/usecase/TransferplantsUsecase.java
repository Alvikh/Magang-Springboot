package com.afterlife.java_fullstack_web.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afterlife.java_fullstack_web.models.Transferplants;
import com.afterlife.java_fullstack_web.repositories.TransferplantsRepository;
import com.afterlife.java_fullstack_web.services.TransferplantsService;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class TransferplantsUsecase implements TransferplantsService{

	@Autowired
	private TransferplantsRepository transfer;
	
	public Transferplants saveTransferplants(Transferplants transferplants) {
		return transfer.save(transferplants);
	}

	public List<Transferplants> getListTransferplants() {
		return transfer.findAll();
	}

	public Optional<Transferplants> findByIdTransferplants(Integer id) {
		return transfer.findById(id);
	}

	
	public void deleteTransferplantsById(Integer id) {
		transfer.deleteById(id);
	}

	
}
