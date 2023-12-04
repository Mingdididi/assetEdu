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
	@GetMapping("questionList")
	public String qaList(@RequestParam(value="page", required = false, defaultValue = "1" ) int page,
			@RequestParam(value="searchWord" , required = false) String searchWord,
			Model model) {
		questionListService.execute(searchWord, page, model);
		return "thymeleaf/teacher/questionList";
	}
	
	@GetMapping("questionRegist")
	public String form(HttpSession session, QuestionCommand questionCommand, Model model) {
		questionAutoNumService.execute(questionCommand, model);
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		model.addAttribute("studentNum", auth.getUserNum());
		return "thymeleaf/question/questionForm";
	}
	
	@PostMapping("questionRegist")
	public String from(@Validated QuestionCommand questionCommand, BindingResult result) {
		if (result.hasErrors()) {
		return "thymeleaf/question/questionForm";
		}
		questionInsertService.execute(questionCommand);
	return "redirect:questionList";
	}
	
	@RequestMapping("questionDetail")
	public String questionDetail(HttpSession session, @RequestParam(value = "questionNum") String questionNum, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		model.addAttribute("grade", auth.getGrade());
		questionDetailService.execute(questionNum, model);
		return "thymeleaf/teacher/questionDetail";
	}
	
	@RequestMapping("questionDelete")
	public String questionDelete(
			@RequestParam(value="questionNum") String questionNum) {
		questionDeleteService.execute(questionNum);
		return "redirect:questionList";
	}		
	
	@RequestMapping(value = "answerRegister", method = RequestMethod.GET)
	public String answerForm(QuestionCommand questionCommand, Model model) {
		return "thymeleaf/question/answerRegister";
	}
	@PostMapping("answerRegister")
	public String answerRegister (@Validated QuestionCommand questionCommand, BindingResult result) {
		if (result.hasErrors()) {	
			return "thymeleaf/question/answerRegister";
		}
		answerRegisterService.execute(questionCommand);
		return "redirect:questionDetail";
		
	}
	
	@RequestMapping(value = "answerUpdate", method = RequestMethod.GET)
	public String answerUpdateForm(QuestionCommand questionCommand, Model model) {
		return "thymeleaf/teacher/answerUpdate";
	}
	@PostMapping("answerUpdate")
	public String answerUpdate (@Validated QuestionCommand questionCommand, BindingResult result) {
		if (result.hasErrors()) {	
			return "thymeleaf/teacher/answerUpdate";
		}
		answerUpdateService.execute(questionCommand);
		return "redirect:questionDetail";
		
	}
}
