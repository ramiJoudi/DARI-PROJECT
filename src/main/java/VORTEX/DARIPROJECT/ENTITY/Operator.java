package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
@Entity
 
public class Operator extends User implements Serializable {
	private static final long serialVersionUID = -5369734855993305723L;
 
	private int messageId;
	private String messaage;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Chat> chats;

	public Operator(String username, int mobile, String login, String pwd) {
		super(username, mobile, login, pwd);
	}

	public Operator(String username, int mobile, String login, String pwd, int messageId, String messaage) {
		super(username, mobile, login, pwd);
		this.messageId = messageId;
		this.messaage = messaage;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessaage() {
		return messaage;
	}

	public void setMessaage(String messaage) {
		this.messaage = messaage;
	}

}
