package VORTEX.DARIPROJECT.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import VORTEX.DARIPROJECT.ENTITY.Notification;
import VORTEX.DARIPROJECT.service.NotificationService;

@Controller
public class notifController {
	@Autowired
	  private NotificationService notificationService ;

	  /**
	   * GET  /  -> show the index page.
	   */
	  @RequestMapping("/")
	  public String index() {
	    return "index";
	  }

	  /**
	   * GET  /notifications  -> show the notifications page.
	   */
	  @RequestMapping("/notifications")
	  public String notifications() {
	    return "notifications";
	  }

	  
	  @RequestMapping(value = "/some-action", method = RequestMethod.POST)
	  @ResponseBody
	  public ResponseEntity<?> someAction() {

	    
	    
	    
	  
		//  notificationService.notify(new Notification("hello"),"UserA");
	    
	    
	    return new ResponseEntity<>(HttpStatus.OK);
	  }

}
