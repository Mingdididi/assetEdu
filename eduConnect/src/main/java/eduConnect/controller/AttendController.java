package eduConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eduConnect.service.attend.AttendListService;

@Controller
@RequestMapping("attend")
public class AttendController {
	@Autowired
	AttendListService attendListService;
	
	@GetMapping("attendList")
	public String attendList(@RequestParam("courseNum") String courseNum) {
		attendListService.execute(courseNum);
		return "thymeleaf/attend/attendList";
	}
}
