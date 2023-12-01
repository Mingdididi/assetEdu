package eduConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eduConnect.command.StudentCommand;
import eduConnect.service.student.StudentAutonumService;
import eduConnect.service.student.SignupService;

@Controller
@RequestMapping("register")
public class SignupController {
	@Autowired
	SignupService signupService;
	@Autowired
	StudentAutonumService autonumService;

	@GetMapping("userAgree")  //정보동의페이지로 갑니다
	public String infoAgree() {
		return "thymeleaf/student/infoAgree";
	}
	@PostMapping("signupForm")//정보동의하면 autonumservice를 실행하고 signUp폼을 엽니다
	public String signupForm(@RequestParam(value="agree",defaultValue="false") boolean agree, StudentCommand studentCommand, Model model) {
		if(agree=false) {
			return "thymeleaf/student/infoAgree";
		}
		autonumService.execute(studentCommand,model);
		return "thymeleaf/student/signUp";
	}
	@PostMapping("userWrite")//회원가입폼 제출! 
	public String userRegist(@Validated StudentCommand studentCommand, BindingResult result, Model model) {
		if(result.hasErrors()) {
			  for (ObjectError error : result.getAllErrors()) {
			        System.out.println(error.getDefaultMessage());
			    }
			return "thymeleaf/student/signUp";
		}
		if(!studentCommand.isstudentPwEqualstudentPwCon()) {
			result.rejectValue("studentPwCon", "studentCommand.studentPwCon","비밀번호 확인이 틀렸습니다.");
			return "thymeleaf/student/signUp";
		}
		signupService.execute(studentCommand,model);
		return "thymeleaf/student/welcome";

	}
}
