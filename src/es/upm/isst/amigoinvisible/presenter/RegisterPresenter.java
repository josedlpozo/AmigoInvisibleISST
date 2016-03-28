package es.upm.isst.amigoinvisible.presenter;

import es.upm.isst.amigoinvisible.datastore.RegisterUserDao;
import es.upm.isst.amigoinvisible.model.Usuario;
import es.upm.isst.amigoinvisible.servlets.RegisterUserServlet;

public class RegisterPresenter {
	
	private RegisterUserDao registerUserDao;
	//private RegisterUserServlet registerUserServlet;
	
	public RegisterPresenter(RegisterUserDao registerUserDao){
		this.registerUserDao = registerUserDao;
	}
	
	/*public void setServlet(RegisterUserServlet registerUserServlet){
		this.registerUserServlet = registerUserServlet;
	}*/
	
	public void register(Usuario user, final Callback callback){
		registerUserDao.addUser(user, new RegisterUserDao.Callback() {
			
			@Override
			public void onUserSaved(Usuario professor) {
				callback.userSaved();
			}
		});
	}
	
	public interface Callback{
		void userSaved();
	}

}
