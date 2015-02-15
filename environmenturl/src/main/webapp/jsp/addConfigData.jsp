<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div id="login-box">
	<h4 align="center">ADD CONFIG DATA</h4>
	<form:form action="addData" name="staticDataForm" modelAttribute="staticData" id="addConfigDataForm">
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
				<c:if test="${fn:length(configTypeList) gt 0}">
					<tr>
						<td>Config Type : </td>
						<td>
							<form:select class="" path="data_type" style="width: 168px;">
								<form:options items="${configTypeList}"/>
							</form:select>
						</td>
					</tr>	
				</c:if>
				<tr>
					<td>Config Value : </td>
					<td>
						<form:input path="data_value" style="width: 163px;"/>
						<form:hidden path="data_id" value="1"/>
					</td>
				</tr>	
				<tr>
				<td colspan="1"></td>
				<td colspan="2" align="right"><form:input type="button" path="data_id" class="submit_button"
									value="Add Config Data" onclick="submitForm('addConfigData','addConfigDataForm');" />
			</tr>
			</tbody>
		</table>
	</form:form>
</div>