package board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class BoardExample1Application {

	public static void main(String[] args) {
		SpringApplication.run(BoardExample1Application.class, args);
	}
	@RequestMapping("/")
	public String index() {
		return "thymeleaf/index";
	}
	

}
