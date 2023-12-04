package eduConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eduConnect.command.TestCommand;
import eduConnect.service.test.TestAutoNumService;
import eduConnect.service.test.TestDeleteService;
import eduConnect.service.test.TestDetailService;
import eduConnect.service.test.TestListService;
import eduConnect.service.test.TestWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("test")
public class TestController {
	@Autowired
	TestListService testListService;
	@Autowired
	TestWriteService testWriteService;
	@Autowired
	TestAutoNumService testAutoNumService;
	@Autowired
	TestDetailService testDetailService;
	@Autowired
	TestDeleteService testDeleteService;
	
	@GetMapping("testList")
	public String testList(@RequestParam(value="courseNum") String courseNum, Model model,HttpSession session) {
		
		testListService.execute(courseNum, model);
		
		return "thymeleaf/test/testList";
	}
	
	@GetMapping("testRegist")
	public String testRegist(@RequestParam(value="courseNum") String courseNum,Model model) {
		testAutoNumService .execute(model);
		model.addAttribute("courseNum", courseNum);
		return "thymeleaf/test/testForm";
	}
	
	@PostMapping("testWrite")
	public String testWrite(TestCommand testCommand, Model model) {
		
		testWriteService.execute(testCommand);
		
		return "redirect:testList?courseNum="+testCommand.getCourseNum();
	}
	
	@GetMapping("testDetail")
	public String testDetail(@RequestParam("courseNum") String courseNum,
							 @RequestParam("sessionNum") String sessionNum
							 ,Model model) {
		testDetailService.execute(courseNum, sessionNum, model);
		return "thymeleaf/test/testDetail";
	}
	
	@PostMapping("testUpdate")
	public String testUpdate(TestCommand testCommand, Model model) {
		testDeleteService.execute(testCommand.getTestNum());
		testWriteService.execute(testCommand);
		return "redirect:testList?courseNum="+testCommand.getCourseNum();
	}
	
	@GetMapping("testStu")
	public String testStu(@RequestParam("courseNum") String courseNum,
			 @RequestParam("sessionNum") String sessionNum
			 ,Model model) {
		testDetailService.execute(courseNum, sessionNum, model);
		return  "thymeleaf/test/testStu";
	}
	
	@PostMapping("testStuAnswer")
	public String testStuAnswer(TestCommand testCommand) {
		
		return"";
	}
}
