
function confirmarCampos(){
	var p0 = document.getElementById("oldpassword").value;
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
	} //AQUI DEBERIAMOS COMPROBAR LA ANTIGUA CONTRASEÑA PARA CAMBIARLA CON LA NUEVA
	// if (p0.length < 6){
	// 	alert("El nombre de la comunidad debe tener al menos 6 carácteres")
	// 	return false;
	// }
	else {
	  alert("Todo esta correcto");
	  
	  return true; 
	}

}
