package eduConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eduConnect.command.StudentCommand;
import eduConnect.service.student.StudentDeleteService;
import eduConnect.service.student.StudentDetailService;
import eduConnect.service.student.StudentMyInfoService;
import eduConnect.service.student.StudentUpdateService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentMyInfoService studentMyInfoService;
	@Autowired
	StudentDetailService studentDetailService;
	@Autowired
	StudentUpdateService studentUpdateService;
	@Autowired
	StudentDeleteService studentDeleteService;
		
	@GetMapping("myPage")
	public String studentmyInfo(HttpSession session, Model model) {
		studentMyInfoService.execute(session, model);
		return "thymeleaf/student/studentmyInfo";
	}
	
	@GetMapping("studentModify")
	public String studentModify(HttpSession session, Model model) {
		studentDetailService.execute(session, model);
		return "thymeleaf/student/studentModify";
	}
	@PostMapping("studentUpdate")
	public String studentUpdate(@Validated StudentCommand studentCommand, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/student/studentModify";
		}
		studentUpdateService.execute(studentCommand);
		return "redirect:myPage";
	}
	@GetMapping("studentDelete")
	public String studentDelete() {
		return "thymeleaf/student/studentDelete";
	}
	@PostMapping("studentDeleteAccept")
	public String studentDeleteAccept(@RequestParam(value="studentPw") String studentPw,HttpSession session, Model model) {
		int i=studentDeleteService.execute(studentPw,session, model);
		if(i==1) {
			return "redirect:/login/logout";
		}else {
			return "thymeleaf/student/studentDelete";
		}
	}
	
}
