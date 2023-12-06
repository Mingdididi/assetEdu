package eduConnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import eduConnect.command.LoginCommand;
import eduConnect.service.CookiesService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@SpringBootApplication
public class EduConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduConnectApplication.class, args);
	}
	
	@Autowired
	CookiesService cookiesService;
	
	@RequestMapping("/")
	public String index(@ModelAttribute("loginCommand") LoginCommand loginCommand,
			Model model ,HttpSession session, HttpServletRequest request) {
		
		cookiesService.execute(request, model);
		return "thymeleaf/index";
	}
}
