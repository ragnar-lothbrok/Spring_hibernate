<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1" align="center" class="showdetail">
	<c:if test="${not empty  staticDataList}">
		<h4 class="linkurl" align="center">All Config Data</h4>
		<thead>
			<tr>
				<th class="th">Sl_No.</th>
				<th class="th">Data Type</th>
				<th class="th">Data Value</th>
				<th class="th">Action</th>
			</tr>
		</thead>
		<c:forEach items="${staticDataList}" var="configData" varStatus="item">
			<form:form name="deleteConfigData" modelAttribute="staticData" id="updateConfigDatFormId${item.count}">
				<tr border="1">
					<td>
						<form:hidden path="data_id" value="${configData.data_id}"/>
						<c:out value="${configData.data_id}"/>.&nbsp;&nbsp;
					</td>
					<td>
						<form:input path="data_type" value="${configData.data_type}" readonly="readonly"/>
					</td>
					<td>
						<form:input path="data_value" value="${configData.data_value}"/>
					</td>
					<td colspan="1" align="right">
						<form:input type="button" value="Update" path="data_id" onclick="submitForm

('updatConfigeData','updateConfigDatFormId${item.count}');"/>
						<form:input type="button" value="Delete" path="data_id" onclick="submitForm

('deleteConfigData','updateConfigDatFormId${item.count}');"/>
					</td>
				</tr>
			</form:form>
		</c:forEach>
	</c:if>
</table>
    