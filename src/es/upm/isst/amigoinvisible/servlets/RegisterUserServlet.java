package es.upm.isst.amigoinvisible.servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import javax.servlet.http.*;
import es.upm.isst.amigoinvisible.datastore.UserDao;
import es.upm.isst.amigoinvisible.datastore.UserDaoImpl;
import es.upm.isst.amigoinvisible.model.Usuario;

@SuppressWarnings("serial")
public class RegisterUserServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, final HttpServletResponse resp) throws IOException {
		UserDao dao = UserDaoImpl.getInstance();
		String userName = req.getParameter("username");
		//System.out.println(userName);
		if(dao.getUserByName(userName) == null){
			String password1 = req.getParameter("password");
			String password2 = req.getParameter("password2");
			if(password1.equals(password2)){
				Random random = new Random();
				String userId = new BigInteger(130, random).toString(32);
				//System.out.println("Register "+userName);
				req.getSession().setAttribute("user", userName);
				req.getSession().setAttribute("userId", userId);
				dao.saveUserWithPassword(userName, req.getParameter("email"), password1, userId);
				resp.sendRedirect("/interfazMiComunidad.jsp");
				return;
			}
			req.getSession().setAttribute("samepasswords", "Las contraseñas introducidas son distintas.");
			resp.sendRedirect("interfazRegistro.jsp");
		}else{
			Usuario user = dao.getUserByName(userName);
			//System.out.println("Already Register "+userName);
			req.getSession().setAttribute("user", user.getUsername());
			req.getSession().setAttribute("userId", user.getUserId());
			if(user.getPassword().equals(req.getParameter("password"))){
				resp.sendRedirect("/interfazMiComunidad.jsp");
			}else{
				req.getSession().setAttribute("error", "Usuario ya registrado, introduzca la contraseña correctamente.");
				resp.sendRedirect("interfazRegistro.jsp");
			}
			
		}
	}
}
