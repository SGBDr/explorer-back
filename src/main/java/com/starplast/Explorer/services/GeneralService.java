package com.starplast.Explorer.services;

import java.io.File;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.starplast.Explorer.models.Directory;
import com.starplast.Explorer.models.Fichier;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service()
public class GeneralService {
	private static int flID = 1;
	private static int dirID = 0;

	public Directory mapDirectory() {
		Directory dir = new Directory("Racine","./static/Racine", dirID);

		showFiles(dir);
		return dir;
	}

	public void showFiles(Directory d)  {
		try {
			File files[] = (new ClassPathResource(d.getUrl()).getFile()).listFiles();
			for(File f: files){
				if(f.isDirectory()) {
					Directory dir = new Directory(f.getName() , d.getUrl() + "/" + f.getName(), dirID);
					dirID++;

					//faire appelle a recursive sur le dossier
					showFiles(dir);

					//ajouter le nouveau dossier a d
					d.addDirectory(dir);
				}
				else{
					//crée un fichier et ajouter a d
					Fichier fi = new Fichier(f.getName(),f.getPath(),f.length(),flID);
					flID++;
					d.addFile(fi);
				}
			}
		}

		catch(Exception e){
			log.info(e.getMessage());
		}

	}
}

