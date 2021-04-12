package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Chat")
public class ChatMessage implements Serializable{
	    
		/**
	 * 
	 */
	private static final long serialVersionUID = 8576661910400752789L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int idChat;
	    private MessageType type;
	    private String content;
	    private String sender;

	    public enum MessageType {
	        CHAT,
	        JOIN,
	        LEAVE
	    }
		public int getIdChat() {
			return idChat;
		}
		public MessageType getType() {
			return type;
		}

		public void setType(MessageType type) {
			this.type = type;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getSender() {
			return sender;
		}

		public void setSender(String sender) {
			this.sender = sender;
		}
	    
		

	}

