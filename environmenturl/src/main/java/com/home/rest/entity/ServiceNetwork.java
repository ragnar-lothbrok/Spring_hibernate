package com.home.rest.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="service_network")
@DynamicInsert(value=true)
@DynamicUpdate(value=true)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class ServiceNetwork implements Serializable{


	private static final long serialVersionUID = 1L;
	private Integer serviceNetworkId;
	private String name;
	private String description;
	private String requestParamName;
	private String notificationUrl;
	private String httpMethod;
	private String notifyOnAction;
	private String status;
	private Date createDate;
	private Date modifyDate;

	public ServiceNetwork() {
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "service_network_id", unique = true, nullable = false)
	public Integer getServiceNetworkId() {
		return serviceNetworkId;
	}


	public void setServiceNetworkId(Integer serviceNetworkId) {
		this.serviceNetworkId = serviceNetworkId;
	}

	@Column(name = "name", nullable = false, length = 64)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 256)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "request_param_name", length = 45)
	public String getRequestParamName() {
		return requestParamName;
	}

	public void setRequestParamName(String requestParamName) {
		this.requestParamName = requestParamName;
	}

	@Column(name = "notification_url", length = 256)
	public String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	@Column(name = "http_method", nullable = false, length = 8)
	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	@Column(name = "notify_on_action", nullable = false, length = 12)
	public String getNotifyOnAction() {
		return notifyOnAction;
	}

	public void setNotifyOnAction(String notifyOnAction) {
		this.notifyOnAction = notifyOnAction;
	}

	@Column(name = "status", nullable = false, length = 8)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date", nullable = false, length = 19)
	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}


	@Override
	public String toString() {
		return "ServiceNetwork [serviceNetworkId=" + serviceNetworkId + ", name=" + name
				+ ", description=" + description + ", requestParamName="
				+ requestParamName + ", notificationUrl=" + notificationUrl
				+ ", httpMethod=" + httpMethod + ", notifyOnAction="
				+ notifyOnAction + ", status=" + status + ", createDate="
				+ createDate + ", modifyDate=" + modifyDate + "]";
	}


}
