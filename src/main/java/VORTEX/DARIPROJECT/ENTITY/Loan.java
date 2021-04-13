package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="Loan")
public class Loan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7191350880347557053L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCredit;
	private float price;
	private float interestRate;
	private float monthly_payment;
	private int loan_duration;
	private String bankname;
	public int getIdCredit() {
		return idCredit;
	}
	public void setIdCredit(int idCredit) {
		this.idCredit = idCredit;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float d) {
		price = d;
	}
	/*public float getRevenue() {
		return revenue;
	}
	public float setrevenue() {
		return revenue;
	}*/
	public float getinterestrate(){
		return interestRate;
	}
	public void setinterestrate(float interestRate){
		this.interestRate=interestRate;
	}
	public float getMonthly_payment() {
		return monthly_payment;
	}
	public void setMonthly_payment(float monthly_payment) {
		this.monthly_payment = monthly_payment;
	}
	public int getLoan_duration() {
		return loan_duration;
	}
	public void setLoan_duration(int loan_duration) {
		this.loan_duration = loan_duration;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname.toUpperCase();
	}
	public void setLoanEroor(String Error)
	{
		this.setBankname(Error);
		this.setPrice(0);
		this.setLoan_duration(0);
	}
	/*public bank getBank() {
		return bank;
	}
	public void setBank(bank bank) {
		this.bank = bank;
	}*/

	public Loan(float price, float interestRate, float monthly_payment, int loan_duration) {
		super();
		this.price = price;
		this.loan_duration = loan_duration;
		this.bankname = bankname.toUpperCase();
	}

	public Loan() {
		super();
	}
	
}