var nextnombre = 1;
	function AgregarNombre(){

	nextnombre++;
	document.getElementById("nombre_"+nextnombre).style.display = "initial";

	}

var nextcorreo = 1;
	function AgregarCorreo(){

	nextcorreo++;
	campo = '<input type="email" size="20" id="email_' + nextcorreo + 'name="email_' + nextcorreo + ' /></br>';
	$("#correo").append(campo);

	}



function confirmarCampos(){
	var p0 = document.getElementById("nombre_comunidad").value;
	var p1 = document.getElementById("pass_comunidad").value;
	var p2 = document.getElementById("pass_comunidad2").value;

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
	  alert("Todo esta correcto");
	  return true; 
	}

}









/*var c=2;
	function newInputPart(f1)
	{
		part = document.getElementById('part');
		var inpt = document.createElement('input');
		inpt.type="text";
		inpt.name="nombre_"+c;
		inpt.id="nombre_"+c;
		c+=1;
		document.part.appendChild(inpt);
		document.part.innerHTML+="<br/>";
	}
num=1;
	function crear(obj) {
		num++;
		fi = document.getElementById(obj); // 1
		ele = document.createElement('input'); // 5
		ele.type = 'text'; // 6
		ele.name = 'nombre_'+num; // 6
		fi.appendChild(ele); // 7
		fi.insertBefore(fi,obj);
	}
	*/