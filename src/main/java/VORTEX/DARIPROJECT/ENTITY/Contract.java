package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ContractTable")
public class Contract implements Serializable{
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name="Contract-number")
	private int Contractnum;
	private Float effective_price;
	private Date effective_Date;
	public Contract(int contractnum, Float effective_price, Date effective_Date) {
		super();
		Contractnum = contractnum;
		this.effective_price = effective_price;
		this.effective_Date = effective_Date;
	}
	public Contract() {
		super();
	}
	public int getContractnum() {
		return Contractnum;
	}
	public void setContractnum(int contractnum) {
		Contractnum = contractnum;
	}
	public Float getEffective_price() {
		return effective_price;
	}
	public void setEffective_price(Float effective_price) {
		this.effective_price = effective_price;
	}
	public Date getEffective_Date() {
		return effective_Date;
	}
	public void setEffective_Date(Date effective_Date) {
		this.effective_Date = effective_Date;
	}
	
	
}
