<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="login-box">
	<h4 align="center">ADD DataBase Credential DATA</h4>
	<form:form action="addData" name="DatabaseCredentialForm" modelAttribute="databaseCredential" id="addDatabaseCredentialForm">
		<table align="center">	
			<tr colspan="2">
				<td align="center" >
					<font color="red">
						<form:errors path="*"/>
					</font>
				</td>
			</tr>
		</table>
		<table align="center">
			<tbody>
				<tr>
					<td>Database Name : </td>
					<td>
						<form:input path="database_name"/>
					</td>
				</tr>	
				<tr>
					<td>Database IP : </td>
					<td>
						<form:input path="database_ip"/>
					</td>
				</tr>	
				<tr>
					<td>Database Username : </td>
					<td>
						<form:input path="database_username"/>
					</td>
				</tr>	
				<tr>
					<td>Database Password : </td>
					<td>
						<form:input path="database_password"/>
					</td>
				</tr>	
				<tr>
					<td>Application Name : </td>
					<td>
						<form:input path="application_name"/>
						<form:hidden path="database_id" value="1"/>
					</td>
				</tr>	
				<tr>
				<td colspan="1"></td>
				<td colspan="2" align="right"><form:input type="button" path="database_id" class="submit_button"
									value="Add Data" onclick="submitForm('addDatabaseCredential','addDatabaseCredentialForm');" />
			</tr>
			</tbody>
		</table>
	</form:form>
</div>