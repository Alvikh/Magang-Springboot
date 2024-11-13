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

import com.afterlife.java_fullstack_web.models.Returs;
import com.afterlife.java_fullstack_web.usecase.RetursUsecase;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/returs")
@Slf4j
public class RetursController {

	@Autowired
	private RetursUsecase retursUsecase;
	
		@GetMapping(value = "/index")
		public String getIndexFrozen(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Data Returs, Silahkan Check Kembali : " + result);
			}
			map.addAttribute("returs", retursUsecase.getListReturs());
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Data Berhasil");
			return "/pages/returs/index";
		}
		
		@GetMapping(value = "/form")
		public String getForm(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Form, Silahkan Check Kembali : " + result);
				return "pages/returs/index";
			}
			map.addAttribute("getFormReturs", retursUsecase.getListReturs());
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Form Berhasil");
			return "pages/returs/index";
		}
		
		@PostMapping(value = "/submit")
		public String saveDataReturs(@ModelAttribute(value = "returs") Returs returs, BindingResult result, 
							   RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan saat menambahkan data, Silahkan Check Kembali, berikut detail errornya : " + result);
				return "redirect:/returs/form";
			}
			retursUsecase.saveReturs(returs);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Simpan Dta");
			return "redirect:/returs/index";
		}
		
		@GetMapping(value = "/form/{id}")
		public String getFormEdit(ModelMap map, @PathVariable(value = "id")Integer id, 
								  BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Form Edit, Silahkan Check Kembali, berikut detail errornya : " + result);
				return "pages/returs/index";
			}
			map.addAttribute("getEditForm", retursUsecase.findByIdReturs(id));
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Edit Form Berhasil");
			return "pages/returs/index";
		}

		@PostMapping(value = "/update/{id}")
		public String updateReturs(ModelMap map, @ModelAttribute(value = "Returs") Returs returs, 
								   BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Update Data, Silahkan Check Kembali, Berikut detail errornya : " + result);
			}
			map.addAttribute("updateReturs", returs);
			retursUsecase.saveReturs(returs);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Update Data");
			return "redirect:/returs/index";
		}
		
		@GetMapping(value = "/delete{id}")
		public String removeData(@PathVariable(value = "id") Integer id, BindingResult result, 
								RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan saat delete data, silahkan check kembali, berikut detail errornya : " + result );
			}
			retursUsecase.deleteRetursById(id);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Delete Data");
			return "redirct:/returs/index";
		}
}
