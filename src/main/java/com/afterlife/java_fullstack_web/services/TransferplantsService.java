package com.afterlife.java_fullstack_web.services;

import java.util.List;
import java.util.Optional;

import com.afterlife.java_fullstack_web.models.Transferplants;

public interface TransferplantsService {

	// tambah data
		Transferplants saveTransferplants(Transferplants transferplants);
		
		// get all data
		List<Transferplants> getListTransferplants();
		
		// find by id data
		Optional<Transferplants> findByIdTransferplants(Integer id);
		
		// delete data
		void deleteTransferplantsById(Integer id);
}
