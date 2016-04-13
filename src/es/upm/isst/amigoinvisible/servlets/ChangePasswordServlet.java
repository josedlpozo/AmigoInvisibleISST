package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.isst.amigoinvisible.datastore.UserDao;
import es.upm.isst.amigoinvisible.datastore.UserDaoImpl;
import es.upm.isst.amigoinvisible.model.Usuario;

@SuppressWarnings("serial")
public class ChangePasswordServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		UserDao dao = UserDaoImpl.getInstance();
		String userName = req.getSession().getAttribute("user").toString();
		//String userName = req.getSession().getUser();
		//String passwordOriginal = req.getUserByName(userName).getPassword();
		if(dao.getUserByName(userName) != null){
			//String passwordOriginal = dao.getUserByName(userName).getPassword().toString();
			System.out.println("Contrase�a antigua del html" + req.getParameter("oldpassword"));
			System.out.println("Contrase�a antigua de la BD" +dao.getUserByName(userName).getPassword());
			System.out.println("Contrase�a nueva del html" +req.getParameter("password"));
			System.out.println("Confirmacion de contrase�a nueva del html" +req.getParameter("confpassword"));
			if(req.getParameter("oldpassword").equals(dao.getUserByName(userName).getPassword()) && 
					req.getParameter("password").equals(req.getParameter("confpassword"))){
				req.getSession().setAttribute("password", req.getParameter("password"));
				Usuario user = dao.getUserByName(userName);
				user.setPassword(req.getParameter("confpassword"));
				dao.updateUser(user);
				//req.getSession().setAttribute("id", dao.getUserByName(userName).getUserId());
				resp.sendRedirect("/interfazMiComunidad.jsp");
				return;
			}else{
				req.getSession().setAttribute("confPassword", "La contrase�a introducida es incorrecta o las contrase�as no coinciden");
				resp.sendRedirect("interfazCambioContrase�a.jsp");
				return;
			}
		}
		req.getSession().setAttribute("usernameNoExiste", "No existe usuario registrado con ese nombre");
		resp.sendRedirect("interfazLogin.jsp");
	}
}