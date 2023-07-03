package com.starplast.Explorer.services;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.starplast.Explorer.models.Directory;
import com.starplast.Explorer.models.Fichier;

@Service()
public class GeneralService {
	private static int flID = 1;
	private static int dirID = 0;

	public Directory mapDirectory() {
		Directory dir = new Directory("Racine","M:/18_INSTRUCTIONS_PROCEDES_SPECIAUX", dirID);
		showFiles(dir);
		return dir;
	}

	public void showFiles(Directory d)  {
		File [] files;
		try {
			files = (new ClassPathResource(d.getUrl()).getFile()).listFiles();
			for(int i=0;i<files.length;i++){
				File f=files[i];
				if (f==null)continue;
				if(f.isDirectory()) {
					Directory dir = new Directory(f.getPath(),f.getName(), dirID);
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
			files=new File[1];
			System.out.println(e.getMessage());
		}

	}
}

