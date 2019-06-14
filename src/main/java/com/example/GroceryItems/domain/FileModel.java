package com.example.GroceryItems.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String fileName, mimeType;

	@Lob
	private byte[] file;

	//Constructer
	public FileModel() {

	}

	//Constructer
	public FileModel(String fileName, String mimeType, byte[] file) {
		super();
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.file = file;
	}

	//Getters and Setters
	public long getId() {
		return id;
	}

	public String getFileName() {
		return fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public byte[] getFile() {
		return file;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
