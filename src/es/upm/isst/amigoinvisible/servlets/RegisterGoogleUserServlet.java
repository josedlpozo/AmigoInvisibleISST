package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class RegisterGoogleUserServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String userId = "";
		String user = "";
		resp.setContentType("text/html");
		if(req.getUserPrincipal() != null){
			user = req.getUserPrincipal().getName();
			userId = userService.getCurrentUser().getUserId();
			req.getSession().setAttribute("user", user);
			req.getSession().setAttribute("userId", userId);
			resp.sendRedirect("/interfazMiComunidad.jsp");
			return;
		}
		
		resp.sendRedirect(url);
	}

}
