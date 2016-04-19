package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveSessionServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		req.getSession().removeAttribute("user");
		req.getSession().removeAttribute("id");
		req.getSession().removeAttribute("user_email");
		
		
		resp.sendRedirect("/index.html");
		return;
	}

}
