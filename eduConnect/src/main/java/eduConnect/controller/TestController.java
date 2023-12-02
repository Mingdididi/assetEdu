package eduConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eduConnect.service.test.TestListService;

@Controller
@RequestMapping("test")
public class TestController {
	@Autowired
	TestListService testListService;
	
	@GetMapping("testList")
	public String testList(@RequestParam(value="courseNum") String courseNum, Model model) {
		// 아직 구현안함
		testListService.execute(courseNum, model);
		
		return "thymeleaf/test/testList";
	}
	
	@GetMapping("testRegist")
	public String testRegist(@RequestParam(value="courseNum") String courseNum,Model model) {
		model.addAttribute("courseNum", courseNum);
		return "thymeleaf/test/testForm";
	}
}
