package eduConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eduConnect.command.TeacherCommand;
import eduConnect.service.teacher.TeacherAutoNumService;
import eduConnect.service.teacher.TeacherDeleteService;
import eduConnect.service.teacher.TeacherDetailService;
import eduConnect.service.teacher.TeacherInsertService;
import eduConnect.service.teacher.TeacherListService;
import eduConnect.service.teacher.TeacherUpdateservice;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("teacherRg")
public class TeacherRgController {
 
	@Autowired
	TeacherAutoNumService teacherAutoNumService;
	@Autowired
	TeacherInsertService teacherInsertService;
	@Autowired
	TeacherListService teacherListService;
	@Autowired
	TeacherDetailService teacherDetailService;
	@Autowired
	TeacherUpdateservice teacherUpdateservice;
	@Autowired
	TeacherDeleteService teacherDeleteService;
	
	@RequestMapping("teacherList")
	public String teacherList(
			@RequestParam(value="page", required = false, defaultValue = "1" ) int page,
			@RequestParam(value="searchWord" , required = false) String searchWord,
			Model model) {
		
		teacherListService.execute(searchWord, page, model);
		
		return "thymeleaf/teacher/teacherList";
	}
	
	@RequestMapping(value = "teacherRegist", method = RequestMethod.GET)
	public String form(TeacherCommand teacherCommand, Model model) {
		teacherAutoNumService.execute(teacherCommand, model);
		return "thymeleaf/teacher/teacherForm";
	}
	
	@RequestMapping(value = "teacherRegist", method = RequestMethod.POST)
	public String from(@Validated TeacherCommand teacherCommand, BindingResult result) {
		if (result.hasErrors()) {
		return "thymeleaf/teacher/teacherForm";
		}
		if (!teacherCommand.isteacherPwEqualsteacherPwCon()) {
			result.rejectValue("teacherPwCon", "teacherCommand.teacherPwCon" , "비밀번호 확인이 틀렸습니다.");
			return "thymeleaf/teacher/teacherForm";
		}
		teacherInsertService.execute(teacherCommand);
	return "redirect:teacherList";
	}
	

	@RequestMapping("teacherDetail")
	public String teacherDetail(@RequestParam(value = "teacherNum") String teacherNum, Model model) {
		teacherDetailService.execute(teacherNum, model);
		return "thymeleaf/teacher/teacherDetail";
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
		return "redirect:teacherList";
		
	}
	
	@GetMapping("teacherDelete")
	public String employeeDelete(@RequestParam(value = "teacherNum") String teacherNum) {
		teacherDeleteService.execute(teacherNum);
		return "redirect:teacherList";
	}
	
	
	
}
