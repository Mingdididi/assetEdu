package eduConnect.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.command.QuestionCommand;
import eduConnect.domain.QuestionDTO;
import eduConnect.mapper.QuestionMapper;

@Service
public class AnswerUpdateService {
	@Autowired 
	QuestionMapper questionMapper;
	public void execute(Integer questionNum, QuestionCommand questionCommand) {
		QuestionDTO dto=questionMapper.questionOneSelect(questionNum);
		dto.setAnswerContent(questionCommand.getAnswerContent());
		dto.setTeacherNum(questionCommand.getTeacherNum());
		questionMapper.answerUpdate(dto);
	}
}
