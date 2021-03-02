package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name="ClaimTable")
public class Claim implements Serializable{
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int idClaim;
	private String subject;
	private String description;
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
