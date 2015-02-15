<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1" align="center" class="showdetails">
	<c:if test="${not empty  urlDataDetail}">
		<h4 class="linkurl" align="center"><spring:message code="url.details"/></h4>
		<thead>
				<tr>
					<th class="th">Sl_No.</th>
					<th class="th">Environment Name</th>
					<th class="th">Project Port</th>
					<th class="th">Module Name</th>
					<th  class="th" colspan="5">Module Link</th>
					<th class="th">Action</th>
				</tr>
		</thead>
		<tbody>
			<c:forEach items="${urlDataDetail}" var="urlData" varStatus="item">
				<form:form name="deleteURLData" modelAttribute="uRLData" method="POST" id="updateURLDatFormId${item.count}">
					<tr border="1">
						<td>
							<form:hidden path="urlDataId" value="${urlData.urlDataId}"/>
							<c:out value="${urlData.urlDataId}"/>.&nbsp;&nbsp;
						</td>
						<td>
							<form:input path="envName" value="${urlData.envName}"/>
						</td>
						<td>
							<form:input path="projectName" value="${urlData.projectName}"/>
						</td>
						<td>
							<form:input path="moduleName" value="${urlData.moduleName}"/>
						</td>
						<td colspan="5">
							<a href="${urlData.moduleLink}" target="_blank"><form:input path="moduleLink" value="${urlData.moduleLink}" size="60"/></a>
						</td>
						<td colspan="1" align="right">
							<form:input type="button" value="Update" path="urlDataId" onclick="submitForm('updateURLData','updateURLDatFormId${item.count}');"/>
							<form:input type="button" value="Delete" path="urlDataId" onclick="submitForm('deleteURLData','updateURLDatFormId${item.count}');"/>
						</td>
					</tr>
				</form:form>
			</c:forEach>
		</tbody>
	</c:if>
</table>
