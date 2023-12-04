package eduConnect.service.question;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.command.QuestionCommand;
import eduConnect.mapper.QuestionMapper;

@Service
public class QuestionAutoNumService {
	@Autowired
	QuestionMapper questionMapper;
	public void execute(QuestionCommand questionCommand, Model model) {
		String questionNum = questionMapper.autoNum();
		questionCommand.setQuestionNum(questionNum);
		model.addAttribute("questionCommand",questionCommand);
	}
}
