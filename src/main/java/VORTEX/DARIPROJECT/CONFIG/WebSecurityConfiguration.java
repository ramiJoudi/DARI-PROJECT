package VORTEX.DARIPROJECT.CONFIG;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private CustomAuthenticationSuccessHandler SuccessUrl;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  provider;
    }
    
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
                .antMatchers("/singin/**","/confirm-account/**","/login/**")
                .permitAll()
                .antMatchers("/customerHome","/customerHome/**")
                .hasAuthority("CUSTOMER")
                .antMatchers("/adminHome","/adminHome/**")
                .hasAuthority("ADMIN")
                .antMatchers("/ownerHome","/ownerHome/**")
                .hasAuthority("OWNER")
                .antMatchers("/operatorHome","/operatorhome/**")
                .hasAuthority("OPERATOR")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().successHandler(SuccessUrl).and().rememberMe().and()
                .logout().logoutUrl("/logout") 
                .logoutSuccessUrl("/login").deleteCookies("remember-me")
                .and().httpBasic();
       
    }
   

   
    }
    

