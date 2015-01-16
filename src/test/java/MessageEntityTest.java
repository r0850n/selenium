import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Message;
import model.Type;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import robert.Vaadinjpa.domain.Person;

import com.vaadin.addon.jpacontainer.JPAContainerFactory;

import components.SenderData;
import components.Tabela;


public class MessageEntityTest {
	
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

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		em.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testAllOps() {
		
		 em.getTransaction().begin();
		 
	
		Type firstType = dane.getSenderDane().findTypeById(1);
		Type secondType = dane.getSenderDane().findTypeById(3);
		firstType.setType(secondType.getType());
		assertSame(firstType.getType(),secondType.getType());
		 
		 /*------------Create First Message--------------------*/
		 Message msg= new Message();
		
		 msg.setMessage("test entity");
		 msg.setType(firstType);
		 em.persist(msg);
		 em.flush();
		 
		 /*------------Create Second Message--------------------*/
		 
		 Message msgSecond= new Message();
		
		 msgSecond.setMessage("second Message");
		 msgSecond.setType(secondType);
		 em.persist(msgSecond);
		 em.flush();
		 
		 
		 System.out.println("typ  " + msg.getType().getType());
		 System.out.println("typ2  " + msgSecond.getType().getType());
		 
		 /*------------Selects--------------------*/
		 
		 Collection<Message> list = dane.getSenderDane().findAllMessages();

			for (Message m : list) {
				m.getId();
	            
			
		 Query query = em.createQuery("Select m from Message m where m.id=:id");
	       query.setParameter("id", m.getId());
	        Message retrieved1 = (Message) query.getSingleResult();
	        assertSame(m.getId(), retrieved1.getId());
	        
		System.out.println( "id msg=  "+m.getId());
		System.out.println(" id ret = " + retrieved1.getId());
		
	        assertNotSame(msg, msgSecond);
	        
			}
			em.remove(msg);
			em.remove(msgSecond);
		 em.getTransaction().commit(); 
	}
	
	@Test
	public void equalsTestCollection(){
		
		@SuppressWarnings("unchecked")
		Collection<Message> list = dane.getSenderDane().findAllMessages();
	

		@SuppressWarnings("unchecked")
		Collection<Message> listSecond = dane.getSenderDane().findAllMessages();

		assertEquals(list.size(), listSecond.size());
		
	}
	
	

}
