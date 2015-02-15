package com.model;


public class URLData {
	int    urlDataId;
	String envName;
	String projectName;
	String moduleName;
	String moduleLink;
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getEnvName() {
		return envName;
	}
	public void setEnvName(String envName) {
		this.envName = envName;
	}
	public int getUrlDataId() {
		return urlDataId;
	}
	public void setUrlDataId(int urlDataId) {
		this.urlDataId = urlDataId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleLink() {
		return moduleLink;
	}
	public void setModuleLink(String moduleLink) {
		this.moduleLink = moduleLink;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ urlDataId : "+urlDataId+" EnvName : "+envName+" projectName : "+projectName+" ModuleName : "+moduleName+" ModuleLink : "+moduleLink+" ]");
		return buffer.toString();
	}
	
	public boolean equals(Object obj) {
		if(obj != null){
			URLData data = (URLData)obj;
			if((data.getModuleLink()+data.getModuleName()).equalsIgnoreCase(this.getModuleLink()+this.getModuleName()))
				return true;
		}
		return false;
    }
	
	public int hashCode(){
		int hashCode = (int)Math.random();
		if(null != this.getModuleLink()){
			hashCode = hashCode +this.getModuleLink().hashCode();
		}
		if(null != this.getModuleName()){
			hashCode = hashCode + this.getModuleName().hashCode();
		}
		return hashCode;
	}
}
