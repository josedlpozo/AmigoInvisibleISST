package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.isst.amigoinvisible.datastore.MensajesDao;
import es.upm.isst.amigoinvisible.datastore.MensajesDaoImpl;

public class SaveMessageServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect("/index.html");
			return;
		}
		
		MensajesDao dao = MensajesDaoImpl.getInstance();
		
		String userId = (String) req.getSession().getAttribute("id");
		String comunidadId = (String) req.getSession().getAttribute("comunidadId");
		String mensaje = req.getParameter("mensaje");

		dao.saveMensaje(userId, comunidadId, mensaje);
		
		resp.sendRedirect("/micomunidad");
	}
}
