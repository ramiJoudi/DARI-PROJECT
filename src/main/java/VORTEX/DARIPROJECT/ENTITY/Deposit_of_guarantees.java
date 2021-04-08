package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="DepositG")
public class Deposit_of_guarantees implements Serializable {
	


	public Deposit_of_guarantees() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="ID")
	private long ID; 
	@Column(name="JC") //jc : justificaion de paiment , imgurl
	private String JC; 
	@Column(name="Payslips") // fiches de paies , imgurl
	private String Payslips;
	@Column(name="EL") //el : engagement letter , imgurl
	private String EL; 
	@Column(name="phoneNumber") 
	private String PhoneNumber;
	@Column(name="adressMail") 
	private String adressMail;
	@OneToOne
	private real_estate Real_estate;
	
	
	
	public Deposit_of_guarantees(long iD, String jC, String payslips, String eL, String phoneNumber,String adressMail,
			real_estate real_estate) {
		super();
		ID = iD;
		JC = jC;
		Payslips = payslips;
		EL = eL;
		this.PhoneNumber = phoneNumber;
		this.adressMail = adressMail;
		Real_estate = real_estate;
	}

	
	
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getJC() {
		return JC;
	}
	public void setJC(String jC) {
		JC = jC;
	}
	public String getPayslips() {
		return Payslips;
	}
	public void setPayslips(String payslips) {
		Payslips = payslips;
	}
	public String getEL() {
		return EL;
	}
	public void setEL(String eL) {
		EL = eL;
	}

	public real_estate getReal_estate() {
		return Real_estate;
	}

	public void setReal_estate(real_estate real_estate) {
		Real_estate = real_estate;
	}



	public String getPhoneNumber() {
		return PhoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}




	public String getAdressMail() {
		return adressMail;
	}




	public void setAdressMail(String adressMail) {
		this.adressMail = adressMail;
	}

}
