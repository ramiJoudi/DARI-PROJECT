package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
public class subscription implements Serializable{
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int idSub; 
	
	private String offer;
	
	@OneToOne(mappedBy = "sub")
	private customer customer;

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
