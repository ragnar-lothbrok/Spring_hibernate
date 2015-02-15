<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="login-box">
	<h4 align="center"><spring:message code="add.url"/></h4>
	<form:form action="addURLData" name="urlDataForm" modelAttribute="uRLData" method="POST" id="addURLDataForm">
		<table align="center">
			<tr colspan="2">
				<td align="center"><font color="red"> <form:errors path="*" />
				</font></td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td colspan="1">Environment Name : </td>
				<form:hidden path="urlDataId" value="1"/>
				<td colspan="4"><form:input path="envName" class="url_env_name" /></td>
			</tr>
			
			<tr>
				<td colspan="1">Project Name     : </td>
				<td colspan="4"><form:input path="projectName" class="url_project_name" /></td>
			</tr>
			
			<tr>
				<td colspan="1">Module Name      : </td>
				<td colspan="4">
					<form:select class="url_module_name" path="moduleName" style="width: 142px;">
						<form:options items="${moduleTypeList}"/>
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td colspan="1">Module Link      : </td>
				<td colspan="4"><form:input path="moduleLink" class="url_module_link"/></td>
			</tr>
			
			<tr>
				<td colspan="1"></td>
				<td colspan="2" align="right"><form:input type="button" path="urlDataId" class="submit_button"
									onclick="submitForm('addURLData','addURLDataForm');" value="Add URL Data" /></td>
			</tr>
		</table>
	</form:form>
</div>