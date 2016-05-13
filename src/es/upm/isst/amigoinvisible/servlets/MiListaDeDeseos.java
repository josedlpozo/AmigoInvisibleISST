package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.isst.amigoinvisible.datastore.ComunidadDao;
import es.upm.isst.amigoinvisible.datastore.ComunidadDaoImpl;
import es.upm.isst.amigoinvisible.datastore.UserDao;
import es.upm.isst.amigoinvisible.datastore.UserDaoImpl;
import es.upm.isst.amigoinvisible.model.Comunidad;
import es.upm.isst.amigoinvisible.model.Usuario;

public class MiListaDeDeseos extends HttpServlet{
	@SuppressWarnings("null")
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect("/index.html");
			return;
		}
		
		String userName = (String) req.getSession().getAttribute("id");
		UserDao dao = UserDaoImpl.getInstance();
		Usuario user = dao.getUserByName(userName);
		String amazon = "https://www.amazon.es/s/ref=nb_sb_noss_2?__mk_es_ES=ÅMÅŽÕÑ&url=search-alias%3Daps&field-keywords=";
		List<String> deseos = user.getDeseos();
		List<String> enlaces = null;
		if(!deseos.isEmpty() && deseos != null){
			for (String i: deseos) {
					enlaces.add(amazon+i);
			}
		}
		req.getSession().setAttribute("deseos", new ArrayList<String>(deseos));
		
		resp.sendRedirect("/interfazMiListaDeDeseos.jsp");
	}

}
