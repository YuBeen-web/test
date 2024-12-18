package board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class BoardExample3Application {

	public static void main(String[] args) {
		SpringApplication.run(BoardExample3Application.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "thymeleaf/index";
	}

}
