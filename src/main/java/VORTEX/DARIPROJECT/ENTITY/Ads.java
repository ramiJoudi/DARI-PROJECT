package VORTEX.DARIPROJECT.ENTITY;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name = "ADS")
public class Ads implements Serializable{
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private int AdID;
	private String Adname;
	private String AdLocation ;
	private String AdDescription;
	private int price;
	private Date AdDate;
	private Float Area;
	private int RoomNo;
	private property_type Type;
	private Boolean parkingSpace;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "ads")
	private Set<customer> customers;
	
	@OneToOne
	private real_estate real_estate;
}
