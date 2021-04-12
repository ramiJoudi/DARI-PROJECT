package VORTEX.DARIPROJECT.SERVICE;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import VORTEX.DARIPROJECT.ENTITY.User;
import VORTEX.DARIPROJECT.ENTITY.admin;
import VORTEX.DARIPROJECT.REPOSITORY.REPOSITORY_User;

@Service
public class SERVICE_USER implements UserDetailsService {

@Autowired
private REPOSITORY_User RU;
 

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = RU.findByUsername(username);
    if(user == null) {
        throw new UsernameNotFoundException("User Not Found");
    }
    return new CustomUserDetails(user);
}

public User findByUsername(String username) {
	return RU.findByUsername(username);
}
 
public User findByresetPwdCode(String resetPwdCode) {
	return RU.findByresetPwdCode(resetPwdCode);
}


}
