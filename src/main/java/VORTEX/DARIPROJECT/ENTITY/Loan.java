package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LoanTab")
public class Loan implements Serializable {
	private int idCredit;
	private float Price;
	private float Monthly_paymenet;
	private int loan_duration;
	private bank bank;
	public int getIdCredit() {
		return idCredit;
	}
	public void setIdCredit(int idCredit) {
		this.idCredit = idCredit;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public float getMonthly_paymenet() {
		return Monthly_paymenet;
	}
	public void setMonthly_paymenet(float monthly_paymenet) {
		Monthly_paymenet = monthly_paymenet;
	}
	public int getLoan_duration() {
		return loan_duration;
	}
	public void setLoan_duration(int loan_duration) {
		this.loan_duration = loan_duration;
	}
	public bank getBank() {
		return bank;
	}
	public void setBank(bank bank) {
		this.bank = bank;
	}
	public Loan(int idCredit, float price, float monthly_paymenet, int loan_duration, entity.bank bank) {
		super();
		this.idCredit = idCredit;
		Price = price;
		Monthly_paymenet = monthly_paymenet;
		this.loan_duration = loan_duration;
		this.bank = bank;
	}
	public Loan() {
		super();
	}
	
}
