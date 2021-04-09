package VORTEX.DARIPROJECT.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VORTEX.DARIPROJECT.ENTITY.real_estate;
import VORTEX.DARIPROJECT.service.PayPalClient;
import VORTEX.DARIPROJECT.service.stateService;

@RestController
@RequestMapping(value = "/paypal")
public class PayPalController {

	private final PayPalClient payPalClient;
	private stateService stateser;
    @Autowired
    PayPalController(PayPalClient payPalClient,stateService stateser){
        this.payPalClient = payPalClient;
        this.stateser=stateser;
    }

    @PostMapping(value = "/make/payment")
    public Map<String, Object> makePayment(@RequestParam("sum") String sum){
        return payPalClient.createPayment(sum);
    }
    @PostMapping(value = "/complete/payment")
    public Map<String, Object> completePayment(HttpServletRequest request){
        return payPalClient.completePayment(request);
    }
    
    @PostMapping("/makepay/{status}")
    public Map<String, Object> makePayment2(@PathVariable("status") long status){
    	

    	Map<String, Object> mp = new HashMap<>();
    	mp.put("message", "error  creating  house no rentable");
    	if(stateser.getRealstateById(status).equals(null)) {
    		
    		   return mp;
    	}
    	
    	
    	
    	
    	real_estate u =stateser.getRealstateById(status);
    	
    	if(u.isRent()) {
    		
    		
    		 return payPalClient.createPayment( Float.toString(  u.getPurchasing_price()));
    	}
    	else return mp; 
    	
    	
    	
    	
    	
    	
    	
    }
}
	

