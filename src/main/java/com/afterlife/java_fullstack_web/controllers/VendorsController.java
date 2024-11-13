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

import com.afterlife.java_fullstack_web.models.Vendors;
import com.afterlife.java_fullstack_web.usecase.VendorsUsecase;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/vendor")
@Slf4j
public class VendorsController {
	
	@Autowired
	private VendorsUsecase vendorsUsecase;
	
		@GetMapping(value = "/index")
		public String getListVendor(ModelMap map, RedirectAttributes redirectAttributes) {
			map.addAttribute("Vendors", vendorsUsecase.getListVendors());
			redirectAttributes.addFlashAttribute( "alertSuccess", "Get Data Berhasil");
			return "pages/vendor/index";
		}
		
		@GetMapping(value = "/form")
		public String getForm(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Form, Silahkan Check Kembali : " + result);
			}
			map.addAttribute("formVendors", vendorsUsecase.getListVendors());
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Data With Form Berhasil");
			return "pages/vendor/form";
		}
		
		@GetMapping(value = "/form/{id}")
		public String getFormEdit(ModelMap map, @PathVariable(value = "id")Integer id, BindingResult result, 
								  RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Form Edit, Silahkan Check Kembali, berikut detail errornya : " + result);
				return "pages/vendor/index";
			}
			map.addAttribute("getEditVendors", vendorsUsecase.findByIdVendors(id));
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Edit Form Berhasil");
			return "pages/vendor/edit";
		}
		
		@PostMapping(value = "/update/{id}")
		public String UpdateData(ModelMap map, @ModelAttribute(value = "vendors") Vendors vendors, 
								 BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Update Data, Silahkan Check Kembali, Berikut detail errornya : " + result);
			}
			map.addAttribute("vendors", vendors);
			vendorsUsecase.saveVendors(vendors);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Update Data");
			return "redirect:/vendor/index";
		}
		
		@PostMapping(value = "/submit")
		public String saveData(@ModelAttribute(value = "vendors") Vendors vendors, BindingResult result, 
							   RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan saat menambahkan data, Silahkan Check Kembali, berikut detail errornya : " + result);
				return "redirect:/vendor/form";
			}
			vendorsUsecase.saveVendors(vendors);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Simpan Dta");
			return "redirect:/vendor/index";
		}
		
		@GetMapping(value = "/delete{id}")
		public String removeData(@PathVariable(value = "id") Integer id, BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan saat delete data, silahkan check kembali, berikut detail errornya : " + result );
			}
			vendorsUsecase.deleteVendorsById(id);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Delete Data");
			return "redirct:/vendor/index";
		}
}
