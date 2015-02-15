package com.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "database_credentials",uniqueConstraints = @UniqueConstraint(columnNames = {
"database_id"}))
public class DatabaseCredential {
	private int database_id;
	private String database_name;
	private String database_ip;
	private String database_username;
	private String database_password;
	private String application_name;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="database_id",nullable=false,unique=true)
	public int getDatabase_id() {
		return database_id;
	}
	public void setDatabase_id(int database_id) {
		this.database_id = database_id;
	}
	
	@Column(name="database_name",nullable=false)
	public String getDatabase_name() {
		return database_name;
	}
	public void setDatabase_name(String database_name) {
		this.database_name = database_name;
	}
	
	@Column(name="database_ip",nullable=false)
	public String getDatabase_ip() {
		return database_ip;
	}
	public void setDatabase_ip(String database_ip) {
		this.database_ip = database_ip;
	}
	
	@Column(name="database_username",nullable=false)
	public String getDatabase_username() {
		return database_username;
	}
	public void setDatabase_username(String database_username) {
		this.database_username = database_username;
	}
	
	@Column(name="database_password",nullable=false)
	public String getDatabase_password() {
		return database_password;
	}
	public void setDatabase_password(String database_password) {
		this.database_password = database_password;
	}
	public String getApplication_name() {
		return application_name;
	}
	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}
	@Override
	public String toString() {
		return "DatabaseCredential [database_id=" + database_id
				+ ", database_name=" + database_name + ", database_ip="
				+ database_ip + ", database_username=" + database_username
				+ ", database_password=" + database_password
				+ ", application_name=" + application_name
				+ ", getDatabase_id()=" + getDatabase_id()
				+ ", getDatabase_name()=" + getDatabase_name()
				+ ", getDatabase_ip()=" + getDatabase_ip()
				+ ", getDatabase_username()=" + getDatabase_username()
				+ ", getDatabase_password()=" + getDatabase_password()
				+ ", getApplication_name()=" + getApplication_name()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
