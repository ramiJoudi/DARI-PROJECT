package VORTEX.DARIPROJECT.SERVICE;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.REPOSITORY.REPOSITORY_Admin;
import net.bytebuddy.utility.RandomString;
 
 

@Service
public class SERVICE_Admin{
  
		@Autowired
		private REPOSITORY_Admin RA;
		
		
		public void Add_Admin( admin a) {
			// TODO Auto-generated method stub
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(a.getPwd());
			a.setPwd(hashedPassword);
			a.setRole("ADMIN");
		    	RA.save(a);
		    	 
		
		}
		public boolean verify(String verificationCode) {
			admin a = RA.findByVerificationCode(verificationCode);
			
			if (a == null || a.isEnabled()) {
				return false;
			} else {
				a.setVerificationCode(null);
				a.setEnabled(true);
				RA.save(a);
				
				return true;
			}
			
		}
		 
		 

		public void Update_Admin( int id,admin a)  throws ResourceNotFoundException{
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(a.getPwd());
		 admin a1=RA.findById(id).orElseThrow(
				 ()->new ResourceNotFoundException(" this admin doesn't exist"));
		a1.setFirstname(a.getFirstname());
		a1.setLasttname(a.getLasttname());
		a1.setMobile(a.getMobile());
		a1.setPwd(hashedPassword);
		a1.setUsername(a.getUsername());
		RA.save(a1);
			
			}

		

	 
		public void delete_Admin(int id) {
			 
			RA.deleteById(id);
		}

 
		public String Get_Admin(int id) {
			// TODO Auto-generated method stub
			
		return	RA.findById(id).get().getUsername();
		 
		}
 
		public ArrayList<admin> Get_Admins() {
			// TODO Auto-generated method stub
		 
			return  (ArrayList<admin>) RA.findAll();
		}
 	public admin findByEmail(String email) {
			
 	return RA.findByEmail(email);
 		/*for(admin a:this.Get_Admins()) {
				if(a.getEmail()==email)
					return a;
			}return null;*/
		}
	 


	}

 
