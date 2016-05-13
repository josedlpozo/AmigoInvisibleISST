package es.upm.isst.amigoinvisible.servlets;



import java.io.IOException;
import java.util.ArrayList;
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
import es.upm.isst.amigoinvisible.model.Usuario;

public class TuListaDeDeseosServlet extends HttpServlet{
	@SuppressWarnings("null")
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect("/index.html");
			return;
		}
		String userName = (String) req.getSession().getAttribute("user");

		//ComunidadDao dao = ComunidadDaoImpl.getInstance();
		UserDao userdao = UserDaoImpl.getInstance();
		//MensajesDao mensajesdao = MensajesDaoImpl.getInstance();
		Usuario user = userdao.getUserByName(userName);
		//List<Comunidad> comunidades = dao.getComunidadesByUser(user.getUserId());
		Comunidad comunidad = null;
		//Usuario usuarioARegalar = userdao.getUserByID(comunidad.getSorteo().get(user.getUserId()));

		
		//String userName2 = (String) req.getSession().getAttribute("id");
		
			
			Usuario usuarioARegalar = userdao.getUserByID(comunidad.getSorteo().get(user.getUserId()));
			if(usuarioARegalar == null){
				//req.getSession().setAttribute("sorteo", "Aún no se ha realizado ningún sorteo");
				resp.sendRedirect("/interfazMiComunidad.jsp");
			}else{
				//User regalado= usuarioARegalar.getUsername();
				List<String> deseos = new ArrayList();
				deseos = usuarioARegalar.getDeseos();

				
				
				req.getSession().setAttribute("deseos", new ArrayList<String>(deseos));
				resp.sendRedirect("/interfazTuListaDeDeseos.jsp");
			}
			}
		}
		
		
		//System.out.println(user.getUsername());
		


