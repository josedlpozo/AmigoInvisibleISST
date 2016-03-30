// var nextnombre = 1;
// 	function AgregarNombre(){

// 	nextnombre++;
// 	campo = '<input type="text" size="20" id="nombre_' + nextnombre + ' name="nombre_' + nextnombre + ' /></br>';
// 	$("#part").append(campo);

// 	}

// var nextcorreo = 1;
// 	function AgregarCorreo(){

// 	nextcorreo++;
// 	campo = '<input type="email" size="20" id="email_' + nextcorreo + 'name="email_' + nextcorreo + ' /></br>';
// 	$("#correo").append(campo);

// 	}



function confirmarCampos(){
	var p0 = document.getElementById("username").value;
	var p1 = document.getElementById("password").value;
	var p2 = document.getElementById("confpassword").value;

	var espacios = false;
	var cont = 0;
	 
	while (!espacios && (cont < p1.length)) {
	  if (p1.charAt(cont) == " ")
	    espacios = true;
	  cont++;
	}
	 
	if (espacios) {
	  alert ("La contraseña no puede contener espacios en blanco");
	  return false;
	}
	if (p1 != p2) {
	  alert("Las passwords deben de coincidir");
	  return false;
	} 
	if (p0.length < 6){
		alert("El nombre de la comunidad debe tener al menos 6 carácteres")
		return false;
	}else {
	  //alert("Todo esta correcto");
	  return true; 
	}

}


