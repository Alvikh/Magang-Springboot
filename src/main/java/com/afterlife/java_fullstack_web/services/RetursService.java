package com.afterlife.java_fullstack_web.services;

import java.util.List;
import java.util.Optional;

import com.afterlife.java_fullstack_web.models.Returs;


public interface RetursService {

	// tambah data
	Returs saveReturs(Returs returs);
	
	// get all data
	List<Returs> getListReturs();
	
	// find by id data
	Optional<Returs> findByIdReturs(Integer id);
	
	// delete data
	void deleteRetursById(Integer id);
}
