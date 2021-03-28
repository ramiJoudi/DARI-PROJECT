package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@SuppressWarnings("serial")
@Entity
public class Chat implements Serializable {
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int messageId;
	private String message;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "chats")
	private Set<Operator> operators;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "ChatsC")
	private Set<customer> customers;
}
