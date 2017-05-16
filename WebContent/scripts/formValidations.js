function resertLocErrors(){
	document.getElementById("locIdErr").innerHTML="";	
	document.getElementById("locNameErr").innerHTML="";	
	document.getElementById("locTypeErr").innerHTML="";	
}
function validateLoc(){
	var exp1=/^[1-9][0-9]*$/;
	var exp2=/^[A-Z]{3,6}$/;
	resertLocErrors();
	if(!(document.locForm.locId.value.match(exp1))){
		document.getElementById("locIdErr").innerHTML=" *Id is not valid";
		return false;
	}
	if(!(document.locForm.locName.value.match(exp2))){
		document.getElementById("locNameErr").innerHTML=" * name is not valid";
		return false;
	}
	if(document.locForm.locType[0].checked==false && document.locForm.locType[1].checked==false){
		document.getElementById("locTypeErr").innerHTML=" Choose any one type";
		return false;
	}
	return true;
}
function validateVenForm(){
	//define exp
	var idexp=/^[1-9][0-9]*$/;
	var nameexp=/^[A-Z]{3,8}$/;
	var emailexp=/^[A-Za-z0-9\_\-\.]+\@[A-Za-z]{3,9}\.[a-z\.]{2,6}$/;
	var flag= true;
	document.getElementById("venIdErr").innerHTML="";
	document.getElementById("venNameErr").innerHTML="";
	document.getElementById("venEmailErr").innerHTML="";
	document.getElementById("locErr").innerHTML="";
	
	if(!(document.venForm.venId.value.match(idexp))){
		document.getElementById("venIdErr").innerHTML=" Invalid Id details";
		flag=false;
	}
	if(!(document.venForm.venName.value.match(nameexp))){
		document.getElementById("venNameErr").innerHTML=" Invalid Name";
		flag=false;
	}
	if(!(document.venForm.venEmail.value.match(emailexp))){
		document.getElementById("venEmailErr").innerHTML=" Invalid EmailId";
		flag=false;
	}
	if(document.getElementById("locInp").value==-1){
		document.getElementById("locErr").innerHTML=" please select one location";
		flag=false;
	}
	return flag;
}