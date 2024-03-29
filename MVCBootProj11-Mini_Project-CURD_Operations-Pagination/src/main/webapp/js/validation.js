function doValidations(frm) {

	//empty old form validation error messages
	document.getElementById("enameErr	").innerHTML = "";
	document.getElementById("jobErr").innerHTML = "";
	document.getElementById("salErr").innerHTML = "";
	document.getElementById("deptnoErr").innerHTML = "";

	//read form component values
	let name = frm.ename.value;
	let desg = frm.job.value;
	let salary = frm.sal.value;
	let deptno = frm.deptno.value;
	let isValid = true;

	//write client side form validation logics
	alert("before name")
	if (name == "") {//required rule
		alert("null  name")
		document.getElementById("enameErr	").innerHTML = "Employee name is mandatory";
		isValid = false;
	} else if (name.length < 5 || name.legnth > 20) {//length rule
		alert("insufficient length name")
		document.getElementById("enameErr	").innerHTML = "Employee name must be in range of 5 to 20 letters";
		isValid = false;
	}
	alert("after name")
	if (desg == "") {//required rule
		document.getElementById("jobErr").innerHTML = "Employee job is mandatory";
		isValid = false;
	} else if (desg.length < 5 || desg.legnth > 15) {//length rule
		document.getElementById("jobErr").innerHTML = "Employee job must be in range of 5 to 15 letters";
		isValid = false;
	}

	if (salary == "") {//required rule
		document.getElementById("salErr").innerHTML = "Employee salary is mandatory";
		isValid = false;
	} else if (salary < 1000 || salary > 10000) {//length rule
		document.getElementById("salErr").innerHTML = "Employee salary must be in range of 1000 to 10000 INR";
		isValid = false;
	} else if (isNaN(salary)) {//Numeric value
		document.getElementById("salErr").innerHTML = "Employee salary must be a number";
		isValid = false;
	}

	if (deptno == "") {//required rule
		document.getElementById("deptnoErr").innerHTML = "Employee department no is mandatory";
		isValid = false;
	}

	//change the hidden box related vflag value "yes" to indicate that client side form validations are done
	frm.vflag.value = "yes";
	return isValid;
}