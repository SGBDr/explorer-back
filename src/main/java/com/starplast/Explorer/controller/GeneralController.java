package com.starplast.Explorer.controller;


import com.starplast.Explorer.models.Fichier;
import com.starplast.Explorer.models.Response.PDF;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.starplast.Explorer.models.Directory;
import com.starplast.Explorer.services.GeneralService;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
