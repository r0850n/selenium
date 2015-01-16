import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;






import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import robert.Vaadinjpa.domain.Person;

import com.vaadin.addon.jpacontainer.JPAContainerFactory;

import components.SenderData;
import components.Tabela;


public class PersonTest {
	
	private static EntityManager em = null;

	public static final String PERSISTENCE_UNIT = "robert.Vaadinjpa";

	@SuppressWarnings("rawtypes")
	private Tabela dane = new Tabela(new SenderData(
			JPAContainerFactory
					.createEntityManagerForPersistenceUnit(PERSISTENCE_UNIT)),
			JPAContainerFactory.make(Person.class, PERSISTENCE_UNIT),
			new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		 if (em == null) {
	            em = (EntityManager) Persistence.createEntityManagerFactory("robert.Vaadinjpa").createEntityManager();
		 }
	}

	
	 
	    
	   private Person addPerson;
	   private Person anotherPerson;
		

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		em.close();
	}

	@Before
	public void setUp() throws Exception {
		addPerson= new Person();
		addPerson.setFirstName("adam");
		addPerson.setCity("Wroclaw");
		addPerson.setId((long) 3);
		addPerson.setBoss(null);
		addPerson.setLastName("XXX");
		addPerson.setPhoneNumber("111222333");
		addPerson.setStreet("yyy");
		addPerson.setZipCode("100-00");
		
		
		anotherPerson=addPerson;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddPerson() {
		
		em.getTransaction().begin();
		 
		Person firstPerson=dane.getSenderDane().findPeopleById((long) 1);
		Person secondPerson=dane.getSenderDane().findPeopleById((long) 1);
		assertNotSame(firstPerson.getId(), addPerson.getId());
		assertNotSame(firstPerson.getLastName(), addPerson.getLastName());
		
		
		em.persist(addPerson);
		em.flush();
		
		assertSame(firstPerson, secondPerson);
		assertNotSame(firstPerson, addPerson);
		
		 Query query = em.createQuery("Select p from Person p where p.id=:id");
	       query.setParameter("id", addPerson.getId());
	        Person retrieved1 = (Person) query.getSingleResult();
	        assertSame(addPerson, retrieved1);
	        
	        em.remove(addPerson);
	       
			 em.getTransaction().commit(); 
		
	}
	
	@Test
	public void equalsTest(){
		
		assertSame(addPerson, anotherPerson);
		
		
	}
	
	
	
	

}
