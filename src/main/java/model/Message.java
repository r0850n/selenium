package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the messages database table.
 * 
 */
@Entity
@Table(name="messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	
	private String log;

	private String message;

	//bi-directional many-to-one association to Type
	@ManyToOne
	@JoinColumn(name = "type_id")
	private Type type;

	public void setType(Type type) {
		this.type = type;
	}

	public Message() {
	}

	

	public Message(String log, String message, Type type) {
		super();
		this.log = log;
		this.message = message;
		this.type = type;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLog() {
		return this.log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTypeId() {
		
		return this.type.getId();
	}

public Type getType() {
		
		return this.type;
	}

	

}