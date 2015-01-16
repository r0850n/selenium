package helpers;



import java.util.ArrayList;

import com.vaadin.data.Validator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;

public final class Validation {

	
	
	private String phoneFormat = "\\d\\d\\d([,\\s])?\\d\\d\\d([,\\s])?\\d\\d\\d";
	private String notyp = "\\d\\d\\d";
	private String addtype2 = "\\S\\S\\S";
	
	
	private Validator notype;
	private Validator email;
	private Validator phoneNumber;
	private Validator mmsNumber;
	private Validator facebook;
	private Validator postCode;
	private Validator tweetLogin;
	private Validator newValid;
	private Validator newValidLetters;

	public Validator getNewValid() {
		return newValid;
	}

	public void setNewValid(Validator newValid) {
		this.newValid = newValid;
	}

	private Validator number= new RegexpValidator(phoneFormat, "Pleas imput correct phone number.");
	
	

	private ArrayList<Validator> valid= new ArrayList<Validator>();
	
	
	public ArrayList<Validator> getValid() {
        setValid(valid);
		return valid;
	}

	public void setValid(ArrayList<Validator> valid) {
		notype=new RegexpValidator(notyp," Pleas imput..... " );
		setNotype(notype);
		valid.add(getNotype());
		
		email = new EmailValidator("Pleas imput correct e-mail.");
		setEmail(email);
        valid.add(getEmail());
        
        phoneNumber=getNumber();
        setPhoneNumber(phoneNumber);
        valid.add(getPhoneNumber());
        
        mmsNumber=getNumber();
        setMmsNumber(mmsNumber);
        valid.add(getMmsNumber());
        
        facebook=new EmailValidator("Pleas imput correct e-mail from facebook.");
        setFacebook(facebook);
        valid.add(getFacebook());
        
        tweetLogin=new EmailValidator("Pleas imput correct e-mail from tweet.");
        setTweetLogin(tweetLogin);
        valid.add(getTweetLogin());
        
        
       newValid=new RegexpValidator(notyp," Pleas imput..... " );
        setNewValid(newValid);
        valid.add(getNewValid());
        
        newValidLetters=new RegexpValidator(addtype2," Pleas imput 3 letters " );
        setNewValid(newValidLetters);
        valid.add(getNewValidLetters());
        
		this.valid = valid;
	}

	private Validator getNewValidLetters() {
		// TODO Auto-generated method stub
		return newValidLetters;
	}

	public Validator getEmail() {
		return email;
	}

	public void setEmail(Validator email) {
		
		this.email = email;
	}

	public Validator getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Validator phoneNumber) {
		
		
		this.phoneNumber = phoneNumber;
	}

	

	public Validator getTweetLogin() {
		return tweetLogin;
	}

	public void setTweetLogin(Validator tweetLogin) {
		
		
		this.tweetLogin = tweetLogin;
	}
	
	public Validator getNotype() {
		return notype;
	}

	public void setNotype(Validator notype) {
		
		this.notype = notype;
	}

	public Validator getMmsNumber() {
		return mmsNumber;
	}

	public void setMmsNumber(Validator mmsNumber) {
		
		this.mmsNumber = mmsNumber;
	}

	public Validator getFacebook() {
		return facebook;
	}

	public void setFacebook(Validator facebook) {
		
		this.facebook = facebook;
	}

	public Validator getPostCode() {
		return postCode;
	}

	public void setPostCode(Validator postCode) {
		
		this.postCode = postCode;
	}
	
	public Validator getNumber() {
		return number;
	}

	public Validation() {
		super();
		
		setValid(valid);
		getValid();
	}
	
	

	
}
