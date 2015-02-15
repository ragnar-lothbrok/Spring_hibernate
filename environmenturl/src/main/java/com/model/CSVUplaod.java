package com.model;

import org.springframework.web.multipart.MultipartFile;

public class CSVUplaod {
	MultipartFile CSVFile;
	String alertDate;
	String savedpath;
    String fileuploaddate;
    String fileuploadtime;
    
    public String getFileuploaddate() {
		return fileuploaddate;
	}
	public void setFileuploaddate(String fileuploaddate) {
		this.fileuploaddate = fileuploaddate;
	}
	public String getFileuploadtime() {
		return fileuploadtime;
	}
	public void setFileuploadtime(String fileuploadtime) {
		this.fileuploadtime = fileuploadtime;
	}
	
    
   
	public String getSavedpath() {
		return savedpath;
	}
	public void setSavedpath(String savedpath) {
		this.savedpath = savedpath;
	}
	public MultipartFile getCSVFile() {
		return CSVFile;
	}
	public void setCSVFile(MultipartFile cSVFile) {
		CSVFile = cSVFile;
	}
	public String getAlertDate() {
		return alertDate;
	}
	public void setAlertDate(String alertDate) {
		this.alertDate = alertDate;
	}
	
}
