package VORTEX.DARIPROJECT.service;


import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequest {

	public SmsRequest(String phoneNumber) {
		super();
		this.message = "Vortex informs you that the addition of the warranty deposit form is Successfully";
		this.phoneNumber = phoneNumber;
	}
	
	

	public SmsRequest() {
		super();
		this.message = "Vortex informs you that the addition of the warranty deposit form is Successfully";
		
	}



	@NotBlank
    private  String phoneNumber; // destination

    @NotBlank
    private final String message;

    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        this.phoneNumber =phoneNumber;
        this.message = "\r\n"
        		+ "Vortex informs you that the addition of the warranty deposit form is Successfully"; // le msg qui te peut envoyee
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }
    
    public String  setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return phoneNumber ;
	}

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
