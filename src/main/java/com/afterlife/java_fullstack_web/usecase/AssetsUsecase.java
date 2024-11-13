package com.afterlife.java_fullstack_web.usecase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afterlife.java_fullstack_web.models.Assets;
import com.afterlife.java_fullstack_web.repositories.AssetsRepository;
import com.afterlife.java_fullstack_web.services.AssetsService;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class AssetsUsecase implements AssetsService{

	
	@Autowired
	
	private AssetsRepository asset;
	
	public Assets saveAssets(Assets assets) {
		return asset.save(assets);
	}

	public List<Assets> getListAssets() {
		return asset.findAll();
	}

	public Optional<Assets> findByIdAssets(Integer id) {
		return asset.findById(id);
	}

	
	public void deleteAssetsById(Integer id) {
		asset.deleteById(id);
	}

}
