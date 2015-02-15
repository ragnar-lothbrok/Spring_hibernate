<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<h1>Upload Multiple Files</h1>
<div id="login-box">
	<form:form  action="upload" id="uploadFileForm" modelAttribute="fileUpload" method="POST" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>File To Upload : </td>
				<td><form:input path="CSVFile" type="file"/></td>
			</tr>
			
			<tr>
				<td>Submit File :    </td>
				<td colspan="2"><form:input path="savedpath" type="button" class="submit_button" value="Upload File"
				onclick="submitForm('upload','uploadFileForm');"/></td>
			</tr>
		</table>
	</form:form>
</div>
<!-- <h1>Upload Multiple Files</h1>

<form method="POST" action="uploadMultipleFile"
	enctype="multipart/form-data">
	File1 to upload: <input type="file" name="file"><br /> Name1:
	<input type="text" name="name"><br /> <br /> File2 to upload:
	<input type="file" name="file"><br /> Name2: <input
		type="text" name="name"><br /> <br /> <input type="submit"
		value="Upload"> Press here to upload the file!
</form> -->