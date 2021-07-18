package carl.myretail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableCaching
@EnableMongoRepositories(basePackages = "carl.myretail.repository")
public class MyretailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyretailApplication.class, args);
		
	}

}
