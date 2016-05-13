package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.isst.amigoinvisible.datastore.ComunidadDao;
import es.upm.isst.amigoinvisible.datastore.ComunidadDaoImpl;
import es.upm.isst.amigoinvisible.datastore.UserDao;
import es.upm.isst.amigoinvisible.datastore.UserDaoImpl;
import es.upm.isst.amigoinvisible.model.Usuario;
@SuppressWarnings("serial")
public class GuardarDeseoServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect("/index.html");
			return;
		}
		
		String userName = (String) req.getSession().getAttribute("id");
		UserDao dao = UserDaoImpl.getInstance();
		Usuario user = dao.getUserByID(userName);
		String nuevodeseo= req.getParameter("nuevodeseo");
		user.setDeseo(nuevodeseo);
		dao.updateUser(user);
		System.out.println(nuevodeseo);
		List<String> deseos = user.getDeseos();
		req.getSession().setAttribute("deseos", new ArrayList<String>(deseos));
		resp.sendRedirect("/interfazMiListaDeDeseos.jsp");
	}
}
