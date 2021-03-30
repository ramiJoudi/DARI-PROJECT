package VORTEX.DARIPROJECT;
//hjkhjg
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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

	public static void main(String[] args) {
		SpringApplication.run(DariProjectApplication.class, args);
	}

}
