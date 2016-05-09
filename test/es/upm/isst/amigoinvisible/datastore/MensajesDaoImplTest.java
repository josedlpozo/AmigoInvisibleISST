package es.upm.isst.amigoinvisible.datastore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import es.upm.isst.amigoinvisible.model.Mensaje;

public class MensajesDaoImplTest {
	
	private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	@Before
	public void setUp() throws Exception {
		helper.setUp();
	}

	@After
	public void tearDown() throws Exception {
		helper.tearDown();
	}

	@Test
	public void testSaveMensaje() {
		MensajesDao dao = MensajesDaoImpl.getInstance();
		
		String userId = String.valueOf(System.currentTimeMillis());
		String comunidadId = "comunidad";
		Mensaje mensaje = new Mensaje(userId, comunidadId, "Esto es el primer mensaje");
		dao.saveMensaje(userId, comunidadId, mensaje.getMensaje());
		
		assertEquals(userId, mensaje.getUserId());
	}

	@Test
	public void testGetMensajesByComunidadID() {
		MensajesDao dao = MensajesDaoImpl.getInstance();
		
		String userId = String.valueOf(System.currentTimeMillis());
		String comunidadId = "comunidad";
		Mensaje mensaje = new Mensaje(userId, comunidadId, "Esto es el primer mensaje");
		dao.saveMensaje(userId, comunidadId, mensaje.getMensaje());
		
		List<Mensaje> mensajes = dao.getMensajesByComunidadID(comunidadId);
		
		assertEquals(1, mensajes.size());
		
		Mensaje mensaje2 = new Mensaje(userId, comunidadId, "Esto es el segundo mensaje");
		dao.saveMensaje(userId, comunidadId, mensaje2.getMensaje());
		
		List<Mensaje> mensajes2 = dao.getMensajesByComunidadID(comunidadId);
		assertEquals(2, mensajes2.size());
		for(Mensaje m : mensajes2){
			assertEquals(userId, m.getUserId());
			assertEquals(comunidadId, m.getComunidadId());
		}
		
		assertEquals("Esto es el primer mensaje", mensajes2.get(0).getMensaje());
		assertEquals("Esto es el segundo mensaje", mensajes2.get(1).getMensaje());
	}

}
