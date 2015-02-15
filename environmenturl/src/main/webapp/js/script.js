function submitForm(intendedAction, formId){
	if(intendedAction == 'updateTomcatData'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'updateTomcatData';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'deleteTomcatData'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'deleteTomcatData';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'addTomcatData'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'addTomcatData';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'updateURLData'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'updateURLData';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'deleteURLData'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'deleteURLData';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'addURLData'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'addURLData';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'updatConfigeData'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'updateData';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'deleteConfigData'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'deleteData';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'addConfigData'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'addData';
			document.getElementById(formId).submit();
		}
	}
	else if(intendedAction == 'updatDatbaseCredential'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'updateData';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'deleteDatbaseCredential'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'deleteData';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'addDatabaseCredential'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'addData';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'getmsisdndetail'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'showmsisdndetail';
			document.getElementById(formId).submit();
		}
	}
	
	else if(intendedAction == 'upload'){
		if(document.getElementById(formId) != null){
			document.getElementById(formId).action = 'upload';
			document.getElementById(formId).submit();
		}
	}
}



var xmlhttp;
window.onload= function(){
	xmlhttp = new XMLHttpRequest();
	
	$(document).ready(function(){

	  $(".showdetail tr:even").css("background-color","#c1dad7");
	  $(".showdetail tr:odd").css("background-color","#fff");
});

$(function() {
		$(".showdetail").dataTable();
	});
	
};

	function makeRequest(tomcatId) {
			xmlhttp.onreadystatechange = callback(xmlhttp);
			xmlhttp.open("GET", "fetchTomcatInfo?tomcatId="+tomcatId, true);
			xmlhttp.send();
	}
	
	function callback(xmlhttp) {
		if (xmlhttp.readyState === 4) {
			if (xmlhttp.status === 200) {
				alert(xmlhttp.responseText.toString());
			} else {
				alert('There was a problem with the request.');
			}
		}
	}
