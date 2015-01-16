
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import model.Type;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import robert.Vaadinjpa.domain.Person;

import com.vaadin.addon.jpacontainer.JPAContainerFactory;

import components.Sender;
import components.SenderData;
import components.Tabela;

public class SenderTest {
	
	public static final String PERSISTENCE_UNIT = "robert.Vaadinjpa";

	@SuppressWarnings({ "rawtypes" })
	private Tabela dane = new Tabela(new SenderData(
			JPAContainerFactory
					.createEntityManagerForPersistenceUnit(PERSISTENCE_UNIT)),
			JPAContainerFactory.make(Person.class, PERSISTENCE_UNIT),
			new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));

	private Sender sender;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sender=new Sender();
		
		
	}

	@After
	public void tearDown() throws Exception {
		sender=null;
	}

	@Test
	public void testPerson() {

		Long id = (long) 1;
		Long idsecond = (long) 2;
		Person person = new Person();
		person.setId(id);
		Person secondPerson = new Person();
		secondPerson.setId(idsecond);
		
		assertNotSame(person, secondPerson);
		assertNotNull(person);
		assertNull(person.getFirstName());
		assertNotNull(secondPerson);
	}
	
	@Test
	public void testFindPerson() {
		
		Long id = (long) 1;
		Person person = new Person();
		person.setId(id);
		
		Person findPerson = dane.getSenderDane().findPeopleById(id);
		assertEquals(person, findPerson);
		
	}
	
	@Test
	public void testType() {

		int id =  1;
		int idsecond =  2;
		Type type= new Type();
		type.setId(id);

		Type secondType= new Type();
		secondType.setId(idsecond);
		assertNotSame(type, secondType);
		assertNotNull(type);
		assertNull(type.getMessages());
		assertNotNull(secondType);
		Assert.assertEquals(1, type.getId());
	}
	
	/*@Test
	
	public void testWindow(){
		
		
		
		
		sender.adressField();
	}*/
	
@Test
	
	public void testVisible(){
		
		
		
		
		sender.isVisible();
	}

	

}
