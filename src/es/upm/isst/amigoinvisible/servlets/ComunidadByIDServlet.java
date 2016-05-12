package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.isst.amigoinvisible.datastore.ComunidadDao;
import es.upm.isst.amigoinvisible.datastore.ComunidadDaoImpl;
import es.upm.isst.amigoinvisible.datastore.MensajesDao;
import es.upm.isst.amigoinvisible.datastore.MensajesDaoImpl;
import es.upm.isst.amigoinvisible.datastore.UserDao;
import es.upm.isst.amigoinvisible.datastore.UserDaoImpl;
import es.upm.isst.amigoinvisible.model.Comunidad;
import es.upm.isst.amigoinvisible.model.Mensaje;
import es.upm.isst.amigoinvisible.model.Usuario;

@SuppressWarnings("serial")
public class ComunidadByIDServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		ComunidadDao comunidaddao = ComunidadDaoImpl.getInstance();
		MensajesDao mensajesdao = MensajesDaoImpl.getInstance();
		String userName = (String) req.getSession().getAttribute("user");
		UserDao userdao = UserDaoImpl.getInstance();
		Usuario user = userdao.getUserByName(userName);
		
		Comunidad comunidad = comunidaddao.getComunidadByID((String) req.getSession().getAttribute("comunidadId"));
		
		if (comunidad == null){
			req.getSession().setAttribute("nombrecomunidad", "Prueba");
		}
		else{
			req.getSession().setAttribute("nombrecomunidad", comunidad.getNombre());
		}

		if(user.getUserId().equals(comunidad.getGestorId())){
			req.getSession().setAttribute("gestor", true);
		}else{
			req.getSession().setAttribute("gestor", false);
		}
		
		
		List<Mensaje> mensajes = mensajesdao.getMensajesByComunidadID(comunidad.getComunidadId());
		Collections.reverse(mensajes);
		req.getSession().setAttribute("mensajes", new ArrayList<>(mensajes));
		
		if(comunidad.getSorteo() != null){
			Usuario usuarioARegalar = userdao.getUserByID(comunidad.getSorteo().get(user.getUserId()));
			if(comunidad.getSorteo().isEmpty() || usuarioARegalar == null){
				req.getSession().setAttribute("sorteo", "Aún no se ha realizado ningún sorteo");
			}else{
				req.getSession().setAttribute("sorteo", usuarioARegalar.getUsername());
			}
		}
		
		resp.sendRedirect("/interfazMiComunidad.jsp");
	}
}
