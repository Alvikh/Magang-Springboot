package com.afterlife.java_fullstack_web.services;

import java.util.List;
import java.util.Optional;

import com.afterlife.java_fullstack_web.models.Frozens;

public interface FrozensService {

	// tambah data
	Frozens saveFrozens(Frozens frozens);
	
	// get all data
	List<Frozens> getListFrozens();
	
	// find by id data
	Optional<Frozens> findByIdFrozens(Integer id);
	
	// delete data
	void deleteFrozensById(Integer id);
}
