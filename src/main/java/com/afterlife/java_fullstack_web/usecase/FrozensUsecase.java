package com.afterlife.java_fullstack_web.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afterlife.java_fullstack_web.models.Frozens;
import com.afterlife.java_fullstack_web.repositories.FrozensRepository;
import com.afterlife.java_fullstack_web.services.FrozensService;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class FrozensUsecase implements FrozensService {

	@Autowired
	private FrozensRepository frozenRepository;
	
	public Frozens saveFrozens(Frozens frozens) {
		return frozenRepository.save(frozens);
	}

	public List<Frozens> getListFrozens() {
		return frozenRepository.findAll();
	}

	public Optional<Frozens> findByIdFrozens(Integer id) {
		return frozenRepository.findById(id);
	}

	public void deleteFrozensById(Integer id) {		
		frozenRepository.deleteById(id);
	}

}
