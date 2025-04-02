package com.houssem.pcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PcController {

	@RequestMapping("/myView")
	public String myView() {
		return "myView";
	}
}
