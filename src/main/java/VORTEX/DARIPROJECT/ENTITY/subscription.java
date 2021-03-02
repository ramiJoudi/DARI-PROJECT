package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table( name= "D_subscription")
public class subscription implements Serializable{
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	
	private int idSub; 
	
	private String offer;

	public subscription(int idSub, String offer) {
		super();
		this.idSub = idSub;
		this.offer = offer;
	}

	public subscription() {
		super();
	}

	public int getIdSub() {
		return idSub;
	}

	public void setIdSub(int idSub) {
		this.idSub = idSub;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	
}
