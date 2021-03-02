package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 
public enum bank {
	 STB("STB",0.3),
	 BNA("BNA",0.35),
	 BH("BH",0.29),
	 BTE("BNA",0.4) ;

	 private String id;
	 private Double interest_rate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(Double interest_rate) {
		this.interest_rate = interest_rate;
	}
	private bank() {
	}
	
	private bank(String id, Double interest_rate) {
		this.id = id;
		this.interest_rate = interest_rate;
	}
}
