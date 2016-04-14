package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.*;
import es.upm.isst.amigoinvisible.datastore.UserDao;
import es.upm.isst.amigoinvisible.datastore.UserDaoImpl;
import es.upm.isst.amigoinvisible.model.Usuario;

@SuppressWarnings("serial")
public class RegisterUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		UserDao dao = UserDaoImpl.getInstance();
		String userName = req.getParameter("username");
		System.out.println(userName);
		if(dao.getUserByName(userName) == null){
			String password1 = req.getParameter("password");
			String password2 = req.getParameter("password2");
			if(password1.equals(password2)){
				Random random = new Random();
				String userId = new BigInteger(130, random).toString(32);
				System.out.println("Register "+userName);
				req.getSession().setAttribute("user", userName);
				req.getSession().setAttribute("id", userId);
				dao.saveUserWithPassword(userName, req.getParameter("email"), password1, userId);
				Message msg = new MimeMessage(Session.getDefaultInstance(new Properties(), null));
				try {
					msg.setFrom(new InternetAddress("amigo@amigoinvisibleisst.appspotmail.com", "Sistema de registro Amigo Invisible"));
					msg.addRecipient(Message.RecipientType.TO,  new InternetAddress(req.getParameter("email"), "Registro AMIGO INVISIBLE"));
					msg.setSubject("Bienvenido a la aplicación de Amigo Invisible.");
					msg.setText("Bienvenido "+userName+",\n Comience a crear su comunidad para poder compartir con sus amigos. \n\n Un saludo.");
					Transport.send(msg);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				resp.sendRedirect("/comunidades");
				return;
			}
			req.getSession().setAttribute("samepasswords", "Las contrase�as introducidas son distintas.");
			resp.sendRedirect("interfazRegistro.jsp");
		}else{
			Usuario user = dao.getUserByName(userName);
			System.out.println("Already Register "+userName);
			req.getSession().setAttribute("user", user.getUsername());
			req.getSession().setAttribute("id", user.getUserId());
			if(user.getPassword().equals(req.getParameter("password"))){
				resp.sendRedirect("/comunidades");
			}else{
				req.getSession().setAttribute("error", "Usuario ya registrado, introduzca la contrase�a correctamente.");
				resp.sendRedirect("interfazRegistro.jsp");
			}

		}
	}
}
