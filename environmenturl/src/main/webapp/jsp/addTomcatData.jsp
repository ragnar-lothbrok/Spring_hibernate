<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="login-box">
	<h4 align="center"><spring:message code="add.tomcat"/></h4>
	<form:form action="addTomcatData" name="tomcatDataForm" modelAttribute="tomcatData" method="POST" id="addTomcatDataForm">
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
			<tr>
				<td colspan="1">Tomcat Name : </td>
				<form:hidden path="tomcatDataId" value="1"/>
				<td colspan="4"><form:input path="tomcatName" class="tomcat_name" /></td>
			</tr>
			
			<tr>
				<td colspan="1">Tomcat Port : </td>
				<td colspan="4"><form:input path="tomcatPort" class="tomcat_port" name="tomcatPort" value=""/></td>
			</tr>
			
			<tr>
				<td colspan="1">Environment Name : </td>
				<td colspan="4">
					<form:select class="tomcat_env_name" name="envName" path="envName" style="width: 153px;">
						<form:options items="${environmentTypeList}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td colspan="1"></td>
				<td colspan="2" align="right"><form:input type="button" path="tomcatDataId" class="submit_button"
									value="Add Tomcat Data" onclick="submitForm
	
	('addTomcatData','addTomcatDataForm');" />
			</tr>
		</table>
	</form:form>	
</div>