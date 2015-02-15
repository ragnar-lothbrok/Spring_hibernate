<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty decryptedMsisdn and not empty encryptedMsisdn}">
	<table align="center">
		<tbody>
			<tr>
				<td>ENCRYPTED DATA : </td>
				<td>${encryptedMsisdn}</td>
			</tr>
			<tr>
				<td>DECRYPTED DATA : </td>
				<td>${decryptedMsisdn}</td>
			</tr>
		</tbody>
	</table>
</c:if>
