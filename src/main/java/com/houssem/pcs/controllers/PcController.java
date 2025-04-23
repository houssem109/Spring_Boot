package com.houssem.pcs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.houssem.pcs.entities.Marque;
import com.houssem.pcs.entities.Pc;
import com.houssem.pcs.service.PcService;

import jakarta.validation.Valid;

@Controller
public class PcController {
	@Autowired
	PcService pcService;

	@RequestMapping("/listePcs")
	public String listePcs(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Pc> pcs = pcService.getAllPcsParPage(page, size);
		modelMap.addAttribute("pcs", pcs);
		modelMap.addAttribute("pages", new int[pcs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listePcs";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Marque> mars = pcService.getAllMarques();
		modelMap.addAttribute("pc", new Pc());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("marques", mars);

		return "formPc";
	}

	@RequestMapping("/savePc")
	public String savePc(@Valid Pc pc, BindingResult bindingResult, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		int currentPage;
		boolean isNew = false;

		if (bindingResult.hasErrors()) {
			List<Marque> mars = pcService.getAllMarques();
			modelMap.addAttribute("marques", mars);

			if (pc.getIdPc() == null) {
				isNew = true;
			}

			return "formPc";

		}

		pcService.savePc(pc);

		if (isNew) // ajout
		{
			Page<Pc> pcs = pcService.getAllPcsParPage(page, size);
			currentPage = pcs.getTotalPages() - 1;
		} else {// modif
			currentPage = page;
		}
		return ("redirect:/listePcs?page="+currentPage+"&size="+size);
	}

	@RequestMapping("/supprimerPc")
	public String supprimerPc(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		pcService.deletePcById(id);
		Page<Pc> pcs = pcService.getAllPcsParPage(page, size);
		modelMap.addAttribute("pcs", pcs);
		modelMap.addAttribute("pages", new int[pcs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listePcs";
	}

	@RequestMapping("/modifierPc")
	public String editerPc(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Pc p = pcService.getPc(id);
		List<Marque> mars = pcService.getAllMarques();

		modelMap.addAttribute("pc", p);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("marques", mars);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formPc";
	}

	@RequestMapping("/updatePc")
	public String updatePc(@ModelAttribute("pc") Pc pc, @RequestParam("date") String date, ModelMap modelMap)
			throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		pc.setDateAchat(dateCreation);

		pcService.updatePc(pc);
		List<Pc> pcs = pcService.getAllPcs();
		modelMap.addAttribute("pcs", pcs);
		return "listePcs";
	}
}