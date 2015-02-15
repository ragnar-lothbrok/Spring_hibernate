<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="login-box">
	<form action="showmsisdndetail" name="msisdndetailform" id="msisdndetailform" method="post">
		<!-- Because it is not a spring form so we added csrf explicitly -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		<table align="center">
			<h1>MSISDN DETAILS</h1>
			<tbody>
				<tr>
					<td colspan="2"><c:if test="${not empty emptymsisdn}">
							<div align="center"><font color="red" >${emptymsisdn}</font></div>
						</c:if>
					</td>
				</tr>
				<tr>
					<td>Action : </td>
					<td><select name="action" style="width: 142px;">
						<c:forEach items="${msisdnoperations}" var="item">
							<option value="${item}">${item}</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Enter Data : </td>
					<td><input type="text" name="msisdn"/></td>
				</tr>
				<tr>
					<td colspan="1"></td>
					<td colspan="2" align="right">
						<input type="button" value="Submit Data" onclick="submitForm('getmsisdndetail','msisdndetailform');">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
