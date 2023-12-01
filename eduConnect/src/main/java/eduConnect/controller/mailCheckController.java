package eduConnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eduConnect.service.student.EmailCheckService;

@RestController //return값에 html이나 redirect를 보내지 못함)
public class mailCheckController {
	@Autowired
	EmailCheckService emailCheckService;
	@RequestMapping(value="checkRest/userEmailCheck",method=RequestMethod.POST)
	public String userEmailCheck(@RequestParam(value="userEmail") String userEmail) {
		String resultEmail=emailCheckService.execute(userEmail);
		if(resultEmail==null) {
			return "사용가능한 이메일입니다.";
		}else {
			return "사용중인 이메일입니다.";
		}
	}

}
