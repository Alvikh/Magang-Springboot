package com.afterlife.java_fullstack_web.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afterlife.java_fullstack_web.models.Vendors;
import com.afterlife.java_fullstack_web.repositories.VendorsRepository;
import com.afterlife.java_fullstack_web.services.VendorsService;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class VendorsUsecase implements VendorsService{

	@Autowired
	private VendorsRepository repository;
	
	public Vendors saveVendors(Vendors vendors) {
		return repository.save(vendors);
	}
	
	public List<Vendors> getListVendors() {
		return repository.findAll();
	}
	
	public Optional<Vendors> findByIdVendors(Integer id) {
		return repository.findById(id);
	}
	
	public void deleteVendorsById(Integer id) {
		repository.deleteById(id);
	}

}
