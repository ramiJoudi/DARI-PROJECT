package VORTEX.DARIPROJECT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaRepositories
@EnableScheduling
@SpringBootApplication
@ComponentScan({
	"VORTEX.DARIPROJECT.ENTITY",
	"VORTEX.DARIPROJECT",
	"VORTEX.DARIPROJECT.controller",
	"VORTEX.DARIPROJECT.service",
	"VORTEX.DARIPROJECT.Repository"
})
public class DariProjectApplication {
/*@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	return sessionFactory;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(DariProjectApplication.class, args);
	}

}
