package VORTEX.DARIPROJECT.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Cookie")
public class CookieController {
	
	@GetMapping("/")
	public String readCookie(@CookieValue(value = "username", defaultValue = "Atta") String username) {
	    return "Hey! My username is " + username;
	}
	
	@GetMapping("/change-username")
	public String setCookie(HttpServletResponse response) {
	    // create a cookie
	    Cookie cookie = new Cookie("username", "Jovan");

	    
	    //60*60*24 
	    //add cookie to response
	    response.addCookie(cookie);

	    return "Username is changed!";
	}
	
	@GetMapping("/all-cookies")
	public String readAllCookies(HttpServletRequest request) {

	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        return Arrays.stream(cookies)
	                .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
	    }

	    return "No cookies";
	}

}
