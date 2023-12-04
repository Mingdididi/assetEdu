package eduConnect.service.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.mapper.QuestionMapper;

@Service
public class QuestionDeleteService {
	@Autowired
	QuestionMapper questionMapper;
	public void execute(String questionNum) {
		questionMapper.questionDelete(questionNum);
	}
}
