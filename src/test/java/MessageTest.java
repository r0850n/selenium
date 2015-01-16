

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.Message;
import model.Type;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

import robert.Vaadinjpa.domain.Person;





public class MessageTest
{
	
	
	

	
	
	
    private final String RECIPIENT = "recipient";
    private final String MESSAGE = "message";
    
    private Message msg;
    private Message theSameMsg;
    private Message otherMsg;
	private Type type;
	private Type typeSecond;
	private Person person;
	private Person secondPerson;
	
	
   
    
	 @Before
    public void setUp() 
    {
		 
		 msg=mock(Message.class);
		
		 
    	type=new Type();
    	typeSecond=new Type();
    	type.setType("sms");
    	
        msg = new Message();
        msg.setMessage(MESSAGE);
        msg.setType(type);
        msg.setLog("11/123/123/123/");
      
        theSameMsg = new Message();
        theSameMsg.setMessage(MESSAGE);
        theSameMsg.setType(type);
        theSameMsg.setLog("11/123/123/123/");
        otherMsg = new Message();
       
        otherMsg.setMessage(RECIPIENT);
        otherMsg.setType(typeSecond);
        otherMsg.setLog("11/123/123/123/");
       
        
        secondPerson=new Person();
        secondPerson.setFirstName("ZZZ");
        secondPerson.setCity("Wroclaw");
        secondPerson.setId((long) 4);
        secondPerson.setBoss(null);
        secondPerson.setLastName("ddd");
        secondPerson.setPhoneNumber("111243253");
        secondPerson.setStreet("yyy");
        secondPerson.setZipCode("100-00");
        
        person=new Person();
        person.setFirstName("adam");
        person.setCity("Wroclaw");
        person.setId((long) 5);
        person.setBoss(null);
        person.setLastName("ddd");
        person.setPhoneNumber("111243253");
        person.setStreet("yyy");
        person.setZipCode("100-00");
      
    }

    
    @Test
    public void testEquals_OK()
    {

        assertTrue( msg.equals( msg ) );
        assertFalse( msg.equals( theSameMsg ) );
        assertTrue(msg.getLog().equals(otherMsg.getLog()));
        assertTrue( person.equals( person ) );
        assertFalse(person.equals( secondPerson ));
    }


    @Test
    public void testEquals_Fail()
    {

        assertFalse( msg.equals( otherMsg ) );
    }

    @Test
    public void testEquals_Type()
    {

        assertFalse( msg.getType().equals( otherMsg.getType() ) );
    }

    @Test
    public void testEquals_withNull()
    {
       assertFalse( new Message(null,null,null).equals( new Message(null,null,null) ) );
        assertFalse( msg.equals( null ) );
        assertFalse( msg.equals( new Message( ) ) );

    }


    @Test
    public void testId()
    {
        assertEquals( msg.getId(), theSameMsg.getId() );
      
    }
    @Test
    public void testMessage() {
    	Type type = new Type(0, "SMS");
        Message message = new Message(null,null,type);
        assertEquals("SMS", message.getType().getType());
        
      }
    
    @Test
    public void isMessage() {
    	Type type = new Type(0, "SMS");
    	
        Message message = new Message(null,null,type);
        assertEquals("SMS", message.getType().getType());
        
        
      }
	
}
