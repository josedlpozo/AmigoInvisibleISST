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
			System.out.println(req.getParameter("password"));
			System.out.println(dao.getUserByName(userName).getPassword());
			if(req.getParameter("password").equals(dao.getUserByName(userName).getPassword())){
				req.getSession().setAttribute("user", userName);
				req.getSession().setAttribute("id", dao.getUserByName(userName).getUserId());
				resp.sendRedirect("/interfazMiComunidad.jsp");
				return;
			}
			resp.sendRedirect("index.html");
		}
		resp.sendRedirect("index.html");
	}
}
