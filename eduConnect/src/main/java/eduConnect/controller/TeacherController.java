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
import eduConnect.domain.AuthInfoDTO;
import eduConnect.service.course.CourseStudentListService;
import eduConnect.service.teacher.TeacherDetailService;
import eduConnect.service.teacher.TeacherUpdateservice;
import jakarta.servlet.http.HttpSession;
///////////////////// 선생님 입장에서 본인 정보 수정하는 Controller
@Controller
@RequestMapping("teacher")
public class TeacherController {
	@Autowired
	TeacherDetailService teacherDetailService;
	@Autowired
	TeacherUpdateservice teacherUpdateservice;
	@Autowired
	CourseStudentListService courseStudentListService;

	@RequestMapping(value= "MyPage", method=RequestMethod.GET)
	   public String Mypage() {
	      return "thymeleaf/teacher/Mypage";
		}

	
	@RequestMapping("teacherDetail")
	public String teacherDetail(HttpSession session,Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String teacherNum = auth.getUserNum();
		teacherDetailService.execute(teacherNum, model);
		return "thymeleaf/teacher/teacherMyDetail";
	}
	
	
	@RequestMapping(value = "teacherModify", method = RequestMethod.GET)
	public String employeeUpdate(Model model,HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String teacherNum = auth.getUserNum();
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
	
	@GetMapping("studentList")
	public String courseStudentList(@RequestParam("courseNum") String courseNum, Model model) {
		courseStudentListService.execute(courseNum, model);
		return "thymeleaf/teacher/studentList";
	}
	
}
