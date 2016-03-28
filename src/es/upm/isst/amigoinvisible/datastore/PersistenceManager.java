package es.upm.isst.amigoinvisible.datastore;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	
  private static final EntityManagerFactory emfInstance = Persistence
	      .createEntityManagerFactory("transactions-optional");

  private PersistenceManager() {	  }

  public static EntityManagerFactory get() {
	   return emfInstance;
	 }
} 
