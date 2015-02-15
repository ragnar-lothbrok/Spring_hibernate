<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<table border="1" align="center" class="showdetail">
	<c:if test="${not empty  tomcatDataDetail}">
	<h4 class="linktomcat" align="center"><spring:message code="tomcat.details"/></h4>
		<thead>
				<tr>
					<th class="th">Sl_No.</th>
					<th class="th">Tomcat Name</th>
					<th class="th">Tomcat Port</th>
					<th class="th">Environment Name</th>
					<th class="th">Action</th>
				</tr>
		</thead>
		<tbody>
			 <c:forEach items="${tomcatDataDetail}" var="tomcatData" varStatus="item">
				<tr border="1">
					<form:form  name="deleteTomcatData" modelAttribute="tomcatData" method="POST" id="updateTomcatDataFormId${item.count}">
						<td>
							<form:hidden path="tomcatDataId" value="${tomcatData.tomcatDataId}"/>
							<c:out value="${tomcatData.tomcatDataId}"/>.&nbsp;&nbsp;
						</td>
						<td>
							<form:input path="tomcatName" value="${tomcatData.tomcatName}"/>
						</td>
						<td>
							<form:input path="tomcatPort" value="${tomcatData.tomcatPort}"/>
						</td>
						<td>
							<form:input path="envName" value="${tomcatData.envName}"/>
						</td>
						<td colspan="1" align="right">
							<form:input type="button" value="Update" path="tomcatDataId" onclick="submitForm('updateTomcatData','updateTomcatDataFormId${item.count}');"/>
							<form:input type="button" value="Delete" path="tomcatDataId" onclick="submitForm('deleteTomcatData','updateTomcatDataFormId${item.count}');"/>
						</td>
					</form:form>
				</tr>
			</c:forEach>	
		</tbody>
	</c:if>
</table>
<br />
<div align="center">
	<input type="button" onclick="makeRequest('71')" value="Ajax Check Here"/>
	<c:if test="${not empty tomcatDataUnit}">
		<c:forEach items="${tomcatDataUnit}" var="tomcatData" varStatus="item">
			<table align="center">
				<tr border="1">
					<td>
						${tomcatData.tomcatDataId}"
					</td>
					<td>
						 ${tomcatData.tomcatName}
					</td>
					<td>
						${tomcatData.tomcatPort}
					</td>
					<td>
						${tomcatData.envName}
					</td>
				</tr>
			</table>
		</c:forEach>
	</c:if>
</div>