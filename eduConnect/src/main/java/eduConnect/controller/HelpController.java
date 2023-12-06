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

import eduConnect.command.FindIdCommand;
import eduConnect.service.help.FindIdService;

@Controller
@RequestMapping("help")
public class HelpController {
	@Autowired
	FindIdService findIdService;
	@RequestMapping(value="findId", method = RequestMethod.GET)
	public String findId(Model model) {
		model.addAttribute("findIdCommand", new FindIdCommand());
		return "thymeleaf/help/findId";
	}
	@RequestMapping(value="findId", method = RequestMethod.POST)
	public String findId(@Validated FindIdCommand findIdCommand,
			BindingResult result, Model model) {
		findIdService.execute(findIdCommand, model);
		if(result.hasErrors()) {
			return "thymeleaf/help/findId";
		}
		return "thymeleaf/help/findIdOk";
	}
}