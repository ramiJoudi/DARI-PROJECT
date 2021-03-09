package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="VisitTab")
public class Visit implements Serializable {
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int iDvisit ;
	private String responsable;
	
	@ManyToOne 
	private real_estate real_estateV;
	
	@ManyToOne 
	private customer customerV;
	
	public Visit() {
		super();
	}
	public Visit(int iDvisit, String responsable) {
		super();
		this.iDvisit = iDvisit;
		this.responsable = responsable;
	}
	public int getId() {
		return iDvisit;
	}
	public void setId(int iDvisit) {
		this.iDvisit = iDvisit;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
}
