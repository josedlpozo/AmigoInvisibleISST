package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import es.upm.isst.amigoinvisible.model.Comunidad;
import es.upm.isst.amigoinvisible.model.Usuario;
@SuppressWarnings("serial")
public class RealizarSorteoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		if(req.getSession().getAttribute("user") == null){
			resp.sendRedirect("/index.html");
			return;
		}

		String userName = (String) req.getSession().getAttribute("user");
		ComunidadDao dao = ComunidadDaoImpl.getInstance();
		UserDao userdao = UserDaoImpl.getInstance();
		Usuario user = userdao.getUserByName(userName);
		List<Comunidad> comunidades = dao.getComunidadesByUser(user.getUserId());
		Comunidad comunidad = null;

		comunidad = dao.getComunidadByName(req.getSession().getAttribute("nombrecomunidad").toString());

		List<String> usuariosARegalar = new ArrayList<>(comunidad.getUsuariosId());
		usuariosARegalar.add(comunidad.getGestorId());

		List<String> usuariosQRegalan = new ArrayList<>(usuariosARegalar);

		HashMap<String, String> sorteo = new HashMap<>();

		for(String s : usuariosARegalar){
			System.out.println(s);
		}

		while(!usuariosARegalar.isEmpty()){
			Random r = new Random();
			int random1 = r.nextInt(usuariosARegalar.size());


			String regala = usuariosQRegalan.get(random1);

			int random2 = r.nextInt(usuariosARegalar.size());

			String regalado = usuariosARegalar.get(random2);

			if(!regalado.equals(regala)){
				sorteo.put(regala, regalado);

				usuariosQRegalan.remove(random1);
				usuariosARegalar.remove(random2);
			}
		}
		
		Iterator iter = (Iterator) sorteo.entrySet().iterator();

		while(iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
		    System.out.println(entry);
		    Usuario usuarioQRegala = userdao.getUserByID(entry.getKey().toString());
		    Usuario usuarioARegalar = userdao.getUserByID(entry.getValue().toString());
		    
		    Message msg = new MimeMessage(Session.getDefaultInstance(new Properties(), null));
			try {
				msg.setFrom(new InternetAddress("amigo@amigoinvisibleisst.appspotmail.com", "Sistema de registro Amigo Invisible"));
				msg.addRecipient(Message.RecipientType.TO,  new InternetAddress(usuarioQRegala.getEmail(), "Sorteo "+comunidad.getNombre()));
				msg.setSubject("Realizado sorteo.");
				msg.setText("Hola "+usuarioQRegala.getUsername()+"\n\nTras el sorteo, le toca regalar a "+usuarioARegalar.getUsername()+"\n\nUn saludo.");
				Transport.send(msg);
			} catch (MessagingException e) {
				e.printStackTrace();
			}

		}

		comunidad.setSorteo(sorteo);

		dao.actualizaComunidad(comunidad);
		
		Usuario usuarioARegalar = userdao.getUserByID(comunidad.getSorteo().get(user.getUserId()));
		if(comunidad.getSorteo().isEmpty() || usuarioARegalar == null){
			req.getSession().setAttribute("sorteo", "Aún no se ha realizado ningún sorteo");
		}else{
			req.getSession().setAttribute("sorteo", usuarioARegalar.getUsername());
		}
		
		resp.sendRedirect("/interfazMiComunidad.jsp");
	}
}