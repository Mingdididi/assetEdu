package eduConnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import eduConnect.command.LoginCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@SpringBootApplication
public class EduConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduConnectApplication.class, args);
	}

	@RequestMapping("/")
	public String index(@ModelAttribute("loginCommand") LoginCommand loginCommand,
			Model model ,HttpSession session, HttpServletRequest request) {
		return "thymeleaf/index";
	}
}
