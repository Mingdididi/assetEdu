package eduConnect.service.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.TestDTO;
import eduConnect.mapper.TestMapper;

@Service
public class StudentScoreService {
	@Autowired
	TestMapper testMapper;
	
	public void execute(String courseNum, String studentNum, Model model) {
		Integer sessionCount = testMapper.testSessionCount(courseNum);
		List<Integer> scores = new ArrayList<Integer>();
		for(int i = 0; i < sessionCount ; i++) {
			List<TestDTO> list = testMapper.answerResult(String.valueOf(i), courseNum, studentNum);
			int totalQuestionNum = 0;
			int rightAnswerNum = 0;
			for(TestDTO dto : list) {
				totalQuestionNum += 1;
				if(dto.getTestQuestionAnswer().equals(dto.getStudentAnswer())) {
					rightAnswerNum += 1;
				}
			}
			int score = (int)((double)rightAnswerNum/totalQuestionNum *100);
			scores.add(score);
		}
		Collections.reverse(scores);
		model.addAttribute("scores",scores);
		model.addAttribute("courseNum", courseNum);
	}
}
