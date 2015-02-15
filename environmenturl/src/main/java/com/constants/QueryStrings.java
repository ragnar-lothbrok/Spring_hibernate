package com.constants;

public interface QueryStrings {
	public static String INSERT_TOMCAT_DATA  ="insert into tomcat_Data(tomcat_name,tomcat_port,environment_name) values(?,?,?)";
	public static String UPDATE_TOMCAT_DATA  ="update tomcat_Data set tomcat_name=?,tomcat_port=?,environment_name=? where tomcat_id=?";
	public static String GET_TOMCAT_DATA     ="select * from tomcat_Data where status='active'";
	public static String DELETE_TOMCAT_DATA  ="delete from tomcat_Data where tomcat_id=?";
	
	public static String INSERT_URL_DATA     ="insert into url_Data(environment_name,project_name,module_name,module_link) values(?,?,?,?)";
	public static String UPDATE_URL_DATA     ="update url_Data set environment_name=?,project_name=?,module_name=?,module_link=? where url_id=?";
	public static String GET_URL_DATA        ="select * from url_Data where status='active'";
	public static String DELETE_URL_DATA     ="delete from url_Data where url_id=?";
	
	public static String GET_TOMCAT_DATA_H   ="from TomcatData where status='active'";
	public static String GET_TOMCAT_BY_ID_H ="from TomcatData where status='active' and tomcat_Id=";
	
	public static String GET_CONFIG_DATA ="from StaticData";
	
	public static String GET_DATABASE_CREDENTIAL_DATA ="from DatabaseCredential";
	
}
