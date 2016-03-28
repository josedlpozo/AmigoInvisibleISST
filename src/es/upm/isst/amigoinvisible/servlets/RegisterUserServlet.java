package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.*;

import es.upm.isst.amigoinvisible.datastore.PersistenceManager;
import es.upm.isst.amigoinvisible.datastore.RegisterUserDao;
import es.upm.isst.amigoinvisible.model.Usuario;
import es.upm.isst.amigoinvisible.presenter.RegisterPresenter;

@SuppressWarnings("serial")
public class RegisterUserServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("transactions-optional");
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("select p from Usuario p");
		System.out.println("hola");
        ArrayList<Usuario> users = new ArrayList(q.getResultList());
        System.out.println(users.size());
        for(Usuario u : users){
        	System.out.println(u.getNombre());
        }
	}
	
	public void doPost(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("transactions-optional");
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("select p from Usuario p");
        ArrayList<Usuario> users = new ArrayList(q.getResultList());
        for(Usuario u : users){
        	System.out.println(u.getNombre());
        }
		
		RegisterUserDao registerUserDao = new RegisterUserDao();
		RegisterPresenter presenter = new RegisterPresenter(registerUserDao);
		//presenter.setServlet(this);
		
		resp.setContentType("text/plain");
		String name = req.getParameter("name");
		String surname = req.getParameter("lastname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		Usuario user = new Usuario(name, surname, username, password, email);
		
		presenter.register(user, new RegisterPresenter.Callback() {
			
			@Override
			public void userSaved() {
				try {
					resp.getWriter().println("User saved");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		System.out.println(req.getParameter("name"));
	}
	
	
	
	
}
