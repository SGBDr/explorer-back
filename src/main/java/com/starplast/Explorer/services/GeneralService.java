package com.starplast.Explorer.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.starplast.Explorer.models.Directory;
import com.starplast.Explorer.models.Fichier;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service()
public class GeneralService {
	private static int flID = 1;
	private static int dirID = 0;

	public Directory mapDirectory() throws IOException {
		Directory dir = new Directory("Racine","M:/Explorer", dirID);

		showFiles(dir);
		return dir;
	}

	public void showFiles(Directory d) throws IOException {
			Path path = Paths.get(d.getUrl());
			File files[] = (new File(path.toUri())).listFiles();
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
}

