package VORTEX.DARIPROJECT.ENTITY;

import org.springframework.stereotype.Component;

public class EntityPrice {
	
	subscription s ;
	
	long price;

	public subscription getS() {
		return s;
	}

	public void setS(subscription s) {
		this.s = s;
	}

	public long getPrice() {
		return price;
	}



	public void setPrice(long price) {
		this.price = price;
	}
	

}
