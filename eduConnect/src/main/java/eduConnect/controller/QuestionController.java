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

import eduConnect.command.QuestionCommand;
import eduConnect.domain.AuthInfoDTO;
import eduConnect.service.login.AnswerUpdateService;
import eduConnect.service.question.AnswerRegisterService;
import eduConnect.service.question.QuestionAutoNumService;
import eduConnect.service.question.QuestionDeleteService;
import eduConnect.service.question.QuestionDetailService;
import eduConnect.service.question.QuestionInsertService;
import eduConnect.service.question.QuestionListService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionListService questionListService;
	@Autowired
	QuestionAutoNumService questionAutoNumService;
	@Autowired
	QuestionInsertService questionInsertService;
	@Autowired
	QuestionDetailService questionDetailService;
	@Autowired
	AnswerRegisterService answerRegisterService;
	@Autowired
	AnswerUpdateService answerUpdateService;
	@Autowired
	QuestionDeleteService questionDeleteService;
	@RequestMapping("questionList")
	public String qaList(@RequestParam(value="page", required = false, defaultValue = "1" ) int page,
			@RequestParam(value="searchWord" , required = false) String searchWord, 
			@RequestParam(value="courseNum") String courseNum, Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		model.addAttribute("grade", auth.getGrade());
		questionListService.execute(searchWord, page, model);
		model.addAttribute("courseNum", courseNum);
		return "thymeleaf/question/questionList";
	}
	
	@GetMapping("questionRegist")
	public String form(@RequestParam(value="courseNum")String courseNum, HttpSession session, QuestionCommand questionCommand, Model model) {
		questionAutoNumService.execute(model);
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		model.addAttribute("studentNum", auth.getUserNum());
		model.addAttribute("courseNum",courseNum);
		return "thymeleaf/question/questionForm";
	}
	
	@PostMapping("questionRegist")
	public String from(@Validated QuestionCommand questionCommand, BindingResult result) {
		if (result.hasErrors()) {
		return "thymeleaf/question/questionForm";
		}
		questionInsertService.execute(questionCommand);
		String courseNum = questionCommand.getCourseNum();
	return "redirect:questionList?courseNum="+courseNum;
	}
	
	@RequestMapping("questionDetail")
	public String questionDetail(HttpSession session, @RequestParam(value = "questionNum") Integer questionNum, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		model.addAttribute("grade", auth.getGrade());
		questionDetailService.execute(questionNum, model);
		return "thymeleaf/question/questionDetail";
	}
	
	@RequestMapping("questionDelete")
	public String questionDelete(
			@RequestParam(value="questionNum") Integer questionNum,
			@RequestParam(value="courseNum") String courseNum) {
		questionDeleteService.execute(questionNum);
		return "redirect:questionList?courseNum="+courseNum;
	}		
	
	@RequestMapping(value = "answerRegister", method = RequestMethod.GET)
	public String answerForm(@RequestParam(value="questionNum")Integer questionNum, Model model, QuestionCommand questionCommand) {
		questionDetailService.execute(questionNum, model);
		return "thymeleaf/question/answerRegister";
	}
	@PostMapping("answerRegister")
	public String answerRegister (@Validated QuestionCommand questionCommand, BindingResult result) {
		if (result.hasErrors()) {	
			return "thymeleaf/question/answerRegister";
		}
		Integer questionNum = questionCommand.getQuestionNum();
		answerRegisterService.execute(questionNum, questionCommand);
		return "redirect:questionDetail?questionNum="+questionCommand.getQuestionNum();
		
	}	
	@RequestMapping(value = "answerUpdate", method = RequestMethod.GET)
	public String answerUpdateForm(@RequestParam(value="questionNum")Integer questionNum, QuestionCommand questionCommand, Model model) {
		questionDetailService.execute(questionNum, model);
		return "thymeleaf/question/answerUpdate";
	}
	@PostMapping("answerUpdate")
	public String answerUpdate (@Validated QuestionCommand questionCommand, BindingResult result) {
		if (result.hasErrors()) {	
			return "thymeleaf/question/answerUpdate";
		}
		Integer questionNum = questionCommand.getQuestionNum();
		answerUpdateService.execute(questionNum,questionCommand);
		return "redirect:questionDetail?questionNum="+questionCommand.getQuestionNum();
		
	}
}
