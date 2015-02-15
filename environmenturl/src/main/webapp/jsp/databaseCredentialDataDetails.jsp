<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1" align="center" class="showdetail">
	<c:if test="${not empty  databaseCredentialList}">
		<h4 class="linkurl" align="center">All Database Credentials</h4>
		<thead>
			<tr>
				<th class="th">Sl_No.</th>
				<th class="th">Database Name</th>
				<th class="th">Database IP</th>
				<th class="th">Username</th>
				<th class="th">Password</th>
				<th class="th">Application Name</th>
				<th class="th">Action</th>
			</tr>
		</thead>
		<c:forEach items="${databaseCredentialList}" var="credential" varStatus="item">
			<form:form name="deleteDatabaseCrdential" modelAttribute="databaseCredential" id="updateDatabaseCredentialFormId${item.count}">
				<tr border="1">
					<td>
						<form:hidden path="database_id" value="${credential.database_id}"/>
						<c:out value="${credential.database_id}"/>.&nbsp;&nbsp;
					</td>
					<td>
						<form:input path="database_name" value="${credential.database_name}"/>
					</td>
					<td>
						<form:input path="database_ip" value="${credential.database_ip}"/>
					</td>
					<td>
						<form:input path="database_username" value="${credential.database_username}"/>
					</td>
					<td>
						<form:input path="database_password" value="${credential.database_password}"/>
					</td>
					<td>
						<form:input path="application_name" value="${credential.application_name}"/>
					</td>
					<td colspan="1" align="right">
						<form:input type="button" value="Update" path="database_id" onclick="submitForm

('updatDatbaseCredential','updateDatabaseCredentialFormId${item.count}');"/>
						<form:input type="button" value="Delete" path="database_id" onclick="submitForm

('deleteDatbaseCredential','updateDatabaseCredentialFormId${item.count}');"/>
					</td>
				</tr>
			</form:form>
		</c:forEach>
	</c:if>
</table>
    