<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">

	<a href="tool/tomcatdata/showTomcatData">Show Tomcat Screen</a>
	
	<jsp:include page="linebreaker.jsp"/>
	
	<a href="tool/urldata/showURLData">Show URL Screen</a>
	
	<jsp:include page="linebreaker.jsp"/>
	
	<a href="tool/dataMaintenance/showData">Show Maintenance Screen</a>
	
	<jsp:include page="linebreaker.jsp"/>
	
	<a href="tool/databasecredential/showData">Show Database Credential Screen</a>
	
	<jsp:include page="linebreaker.jsp"/>
	
	<a href="tool/msisdndetail/showmsisdndetail">MSISDN Decryption / Encryption</a>
	
	<jsp:include page="linebreaker.jsp"/>
	
	<a href="monitoring">Click for Monitoring</a>
	
	<jsp:include page="linebreaker.jsp"/>
	
	<a href="#">Tax Calculation</a><br>
	
	<jsp:include page="linebreaker.jsp"/>
	
	<a href="tool/uploadFile">Click to upload a file</a>
</div>
