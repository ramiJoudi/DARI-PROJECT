package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity

public class Claim implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int idClaim;
	private String subject;
	private String description;

	@ManyToOne  
	private real_estate real_estate;
	
	@ManyToOne  
	@JoinColumn(name = "idClient", referencedColumnName = "id", insertable=false, updatable=false)
	private customer Client;
	
	public Claim(int idClaim, String subject, String description) {
	super();
	this.idClaim = idClaim;
	this.subject = subject;
	this.description = description;
}
	
public Claim() {
	super();
}



public int getIdClaim() {
	return idClaim;
}
public void setIdClaim(int idClaim) {
	this.idClaim = idClaim;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
