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

import com.afterlife.java_fullstack_web.models.Transferplants;
import com.afterlife.java_fullstack_web.usecase.TransferplantsUsecase;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/transferplants")
@Slf4j
public class TransferplantsController {
	
	@Autowired
	private TransferplantsUsecase transferplantsUsecase;
	
		@GetMapping(value = "/index")
		public String getIndexTransferplants(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Data transferplants, Silahkan Check Kembali : " + result);
			}
			map.addAttribute("transferplants", transferplantsUsecase. getListTransferplants());
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Data Berhasil");
			return "/pages/transferplants/index";
		}
		
		@GetMapping(value = "/form")
		public String getForm(ModelMap map, BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Form, Silahkan Check Kembali : " + result);
			}
			map.addAttribute("getFormtransferplants", transferplantsUsecase. getListTransferplants());
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Form Berhasil");
			return "pages/transferplants/form";
		}
		
		@PostMapping(value = "/submit")
		public String saveData(@ModelAttribute(value = "transferplants") Transferplants transferplants, BindingResult bindingResult, 
							   RedirectAttributes redirectAttributes) {
			if(bindingResult.hasErrors()) {
				log.error("Ada Kesalahan saat menambahkan data, Silahkan Check Kembali, berikut detail errornya : " + bindingResult);
				return "redirect:/transferplants/form";
			}
			transferplantsUsecase.saveTransferplants(transferplants);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Simpan Dta");
			return "redirect:/transferplants/index";
		}
		
		@GetMapping(value = "/form/{id}")
		public String getFormEdit(ModelMap map, @PathVariable(value = "id")Integer id, BindingResult result, 
								  RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Get Form Edit, Silahkan Check Kembali, berikut detail errornya : " + result);
				return "pages/transferplants/index";
			}
			map.addAttribute("getEdittransferplantss", transferplantsUsecase.findByIdTransferplants(id));
			redirectAttributes.addFlashAttribute("alertSuccess", "Get Edit Form Berhasil");
			return "pages/transferplants/edit";
		}

		@PostMapping(value = "/update/{id}")
		public String UpdateData(ModelMap map, @ModelAttribute(value = "transferplants") Transferplants transferplants, 
								 BindingResult result, RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan Saat Update Data, Silahkan Check Kembali, Berikut detail errornya : " + result);
			}
			map.addAttribute("updatetransferplants", transferplants);
			transferplantsUsecase.saveTransferplants(transferplants);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Update Data");
			return "redirect:/transferplants/index";
		}
		
		@GetMapping(value = "/delete{id}")
		public String removeData(@PathVariable(value = "id") Integer id, BindingResult result, 
								RedirectAttributes redirectAttributes) {
			if(result.hasErrors()) {
				log.error("Ada Kesalahan saat delete data, silahkan check kembali, berikut detail errornya : " + result );
			}
			transferplantsUsecase.deleteTransferplantsById(id);
			redirectAttributes.addFlashAttribute("alertSuccess", "Berhasil Melakukan Proses Delete Data");
			return "redirct:/transferplants/index";
		}

}
