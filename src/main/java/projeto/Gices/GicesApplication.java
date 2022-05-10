package projeto.Gices;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import nz.net.ultraq.thymeleaf.LayoutDialect;  

//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
public class GicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GicesApplication.class, args);
	}

        @Bean  
	public LayoutDialect layoutDialect() {  
	    return new LayoutDialect();  
	}
}
