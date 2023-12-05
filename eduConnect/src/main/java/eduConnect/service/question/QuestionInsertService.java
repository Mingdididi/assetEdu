package eduConnect.service.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import eduConnect.command.QuestionCommand;
import eduConnect.domain.QuestionDTO;
import eduConnect.mapper.QuestionMapper;

@Service
public class QuestionInsertService {
	@Autowired
	QuestionMapper questionMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(QuestionCommand questionCommand) {
		QuestionDTO dto = new QuestionDTO();
		dto.setQuestionNum(questionCommand.getQuestionNum());
		dto.setStudentNum(questionCommand.getStudentNum());;
		dto.setQuestionSubject(questionCommand.getQuestionSubject());
		dto.setQuestionContent(questionCommand.getQuestionContent());
		dto.setQuestionDate(questionCommand.getQuestionDate());
		dto.setCourseNum(questionCommand.getCourseNum());
		questionMapper.questionInsert(dto);
	}
}
