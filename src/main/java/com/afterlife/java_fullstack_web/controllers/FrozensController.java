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
import com.afterlife.java_fullstack_web.models.Frozens;
import com.afterlife.java_fullstack_web.usecase.FrozensUsecase;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/frozens")
@Slf4j
public class FrozensController {
	
	@Autowired
	private FrozensUsecase frozensUsecase;
	
		@GetMapping(value = "/index")
		public String getIndexFrozen(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Data frozens, Silahkan Check Kembali : " + result);
			}
			map.addAttribute("frozens", frozensUsecase.getListFrozens());
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Data Berhasil");
			return "/pages/frozens/index";
		}
		
		@GetMapping(value = "/form")
		public String getForm(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Form, Silahkan Check Kembali : " + result);
			}
			map.addAttribute("getFormFrozens", frozensUsecase.getListFrozens());
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Form Berhasil");
			return "pages/frozens/form";
		}
		
		@PostMapping(value = "/submit")
		public String saveData(@ModelAttribute(value = "frozens") Frozens frozens, BindingResult bindingResult, 
							   RedirectAttributes redirectAttributes) {
			if(bindingResult.hasErrors()) {
				log.error("Ada Kesalahan saat menambahkan data, Silahkan Check Kembali, berikut detail errornya : " + bindingResult);
				return "redirect:/frozens/form";
			}
			frozensUsecase.saveFrozens(frozens);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Simpan Dta");
			return "redirect:/frozens/index";
		}
		
		@GetMapping(value = "/form/{id}")
		public String getFormEdit(ModelMap map, @PathVariable(value = "id")Integer id, BindingResult result, 
								  RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Form Edit, Silahkan Check Kembali, berikut detail errornya : " + result);
				return "pages/frozens/index";
			}
			map.addAttribute("getEditfrozenss", frozensUsecase.findByIdFrozens(id));
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Edit Form Berhasil");
			return "pages/frozens/edit";
		}

		@PostMapping(value = "/update/{id}")
		public String UpdateData(ModelMap map, @ModelAttribute(value = "frozens") Frozens frozens, 
								 BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Update Data, Silahkan Check Kembali, Berikut detail errornya : " + result);
			}
			map.addAttribute("updateFrozens", frozens);
			frozensUsecase.saveFrozens(frozens);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Update Data");
			return "redirect:/frozens/index";
		}
		
		@GetMapping(value = "/delete{id}")
		public String removeData(@PathVariable(value = "id") Integer id, BindingResult result, 
								RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan saat delete data, silahkan check kembali, berikut detail errornya : " + result );
			}
			frozensUsecase.deleteFrozensById(id);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Delete Data");
			return "redirct:/frozens/index";
		}
}
