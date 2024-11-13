package com.afterlife.java_fullstack_web.services;

import java.util.List;
import java.util.Optional;

import com.afterlife.java_fullstack_web.models.Assets;


public interface AssetsService {

	// tambah data
		Assets saveAssets(Assets assets);
		
		// get all data
		List<Assets> getListAssets();
		
		// find by id data
		Optional<Assets> findByIdAssets(Integer id);
		
		// delete data
		void deleteAssetsById(Integer id);
	
}
