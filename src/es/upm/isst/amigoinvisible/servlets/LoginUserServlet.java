package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.isst.amigoinvisible.datastore.UserDao;
import es.upm.isst.amigoinvisible.datastore.UserDaoImpl;

@SuppressWarnings("serial")
public class LoginUserServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		UserDao dao = UserDaoImpl.getInstance();
		String userName = req.getParameter("name");
		if(dao.getUserByName(userName) != null){
			if(req.getParameter("password").equals(dao.getUserByName(userName).getPassword())){
				req.getSession().setAttribute("user", userName);
				req.getSession().setAttribute("id", dao.getUserByName(userName).getUserId());
				req.getSession().setAttribute("user_email", dao.getUserByName(userName).getEmail());
				resp.sendRedirect("/comunidades");
				return;
			}else{
				req.getSession().setAttribute("password", "La contrase�a introducida es incorrecta");
				resp.sendRedirect("interfazLogin.jsp");
				return;
			}
		}
		req.getSession().setAttribute("usernameNoExiste", "No existe usuario registrado con ese nombre");
		resp.sendRedirect("interfazLogin.jsp");
	}
}
