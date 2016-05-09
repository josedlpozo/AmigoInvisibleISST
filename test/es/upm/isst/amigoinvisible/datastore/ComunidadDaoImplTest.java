package es.upm.isst.amigoinvisible.datastore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import es.upm.isst.amigoinvisible.model.Comunidad;

public class ComunidadDaoImplTest {

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
	public void testGuardarComunidad() {
		ComunidadDao dao = ComunidadDaoImpl.getInstance();
		
		List<String> userIds = new ArrayList<>();
		for(int i = 0; i < 4; i++){
			String id = String.valueOf(System.currentTimeMillis());
			userIds.add(id);
		}
		
		String gestorId = String.valueOf(System.currentTimeMillis());
		Comunidad comunidad = new Comunidad("comunidad", gestorId, "1234", userIds);
		dao.guardarComunidad(comunidad.getNombre(), comunidad.getGestorId(), "1234", userIds, String.valueOf(System.currentTimeMillis()));
		
		assertEquals("comunidad", comunidad.getNombre());
	}

	@Test
	public void testActualizaComunidad() {
		ComunidadDao dao = ComunidadDaoImpl.getInstance();
		
		List<String> userIds = new ArrayList<>();
		for(int i = 0; i < 4; i++){
			String id = String.valueOf(System.currentTimeMillis());
			userIds.add(id);
		}
		
		String gestorId = String.valueOf(System.currentTimeMillis());
		String comunidadId = String.valueOf(System.currentTimeMillis());
		Comunidad comunidad = new Comunidad("comunidad", gestorId, "1234", userIds, comunidadId);
	
		dao.guardarComunidad(comunidad.getNombre(), comunidad.getGestorId(), "1234", userIds, comunidadId);
		userIds.add("idAdmin");
		comunidad.setUsuarios(userIds);
		dao.actualizaComunidad(comunidad);
		
		List<String> result = dao.getComunidadByName("comunidad").getUsuariosId();
		System.out.println(result.size());
		for(int i = 0; i < userIds.size(); i++){
			assertEquals(result.get(i), userIds.get(i));
		}
	}

	@Test
	public void testGetComunidadByName() {
		ComunidadDao dao = ComunidadDaoImpl.getInstance();
		
		List<String> userIds = new ArrayList<>();
		
		for(int i = 0; i < 4; i++){
			String id = String.valueOf(System.currentTimeMillis());
			userIds.add(id);
		}
		
		String gestorId = String.valueOf(System.currentTimeMillis());
		String comunidadId = String.valueOf(System.currentTimeMillis());
		Comunidad comunidad = new Comunidad("comunidad", gestorId, "1234", userIds, comunidadId);
		Comunidad comunidad2 = new Comunidad("comunidad2", gestorId, "1234", userIds, comunidadId);
	
		dao.guardarComunidad(comunidad.getNombre(), comunidad.getGestorId(), "1234", userIds, comunidadId);
		
		Comunidad result = dao.getComunidadByName("comunidad");
		
		assertEquals(result.getGestorId(), gestorId);
		
		dao.guardarComunidad(comunidad2.getNombre(), comunidad2.getGestorId(), "1234", userIds, comunidadId);
		
		Comunidad result2 = dao.getComunidadByName("comunidad");
		Comunidad result3 = dao.getComunidadByName("comunidad2");
		
		assertNull(result2);
		assertEquals(gestorId, result3.getGestorId());
	}

	@Test
	public void testGetComunidadesByUser() {
		ComunidadDao dao = ComunidadDaoImpl.getInstance();
		
		List<String> userIds = new ArrayList<>();
		String userId1 = "admin";
		userIds.add(userId1);
		for(int i = 0; i < 4; i++){
			String id = String.valueOf(System.currentTimeMillis());
			userIds.add(id);
		}
		
		String gestorId = String.valueOf(System.currentTimeMillis());
		String comunidadId = String.valueOf(System.currentTimeMillis());
		Comunidad comunidad = new Comunidad("comunidad", gestorId, "1234", userIds, comunidadId);
	
		dao.guardarComunidad(comunidad.getNombre(), comunidad.getGestorId(), "1234", userIds, comunidadId);
		List<Comunidad> result = dao.getComunidadesByUser(userId1);
		
		assertEquals(result.size(), 1);
		
		String gestorId2 = String.valueOf(System.currentTimeMillis());
		String comunidadId2 = String.valueOf(System.currentTimeMillis());
		Comunidad comunidad2 = new Comunidad("comunidad2", gestorId2, "1234", userIds, comunidadId2);
	
		dao.guardarComunidad(comunidad2.getNombre(), comunidad2.getGestorId(), "1234", userIds, comunidadId2);
		List<Comunidad> result2 = dao.getComunidadesByUser(userId1);
		assertEquals(result2.size(), 2);
	}


}
