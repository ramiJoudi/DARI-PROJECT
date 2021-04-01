package VORTEX.DARIPROJECT.ENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name= "WishList")

public class WishList implements Serializable {
	
	public WishList() {
		super();
		// TODO Auto-generated constructor stub
	}


	private static final long serialVersionUID = 1L;
	

	


	
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id; 
	@Column(name="area")
	private float area;
	@Column(name="price")
	private float price;
	@Column(name="location")
	private String location;
	@Column(name="nbRooms")
	private int nbRooms;
	@Column(name="nbBaths")
	private int nbBaths;
	@Column(name="nbGarage")
	private int nbGarage;
	@Column(name="Terrase")
	private boolean Terrase;
	@Column(name="Piscine")
	private boolean Piscine;
	@Column(name="Garde")
	private boolean Garde;
	@Column(name="airConditionnig")
	private boolean airConditionnig;
	@Column(name="Heater")
	private boolean Heater;
	@Column(name="Meuble")
	private boolean Meuble;
	@Column(name="Basement")
	private boolean Basement;
	@Column(name="Elevator")
	private boolean Elevator;
	
	public WishList(int id, float area, float price, String location, int nbRooms, int nbBaths, int nbGarage,
			boolean terrase, boolean piscine, boolean garde, boolean airConditionnig, boolean heater, boolean meuble,
			boolean basement, boolean elevator, User user) {
		super();
		this.id = id;
		this.area = area;
		this.price = price;
		this.location = location;
		this.nbRooms = nbRooms;
		this.nbBaths = nbBaths;
		this.nbGarage = nbGarage;
		Terrase = terrase;
		Piscine = piscine;
		Garde = garde;
		this.airConditionnig = airConditionnig;
		Heater = heater;
		Meuble = meuble;
		Basement = basement;
		Elevator = elevator;
		this.user = user;
	}
	
	
	@ManyToOne
	private User user;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getArea() {
		return area;
	}


	public void setArea(float area) {
		this.area = area;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getNbRooms() {
		return nbRooms;
	}


	public void setNbRooms(int nbRooms) {
		this.nbRooms = nbRooms;
	}


	public int getNbBaths() {
		return nbBaths;
	}


	public void setNbBaths(int nbBaths) {
		this.nbBaths = nbBaths;
	}


	public int getNbGarage() {
		return nbGarage;
	}


	public void setNbGarage(int nbGarage) {
		this.nbGarage = nbGarage;
	}


	public boolean isTerrase() {
		return Terrase;
	}


	public void setTerrase(boolean terrase) {
		Terrase = terrase;
	}


	public boolean isPiscine() {
		return Piscine;
	}


	public void setPiscine(boolean piscine) {
		Piscine = piscine;
	}


	public boolean isGarde() {
		return Garde;
	}


	public void setGarde(boolean garde) {
		Garde = garde;
	}


	public boolean isAirConditionnig() {
		return airConditionnig;
	}


	public void setAirConditionnig(boolean airConditionnig) {
		this.airConditionnig = airConditionnig;
	}


	public boolean isHeater() {
		return Heater;
	}


	public void setHeater(boolean heater) {
		Heater = heater;
	}


	public boolean isMeuble() {
		return Meuble;
	}


	public void setMeuble(boolean meuble) {
		Meuble = meuble;
	}


	public boolean isBasement() {
		return Basement;
	}


	public void setBasement(boolean basement) {
		Basement = basement;
	}


	public boolean isElevator() {
		return Elevator;
	}


	public void setElevator(boolean elevator) {
		Elevator = elevator;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
