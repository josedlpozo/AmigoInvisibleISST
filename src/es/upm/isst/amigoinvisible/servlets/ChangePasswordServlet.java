package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.isst.amigoinvisible.datastore.UserDao;
import es.upm.isst.amigoinvisible.datastore.UserDaoImpl;

@SuppressWarnings("serial")
public class ChangePasswordServlet extends HttpServlet {
	public void changePassword(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		UserDao dao = UserDaoImpl.getInstance();
		String userName = req.getSession().getAttribute("user");
		//String userName = req.getSession().getUser();
		//String passwordOriginal = req.getUserByName(userName).getPassword();
		if(dao.getUserByName(userName) != null){
			String passwordOriginal = req.getUserByName(userName).getPassword();
			System.out.println(req.getParameter("oldpassword"));
			System.out.println(dao.getUserByName(userName).getPassword());
			if(req.getParameter("oldpassword").equals(dao.getUserByName(userName).getPassword()) && 
					req.getParameter("password").equals(req.getParameter("confpassword"))){
				req.getSession().setAttribute("password", req.getParameter("password"));
				//req.getSession().setAttribute("id", dao.getUserByName(userName).getUserId());
				resp.sendRedirect("/interfazMiComunidad.jsp");
				return;
			}else{
				req.getSession().setAttribute("confPassword", "La contraseña introducida es incorrecta o las contraseñas no coinciden");
				resp.sendRedirect("interfazCambioContraseña.jsp");
				return;
			}
		}
		req.getSession().setAttribute("usernameNoExiste", "No existe usuario registrado con ese nombre");
		resp.sendRedirect("interfazLogin.jsp");
	}
}