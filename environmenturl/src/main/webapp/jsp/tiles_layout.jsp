<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><spring:message code="title"/></title>
		<meta name="viewport"
			content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
		<meta http-equiv="Cache-Control" content="no-cache" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<tilesx:useAttribute name="styles" classname="java.util.List" />
		<c:forEach var="css" items="${styles}">
			<link type="text/css" rel="stylesheet"
				href="<%=request.getContextPath()%>/css/<c:out value="${css}"/>" />
		</c:forEach>
		<tilesx:useAttribute name="scripts" classname="java.util.List" />
		<c:forEach var="script" items="${scripts}">
			<script type="text/javascript"
				src="<%=request.getContextPath()%>/js/<c:out value="${script}"/>"></script>
		</c:forEach>
		
<%-- <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script> --%>
	</head>
	<body>
	
		<c:set var="currentUrl" value="${requestScope['javax.servlet.forward.servlet_path']}"/>
		<div align="left">
			<img src="<%=request.getContextPath()%>/images//download.jpg">
			<c:if test="${currentUrl ne '/tool' }">
				<div align="center"><a href="../../tool">Back to Home</a></div><br /><br />
			</c:if>	
		</div>
		
		<jsp:include page="linebreaker.jsp"/>
		
		<tiles:insertAttribute name="body1" />
	
		<tiles:insertAttribute name="body2" />
	
		<tiles:insertAttribute name="body3" />
		
	</body>
</html>