package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the type database table.
 * 
 */
@Entity
@NamedQuery(name="Type.findAll", query="SELECT t FROM Type t")
public class Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String type;

	
	
	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="type")
	private List<Message> messages;

	public Type() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setType(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setType(null);

		return message;
	}

	public Type(int id, String type) {
		super();
		this.id = id;
		this.type = type;
		
	}

	
	
}