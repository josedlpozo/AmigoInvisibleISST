package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.isst.amigoinvisible.datastore.UserDao;
import es.upm.isst.amigoinvisible.datastore.UserDaoImpl;

@SuppressWarnings("serial")
public class RegisterGoogleUserServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		UserDao dao = UserDaoImpl.getInstance();
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String userId = "";
		String user = "";
		resp.setContentType("text/html");
		if(req.getUserPrincipal() != null){
			user = req.getUserPrincipal().getName();
			userId = userService.getCurrentUser().getUserId();
			req.getSession().setAttribute("user", user);
			req.getSession().setAttribute("id", userId);
			req.getSession().setAttribute("user_email", userService.getCurrentUser().getEmail());
			List<String> deseos= new ArrayList();
			dao.saveUserWithPassword(user, userService.getCurrentUser().getEmail(), "", userId, deseos);
			Message msg = new MimeMessage(Session.getDefaultInstance(new Properties(), null));
			try {
				msg.setFrom(new InternetAddress("amigo@amigoinvisibleisst.appspotmail.com", "Sistema de registro Amigo Invisible"));
				msg.addRecipient(Message.RecipientType.TO,  new InternetAddress(userService.getCurrentUser().getEmail(), "Registro AMIGO INVISIBLE"));
				msg.setSubject("Bienvenido a la aplicación de Amigo Invisible.");
				msg.setText("Bienvenido "+user+",\n Comience a crear su comunidad para poder compartir con sus amigos. \n\n Un saludo.");
				Transport.send(msg);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			resp.sendRedirect("/interfazmiscomunidades.html");
			return;
		}
		
		resp.sendRedirect(url);
	}

}
