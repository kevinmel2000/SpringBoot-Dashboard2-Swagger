package pjm.microservice.dashboard;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@OpenAPIDefinition(info=@Info(title="Dashboard", version = "1.0"))
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DashboardApplication {

    public static void main(String[] args) 
    {
    	 if(args.length == 1)
		 {
			 System.getProperties().put("server.port", args[0]);
		 }
		 else
		 {
			 System.getProperties().put("server.port", 8080);
		 }
    	 
        SpringApplication.run(DashboardApplication.class, args);
    }

}
