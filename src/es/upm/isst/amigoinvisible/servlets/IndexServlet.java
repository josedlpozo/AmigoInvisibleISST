package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		System.out.println("ENTRA");
		if(req.getSession().getAttribute("user") != null){
			resp.sendRedirect("/comunidades");
			return;
		}else{
			resp.sendRedirect("/index.html");
			return;
		}
	}
}
