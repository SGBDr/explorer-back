package com.starplast.Explorer.models;

public class Fichier {
	private String name;
	private String url;
	private double size;
	private int ID;
	
	public Fichier(String name,String url, double size, int ID) {
		this.name = name;
		this.url = url;
		this.size = size;
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

	public final double getSize() {
		return size;
	}

	public final void setSize(double size) {
		this.size = size;
	}

	public final int getId() {
		return ID;
	}

	public final void setId(int id) {
		this.ID = ID;
	}
	
	
	
}
