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

public class ComunidadesServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect("/index.html");
			return;
		}
		
		String userName = (String) req.getSession().getAttribute("id");
		
		ComunidadDao dao = ComunidadDaoImpl.getInstance();
		List<Comunidad> comunidades = dao.getComunidadesByUser(userName);
		for(Comunidad c : comunidades){
			System.out.println(c.getNombre());
		}
		req.getSession().setAttribute("comunidades", new ArrayList<Comunidad>(comunidades));
		System.out.println("comunidades");
		resp.sendRedirect("/interfazMisComunidades.jsp");

	}

}
