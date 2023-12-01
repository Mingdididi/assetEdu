package eduConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eduConnect.command.TeacherCommand;
import eduConnect.service.teacher.TeacherDetailService;
import eduConnect.service.teacher.TeacherUpdateservice;
///////////////////// 정숙언니랑 겹치는 Controller, commit pull할 때 조심!!
@Controller
@RequestMapping("teacher")
public class TeacherController {
	@Autowired
	TeacherDetailService teacherDetailService;
	@Autowired
	TeacherUpdateservice teacherUpdateservice;

	@RequestMapping(value= "MyPage", method=RequestMethod.GET)
	   public String Mypage() {
	      return "thymeleaf/teacher/Mypage";
		}

	
	@RequestMapping("teacherDetail")
	public String teacherDetail( Model model) {
		////로그인 후 session 값으로 변경
		String teacherNum ="tc100001";
		
		teacherDetailService.execute(teacherNum, model);
		return "thymeleaf/teacher/teacherMyDetail";
	}
	
	
	@RequestMapping(value = "teacherModify", method = RequestMethod.GET)
	public String employeeUpdate(@RequestParam(value = "teacherNum") String teacherNum, Model model) {
		teacherDetailService.execute(teacherNum, model);
		return "thymeleaf/teacher/teacherUpdate";
	}
	
	@PostMapping("teacherModify")
	public String teacherModify (@Validated TeacherCommand teacherCommand, BindingResult result) {
		if (result.hasErrors()) {	
			return "thymeleaf/teacher/teacherUpdate";
		}
		teacherUpdateservice.execute(teacherCommand);
		return "redirect:teacherDetail";
		
	}
	
}
