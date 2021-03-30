package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="VisitTab")
public class Visit implements Serializable {
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int iDvisit ;
	
	public Visit(int iDvisit, String responsable, real_estate real_estateV, customer customerV) {
		super();
		this.iDvisit = iDvisit;
		this.responsable = responsable;
		this.real_estateV = real_estateV;
		this.customerV = customerV;
	}
	public Visit(String responsable) {
		super();
		this.responsable = responsable;
	}
	private String responsable;
	
	
	@ManyToOne(optional = true)
	private real_estate real_estateV;
	
	public Visit(String responsable, real_estate real_estateV, customer customerV) {
		super();
		this.responsable = responsable;
		this.real_estateV = real_estateV;
		this.customerV = customerV;
	}
	@ManyToOne (optional = true)
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
