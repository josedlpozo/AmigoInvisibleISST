package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.upm.isst.amigoinvisible.datastore.ComunidadDao;
import es.upm.isst.amigoinvisible.datastore.ComunidadDaoImpl;
import es.upm.isst.amigoinvisible.model.Comunidad;

public class MiListaDeseos extends HttpServlet {
	public List<String> deseos=null;
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		
		String des = (String) req.getSession().getAttribute("deseos");
		if(des!=null){

		String pagina="https://www.amazon.es/s/ref=nb_sb_noss_2?__mk_es_ES=ÅMÅŽÕÑ&url=search-alias%3Daps&field-keywords=";


		String pagina2=pagina+des;
		deseos.add(pagina2);
		
		}
		
		
		Iterator iter = deseos.iterator();
		while (iter.hasNext()){
		  System.out.println(iter.next());
		resp.getWriter().println(deseos);
		}
		
	resp.sendRedirect("/interfazMiListaDeDeseos.jsp");

}
	
		
		
	
	}
	



