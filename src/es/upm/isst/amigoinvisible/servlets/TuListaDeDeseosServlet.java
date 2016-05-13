package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.isst.amigoinvisible.datastore.ComunidadDao;
import es.upm.isst.amigoinvisible.datastore.ComunidadDaoImpl;
import es.upm.isst.amigoinvisible.model.Comunidad;
import es.upm.isst.amigoinvisible.model.Usuario;

public class TuListaDeDeseosServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		List<String> deseosAjenos =new ArrayList<>();

		deseosAjenos.add("coche");
		deseosAjenos.add("avion");
		deseosAjenos.add("pc");
		//String dir ="https://www.amazon.es/s/ref=nb_sb_noss?__mk_es_ES=ÅMÅŽÕÑ&url=search-alias%3Daps&field-keywords="+deseosAjenos.get(0);
		//req.getSession().setAttribute("dire", new String(dir));
		req.getSession().setAttribute("deseosAjenos", new ArrayList<String>(deseosAjenos));

		resp.sendRedirect("/interfazTuListaDeDeseos.jsp");
	}



	
}
