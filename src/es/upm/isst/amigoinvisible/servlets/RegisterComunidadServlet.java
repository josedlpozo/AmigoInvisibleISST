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

public class RegisterComunidadServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		UserDao userDao = UserDaoImpl.getInstance();
		ComunidadDao comunidadDao = ComunidadDaoImpl.getInstance();
		
		String comunidadName = req.getParameter("nombre_comunidad");
		String password = req.getParameter("pass_comunidad");
		String password2 = req.getParameter("pass_comunidad2");
		
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect("/index.html");
			return;
		}
		
		Usuario gestor = userDao.getUserByName(req.getSession().getAttribute("user").toString());
		String gestorId = req.getSession().getAttribute("id").toString();
		List<String> users = new ArrayList<>();
		int num = 1;
		while(!req.getParameter("nombre_"+num).toString().isEmpty()){
			Usuario user = userDao.getUserByEmail(req.getParameter("nombre_"+num));
			if(user != null){	
				users.add(user.getUserId());
			}else{
				String email = req.getParameter("nombre_"+num);
				System.out.println(email);
				int index = email.indexOf("@");
				String userName = email.substring(0, index);
				char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
				StringBuilder sb = new StringBuilder();
				Random random = new Random();
				for (int i = 0; i < 8; i++) {
				    char c = chars[random.nextInt(chars.length)];
				    sb.append(c);
				}
				String pass = sb.toString();
				String userId = ""+System.currentTimeMillis();
				userDao.saveUserWithPassword(userName, email, pass, userId);
				
				Message msg = new MimeMessage(Session.getDefaultInstance(new Properties(), null));
				try {
					msg.setFrom(new InternetAddress("amigo@amigoinvisibleisst.appspotmail.com", "Sistema de registro Amigo Invisible"));
					msg.addRecipient(Message.RecipientType.TO,  new InternetAddress(email, "Registro AMIGO INVISIBLE"));
					msg.setSubject("Bienvenido a la aplicación de Amigo Invisible.");
					msg.setText("Bienvenido "+userName+",\nSu amigo "+gestor.getUsername()+" le ha añadido a la comunidad "+comunidadName+"\n. Puede acceder a la aplicación con las siguientes credenciales:\n\nNombre de usuario:"+userName+"\nContraseña:"+pass+"\n\nEsta contraseña podrá cambiarla. \n\n Un saludo.");
					Transport.send(msg);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				users.add(userId);
			}
			num++;
		}
		String comunidadId = ""+System.currentTimeMillis();
		comunidadDao.guardarComunidad(comunidadName, gestorId, password, users, comunidadId);
		resp.sendRedirect("/interfazMiComunidad.jsp");
	}
}
