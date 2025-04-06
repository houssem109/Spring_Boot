package com.houssem.pcs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.houssem.pcs.entities.Pc;
import com.houssem.pcs.service.PcService;

@Controller
public class PcController {
	@Autowired
	PcService pcService;

	@RequestMapping("/listePcs")
	public String listePcs(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size)
			{
		Page<Pc> pcs = pcService.getAllPcsParPage(page,size);
		modelMap.addAttribute("pcs", pcs);
		modelMap.addAttribute("pages", new int[pcs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listePcs";
	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createPc";
	}

	@RequestMapping("/savePc")
	public String savePc(@ModelAttribute("pc") Pc pc, @RequestParam("date") String date, ModelMap modelMap)
			throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		pc.setDateAchat(dateCreation);

		Pc savePc = pcService.savePc(pc);
		String msg = "PC enregistré avec Id " + savePc.getIdPc();
		modelMap.addAttribute("msg", msg);
		return "createPc";
	}

	@RequestMapping("/supprimerPc")
	public String supprimerPc(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size) {
		pcService.deletePcById(id);
		Page<Pc> pcs = pcService.getAllPcsParPage(page,size);
		modelMap.addAttribute("pcs", pcs);
		modelMap.addAttribute("pages", new int[pcs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listePcs";
	}

	@RequestMapping("/modifierPc")
	public String editerPc(@RequestParam("id") Long id, ModelMap modelMap) {
		Pc p = pcService.getPc(id);
		modelMap.addAttribute("pc", p);
		return "editerPc";
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