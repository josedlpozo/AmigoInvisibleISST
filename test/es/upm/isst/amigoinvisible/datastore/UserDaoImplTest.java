package es.upm.isst.amigoinvisible.datastore;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import es.upm.isst.amigoinvisible.model.Usuario;

public class UserDaoImplTest {
	
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
	public void testSaveUser() {
		UserDao dao = UserDaoImpl.getInstance();
		Usuario user = new Usuario("admin", "admin@admin.com", String.valueOf(System.currentTimeMillis()));
		dao.saveUser(user.getUsername(), user.getEmail(), user.getUserId());
		
		Usuario user2 = new Usuario("admin", "admin2@admin.com", String.valueOf(System.currentTimeMillis()));
		dao.saveUser(user2.getUsername(), user2.getEmail(), user2.getUserId());
		
		
		assertEquals("admin", user.getUsername());
		assertEquals("admin@admin.com", user.getEmail());
	}

	@Test
	public void testGetUserByName() {
		UserDao dao = UserDaoImpl.getInstance();
		
		Usuario user = new Usuario("admin", "admin@admin.com", String.valueOf(System.currentTimeMillis()));
		dao.saveUser(user.getUsername(), user.getEmail(), user.getUserId());
		Usuario user2 = new Usuario("admin2", "admin@admin.com", String.valueOf(System.currentTimeMillis()));
		dao.saveUser(user2.getUsername(), user2.getEmail(), user2.getUserId());
		
		String userId3 = String.valueOf(System.currentTimeMillis());
		Usuario user3 = new Usuario("admin3", "admin@admin.com", userId3);
		Usuario user4 = new Usuario("admin4", "admin@admin.com", userId3);
		dao.saveUser(user3.getUsername(), user3.getEmail(), user3.getUserId());
		dao.saveUser(user4.getUsername(), user4.getEmail(), user4.getUserId());
		
		Usuario result = dao.getUserByName("admin");
		Usuario result2 = dao.getUserByName("admin2");
		Usuario result3 = dao.getUserByName("admin3");
		Usuario result4 = dao.getUserByName("admin4");
		
		assertEquals("admin@admin.com", result.getEmail());
		assertEquals("admin@admin.com", result2.getEmail());
		assertEquals("admin2", result2.getUsername());
		assertNull(result3);
		assertEquals("admin4", result4.getUsername());
	}

	@Test
	public void testSaveUserWithPassword() {
		UserDao dao = UserDaoImpl.getInstance();
		Usuario user = new Usuario("admin", "admin@admin.com", "admin1234", ""+System.currentTimeMillis());
		dao.saveUserWithPassword(user.getUsername(), user.getEmail(), user.getPassword(), user.getUserId());
		
		assertEquals("admin", user.getUsername());
	}

	@Test
	public void testGetUserByEmail() {
		UserDao dao = UserDaoImpl.getInstance();
		
		Usuario user = new Usuario("admin", "admin@admin.com", String.valueOf(System.currentTimeMillis()));
		dao.saveUser(user.getUsername(), user.getEmail(), user.getUserId());
		Usuario user2 = new Usuario("admin2", "admin2@admin.com", String.valueOf(System.currentTimeMillis()));
		dao.saveUser(user2.getUsername(), user2.getEmail(), user2.getUserId());
		
		String userId3 = String.valueOf(System.currentTimeMillis());
		Usuario user3 = new Usuario("admin3", "admin3@admin.com", userId3);
		Usuario user4 = new Usuario("admin4", "admin4@admin.com", userId3);
		dao.saveUser(user3.getUsername(), user3.getEmail(), user3.getUserId());
		dao.saveUser(user4.getUsername(), user4.getEmail(), user4.getUserId());
		
		Usuario result = dao.getUserByEmail("admin@admin.com");
		Usuario result2 = dao.getUserByEmail("admin2@admin.com");
		Usuario result3 = dao.getUserByEmail("admin3@admin.com");
		Usuario result4 = dao.getUserByEmail("admin4@admin.com");
		
		assertEquals("admin@admin.com", result.getEmail());
		assertEquals("admin2@admin.com", result2.getEmail());
		assertEquals("admin2", result2.getUsername());
		assertNull(result3);
		assertEquals("admin4", result4.getUsername());
	}

	@Test
	public void testUpdateUser() {
		UserDao dao = UserDaoImpl.getInstance();
	
		String userId = String.valueOf(System.currentTimeMillis());
		String userId2 = String.valueOf(System.currentTimeMillis());
		Usuario user = new Usuario("admin", "admin3@admin.com", userId);
		Usuario user2 = new Usuario("admin2", "admin4@admin.com", userId2);
		dao.saveUser(user.getUsername(), user.getEmail(), user.getUserId());
		dao.saveUser(user2.getUsername(), user2.getEmail(), user2.getUserId());
		
		user2.setId(userId);
		dao.updateUser(user2);
		
		Usuario result = dao.getUserByName("admin");
		Usuario result2 = dao.getUserByName("admin2");
		
		assertNull(result);
		assertEquals("admin2", result2.getUsername());
		
		user.setId(userId);
		dao.updateUser(user);
		
		Usuario result3 = dao.getUserByName("admin");
		
		assertEquals("admin", result3.getUsername());
	}

	@Test
	public void testGetUserByID() {
		UserDao dao = UserDaoImpl.getInstance();
		
		String id = String.valueOf(System.currentTimeMillis());
		Usuario user = new Usuario("admin", "admin@admin.com", id);
		dao.saveUser(user.getUsername(), user.getEmail(), user.getUserId());
		String id2 = String.valueOf(System.currentTimeMillis());
		Usuario user2 = new Usuario("admin2", "admin2@admin.com", id2);
		dao.saveUser(user2.getUsername(), user2.getEmail(), user2.getUserId());
		
		String userId3 = String.valueOf(System.currentTimeMillis());
		Usuario user3 = new Usuario("admin3", "admin3@admin.com", userId3);
		Usuario user4 = new Usuario("admin4", "admin4@admin.com", userId3);
		dao.saveUser(user3.getUsername(), user3.getEmail(), user3.getUserId());
		dao.saveUser(user4.getUsername(), user4.getEmail(), user4.getUserId());
		
		Usuario result = dao.getUserByID(userId3);
		Usuario result2 = dao.getUserByEmail("admin3@admin.com");
		Usuario result3 = dao.getUserByID(id);
		Usuario result4 = dao.getUserByID(id2);
		
		assertEquals("admin4", result.getUsername());
		assertNull(result2);
		assertEquals("admin@admin.com", result3.getEmail());
		assertEquals("admin2", result4.getUsername());
	}

}
