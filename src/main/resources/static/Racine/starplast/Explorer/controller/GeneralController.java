package com.starplast.Explorer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.starplast.Explorer.models.Directory;
import com.starplast.Explorer.services.GeneralService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class GeneralController {
	@Autowired
	private GeneralService service;

	@RequestMapping(value = "/getMap", method = RequestMethod.GET) @ResponseBody
	public Directory getMap() {
		return service.mapDirectory();
	}
}
