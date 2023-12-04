package eduConnect.service.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.command.QuestionCommand;
import eduConnect.domain.QuestionDTO;
import eduConnect.mapper.QuestionMapper;

@Service
public class AnswerRegisterService {
	@Autowired 
	QuestionMapper questionMapper;
	public void execute(QuestionCommand questionCommand) {
		QuestionDTO dto=new QuestionDTO();
		dto.setAnswerContent(questionCommand.getAnswerContent());
		dto.setTeacherNum(questionCommand.getTeacherNum());
		questionMapper.answerRegist(dto);
	}
}
