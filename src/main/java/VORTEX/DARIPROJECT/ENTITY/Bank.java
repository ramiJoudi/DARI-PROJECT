package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bank")
public class Bank implements Serializable{
	private static final long serialVersionUID = -654550526332587022L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bankId;
	private String bankname;
	private float interestRate;
	
	public String getBankName() {
		return bankname;
	}
	public void setBankName(String bankName) {
		this.bankname = bankName.toUpperCase();
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	
	public Bank(int bankId, String bankName, float interestRate) {
		super();
		this.bankname = bankName.toUpperCase();		
		this.bankId = bankId;
		this.interestRate = interestRate;
	}
	public Bank() {
		super();
	}
}
