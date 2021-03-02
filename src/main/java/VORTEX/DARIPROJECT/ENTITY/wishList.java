package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table( name= "D_wishList")
public class wishList implements Serializable{
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name="id")
	private int id; 
	@Enumerated(EnumType.STRING)
	private String property_type;
	@Column(name="location")
	private int location;

}
