package semana5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableJpaAuditing
@SpringBootApplication
public class SpringChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringChallengeApplication.class, args);
	}

}
