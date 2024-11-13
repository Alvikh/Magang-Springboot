package com.afterlife.java_fullstack_web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.afterlife.java_fullstack_web.models.Assets;
import com.afterlife.java_fullstack_web.usecase.AssetsUsecase;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/assets")
@Slf4j
public class AssetsController {

	@Autowired
	private AssetsUsecase assetsUsecase;
	
		@GetMapping(value = "/index")
		public String getIndexAsset(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Data assets, Silahkan Check Kembali : " + result);
			}
			map.addAttribute("assets", assetsUsecase.getListAssets());
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Data Berhasil");
			return "/pages/assets/index";
		}
		
		@GetMapping(value = "/form")
		public String getForm(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Form, Silahkan Check Kembali : " + result);
			}
			map.addAttribute("getFormassets", assetsUsecase.getListAssets());
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Form Berhasil");
			return "pages/assets/form";
		}
		
		@PostMapping(value = "/submit")
		public String saveData(@ModelAttribute(value = "assets") Assets assets, BindingResult bindingResult, 
							   RedirectAttributes redirectAttributes) {
			if(bindingResult.hasErrors()) {
				log.error("Ada Kesalahan saat menambahkan data, Silahkan Check Kembali, berikut detail errornya : " + bindingResult);
				return "redirect:/assets/form";
			}
			assetsUsecase.saveAssets(assets);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Simpan Dta");
			return "redirect:/assets/index";
		}
		
		@GetMapping(value = "/form/{id}")
		public String getFormEdit(ModelMap map, @PathVariable(value = "id")Integer id, BindingResult result, 
								  RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Form Edit, Silahkan Check Kembali, berikut detail errornya : " + result);
				return "pages/assets/index";
			}
			map.addAttribute("getEditassetss", assetsUsecase.findByIdAssets(id));
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Edit Form Berhasil");
			return "pages/assets/edit";
		}

		@PostMapping(value = "/update/{id}")
		public String UpdateData(ModelMap map, @ModelAttribute(value = "assets") Assets assets, 
								 BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Update Data, Silahkan Check Kembali, Berikut detail errornya : " + result);
			}
			map.addAttribute("updateassets", assets);
			assetsUsecase.saveAssets(assets);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Update Data");
			return "redirect:/assets/index";
		}
		
		@GetMapping(value = "/delete{id}")
		public String removeData(@PathVariable(value = "id") Integer id, BindingResult result, 
								RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan saat delete data, silahkan check kembali, berikut detail errornya : " + result );
			}
			assetsUsecase.deleteAssetsById(id);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Delete Data");
			return "redirct:/assets/index";
		}
}
