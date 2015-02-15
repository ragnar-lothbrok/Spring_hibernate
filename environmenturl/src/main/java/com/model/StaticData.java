package com.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "config_data",uniqueConstraints = @UniqueConstraint(columnNames = {
"data_id"}))
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
public class StaticData {
	private int data_id;
	private String data_type;
	private String data_value;
	private String status ="active";
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "data_id", nullable = false,unique=true)
	public int getData_id() {
		return data_id;
	}
	public void setData_id(int data_id) {
		this.data_id = data_id;
	}
	
	@Column(name = "data_type", nullable = false)
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	
	@Column(name = "data_value", nullable = false)
	public String getData_value() {
		return data_value;
	}
	public void setData_value(String data_value) {
		this.data_value = data_value;
	}
	
	@Column(name = "status", nullable = false)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "StaticData [data_id=" + data_id + ", data_type=" + data_type
				+ ", data_value=" + data_value + ", status=" + status
				+ ", getData_id()=" + getData_id() + ", getData_type()="
				+ getData_type() + ", getData_value()=" + getData_value()
				+ ", getStatus()=" + getStatus() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
