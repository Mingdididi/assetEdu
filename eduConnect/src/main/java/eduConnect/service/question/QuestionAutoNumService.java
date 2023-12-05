package eduConnect.service.question;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.mapper.QuestionMapper;

@Service
public class QuestionAutoNumService {
	@Autowired
	QuestionMapper questionMapper;
	public void execute(Model model) {
		String questionNum = questionMapper.autoNum();
		model.addAttribute("questionNum",questionNum);
	}
}
