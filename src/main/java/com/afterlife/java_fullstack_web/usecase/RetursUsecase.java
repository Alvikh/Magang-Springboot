package com.afterlife.java_fullstack_web.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afterlife.java_fullstack_web.models.Returs;
import com.afterlife.java_fullstack_web.repositories.RetursRepository;
import com.afterlife.java_fullstack_web.services.RetursService;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class RetursUsecase implements RetursService{

	@Autowired
	private RetursRepository repo;
	
	public Returs saveReturs(Returs returs) {
		return repo.save(returs);
	}

	public List<Returs> getListReturs() {
		return repo.findAll();
	}

	public Optional<Returs> findByIdReturs(Integer id) {
		return repo.findById(id);
	}

	public void deleteRetursById(Integer id) {
		repo.deleteById(id);
	}

}
