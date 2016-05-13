package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.java.swing.plaf.windows.resources.windows;

import es.upm.isst.amigoinvisible.datastore.UserDao;
import es.upm.isst.amigoinvisible.datastore.UserDaoImpl;
import es.upm.isst.amigoinvisible.model.Comunidad;
import es.upm.isst.amigoinvisible.model.Usuario;

public class AmazonServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect("/index.html");
			return;
		}
		
		String userName = (String) req.getSession().getAttribute("id");
		UserDao dao = UserDaoImpl.getInstance();
		Usuario user = dao.getUserByID(userName);
		String amazon = "http://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Daps&field-keywords=";
		List<String> deseos = new ArrayList();
		deseos=user.getDeseos();
		String direccion = "/interfazMiListaDeDeseos.jsp";
		for (String i: deseos) {
			if (req.getParameter(i) != null) {
				direccion=amazon+i;
			}
		}
		req.getSession().setAttribute("deseos", new ArrayList<String>(deseos));
		if (direccion.equals("/interfazMiListaDeDeseos.jsp")||direccion.equals("/interfazTuListaDeDeseos.jsp")){
		resp.sendRedirect(direccion);
		System.out.println("Dentro del if");
		}
		else{
			System.out.println("dentro del else");
			resp.sendRedirect(direccion);
			
			
		}
	}

}
