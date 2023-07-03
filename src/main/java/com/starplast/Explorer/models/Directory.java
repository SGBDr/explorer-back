package com.starplast.Explorer.models;

import java.util.ArrayList;
import java.util.List;

public class Directory {
	private int ID;
	private String name;
	private String url;
	private List<Fichier> fileList;
	private List<Directory> directoryList;
	
	public Directory(String name,String url, int ID) {
		this.ID = ID;
		this.name = name;
		this.url = url;
		this.fileList = new ArrayList<>();
		this.directoryList = new ArrayList<>();
	}

	public final int getID(){
		return this.ID;
	}

	public final void setID(int ID){
		this.ID = ID;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}
	
	public final String getUrl() {
		return url;
	}

	public final void setUrl(String url) {
		this.url = url;
	}

	public final List<Fichier> getFileList() {
		return fileList;
	}

	public final void setFileList(List<Fichier> fileList) {
		this.fileList = fileList;
	}

	public final List<Directory> getDirectoryList() {
		return directoryList;
	}

	public final void setDirectoryList(List<Directory> directoryList) {
		this.directoryList = directoryList;
	}
	
	public void addFile(Fichier f) {
		this.fileList.add(f);
	}
	
	public void addDirectory(Directory d) {
		this.directoryList.add(d);
	}
}
