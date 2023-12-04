package eduConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eduConnect.command.CourseCommand;
import eduConnect.service.course.CourseDelService;
import eduConnect.service.course.CourseDetailService;
import eduConnect.service.course.CourseListService;
import eduConnect.service.course.CourseModifyService;
import eduConnect.service.course.CourseWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("course")
public class CourseController {
	@Autowired
	CourseWriteService courseWriteService;
	@Autowired
	CourseListService courseListService;
	@Autowired
	CourseDetailService courseDetailService;
	@Autowired
	CourseModifyService courseModifyService;
	@Autowired
	CourseDelService courseDelService;

	@RequestMapping(value = "MyPage", method = RequestMethod.GET)
	public String Mypage() {
		return "thymeleaf/teacher/Mypage";
	}
	@GetMapping("courseList")
	public String courseList(Model model,HttpSession session) {
		courseListService.execute(model, session);
		return "thymeleaf/teacher/courseList";
	}
	
	//@GetMapping("courseDetail")
	
	@RequestMapping(value = "courseWrite", method = RequestMethod.GET)
	public String courseWrite() {
		return "thymeleaf/teacher/courseForm";
	}
	@RequestMapping(value="courseRegist" , method = RequestMethod.POST)
	public String boardRegist(CourseCommand courseCommand,HttpSession session) {
		courseWriteService.execute(courseCommand, session);
		return "redirect:courseList";
	}
	@GetMapping(value="courseDetail")
	public String courseDetail(HttpSession session, Model model, @RequestParam(value = "courseNum")String courseNum) {
		courseDetailService.execute(model, courseNum);
		return "thymeleaf/teacher/courseInfo";
	}
	@RequestMapping(value="courseUpdate", method = RequestMethod.GET)
	public String courseUpdate(Model model, @RequestParam(value = "courseNum") String courseNum) {
		courseDetailService.execute(model, courseNum);
		return "thymeleaf/teacher/courseModifyForm";
	}

	@PostMapping(value="courseModify" )
	public String courseModify(CourseCommand courseCommand) {
		courseModifyService.execute(courseCommand);
		return "redirect:courseDetail?courseNum="+courseCommand.getCourseNum();
    }
	@RequestMapping(value="courseDel" ,method = RequestMethod.GET)
	public String courseDel(@RequestParam(value = "courseNum") String courseNum) {
		courseDelService.execute(courseNum);
		return "redirect:courseList";
	}
}
