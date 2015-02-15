package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import static javax.persistence.GenerationType.IDENTITY;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "tomcat_data",uniqueConstraints = @UniqueConstraint(columnNames = {
"tomcat_id"}))
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class TomcatData {
	int tomcatDataId;
	String tomcatName;
	String tomcatPort;
	String envName;
	
	@Column(name = "environment_name", nullable = false)
	public String getEnvName() {
		return envName;
	}

	public void setEnvName(String envName) {
		this.envName = envName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tomcat_id", nullable = false, unique = true)
	public int getTomcatDataId() {
		return tomcatDataId;
	}
	
	public void setTomcatDataId(int tomcatDataId) {
		this.tomcatDataId = tomcatDataId;
	}
	
	@Column(name = "tomcat_name", nullable = false)
	public String getTomcatName() {
		return tomcatName;
	}
	
	public void setTomcatName(String tomcatName) {
		this.tomcatName = tomcatName;
	}
	
	@Column(name = "tomcat_port", nullable = false)
	public String getTomcatPort() {
		return tomcatPort;
	}
	
	public void setTomcatPort(String tomcatPort) {
		this.tomcatPort = tomcatPort;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[ TomcatDataId : "+tomcatDataId+" envName : "+envName+" TomcatName : "+tomcatName+" TomcatPort : "+tomcatPort+" ]");
		return buffer.toString();
	}
}
