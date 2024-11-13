package com.afterlife.java_fullstack_web.services;

import java.util.List;
import java.util.Optional;

import com.afterlife.java_fullstack_web.models.Vendors;

public interface VendorsService {

	// tambah data
	Vendors saveVendors(Vendors vendors);
	
	// get all data
	List<Vendors> getListVendors();
	
	// find by id data
	Optional<Vendors> findByIdVendors(Integer id);
	
	// delete data
	void deleteVendorsById(Integer id);
}
