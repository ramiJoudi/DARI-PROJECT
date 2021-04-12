package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="VisitTab")
public class Visit implements Serializable {
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int iDvisit ;
	
	@Column(name="disponible")
	private  Boolean isdisp=false;
	
	@Column(name="n_heure",nullable = true)
	private double n_heure;
	
	public Visit(Boolean isdisp, double n_heure, String responsable) {
		super();
		this.isdisp = isdisp;
		this.n_heure = n_heure;
		this.responsable = responsable;
	}
	public Visit(int iDvisit, Boolean isdisp, double n_heure, String responsable) {
		super();
		this.iDvisit = iDvisit;
		this.isdisp = isdisp;
		this.n_heure = n_heure;
		this.responsable = responsable;
	}
	public double getN_heure() {
		return n_heure;
	}
	public void setN_heure(double n_heure) {
		this.n_heure = n_heure;
	}
	public Visit(int iDvisit, Boolean isdisp, String responsable) {
		super();
		this.iDvisit = iDvisit;
		this.isdisp = isdisp;
		this.responsable = responsable;
	}
	public Visit(Boolean isdisp, String responsable) {
		super();
		this.isdisp = isdisp;
		this.responsable = responsable;
	}
	public int getiDvisit() {
		return iDvisit;
	}
	public void setiDvisit(int iDvisit) {
		this.iDvisit = iDvisit;
	}
	public Boolean getIsdisp() {
		return isdisp;
	}
	public void setIsdisp(Boolean isdisp) {
		this.isdisp = isdisp;
	}
	public Visit(int iDvisit, String responsable, real_estate real_estateV, customer customerV) {
		super();
		this.iDvisit = iDvisit;
		this.responsable = responsable;
		//this.real_estateV = real_estateV;
	//	this.customerV = customerV;
	}
	public Visit(String responsable) {
		super();
		this.responsable = responsable;
	}
	private String responsable;
	
	

	/*
	
	
	
	@ManyToOne(optional = true)
	private real_estate real_estateV;
	*/
	public Visit(String responsable, real_estate real_estateV, customer customerV) {
		super();
		this.responsable = responsable;
		//this.real_estateV = real_estateV;
		//this.customerV = customerV;
	}
	/*
	@ManyToOne (optional = true)
	private customer customerV;*/
	
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
