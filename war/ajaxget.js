function ajaxget(){
	var conexion;
	if(window.XML.HttpRequest){
		conexion=new XML.HttpRequest();
	}else{
		conexion= new ActiveXObject("Microsoft.XMLHTTP");
	}
	conexion.onreadystatechange=function(){
        if(xmlHttp.readyState== 4 && xmlHttp.readyState != null){
        	document.getElementById("actualizar").innerHTML=conexion.responseText;
        }
	}
	conexion.open("GET","proceso.php?variable=PRUEBA",true);
    conexion.send(null);
}