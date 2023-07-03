package com.starplast.Explorer.controller;


import com.starplast.Explorer.models.Fichier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.starplast.Explorer.models.Directory;
import com.starplast.Explorer.services.GeneralService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class GeneralController {
	@Autowired
	private GeneralService service;

	@RequestMapping(value = "/getMap", method = RequestMethod.GET) @ResponseBody
	public Directory getMap() throws IOException {
		return service.mapDirectory();
	}

	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public ResponseEntity<byte[]> getPdf(@RequestBody Fichier fichier) throws IOException {
		// Read the PDF file and convert it to a byte array
		byte[] pdfBytes = Files.readAllBytes(Path.of(fichier.getUrl()));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_PDF_VALUE));
		headers.setContentDispositionFormData("attachment", "file.pdf");
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		return ResponseEntity.ok().headers(headers).body(pdfBytes);
	}

}
