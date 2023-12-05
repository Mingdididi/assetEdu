package eduConnect.service.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.command.TestCommand;
import eduConnect.domain.AttendDTO;
import eduConnect.domain.AuthInfoDTO;
import eduConnect.domain.TestDTO;
import eduConnect.mapper.AttendMapper;
import eduConnect.mapper.TestMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class TestSubmitService {
	@Autowired
	TestMapper testMapper;
	@Autowired
	AttendMapper attendMapper;
	
	public void execute(TestCommand testCommand, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String studentNum = auth.getUserNum();
		
		
		for(int i : testCommand.getTestQuestionNum()) {
			TestDTO dto = new TestDTO();
			dto.setTestNum(testCommand.getTestNum());
			dto.setTestQuestionNum(i);
			dto.setCourseNum(testCommand.getCourseNum());
			dto.setStudentNum(studentNum);
			dto.setTestQuestionAnswer(testCommand.getTestQuestionAnswer()[i-1]);
			testMapper.testSubmit(dto);
		}
		
		// 결과에 따라 출석 OR 결석 나눔
		String sessionNum = String.valueOf(testCommand.getSessionNum());
		String courseNum = testCommand.getCourseNum();
		List<TestDTO> list = testMapper.answerResult(sessionNum, courseNum, studentNum);
		int totalQuestion = 0;
		int rightAnswer = 0;
		for(TestDTO dto : list) {
			totalQuestion += 1;
			if(dto.getTestQuestionAnswer().equals(dto.getStudentAnswer())) {
			 rightAnswer += 1;
			}
	}
	int score = (int)((double)rightAnswer/totalQuestion *100);
	if(score >= 60) {
	AttendDTO attDto = new AttendDTO();
	attDto.setSessionNum(Integer.parseInt(sessionNum));
	attDto.setCourseNum(courseNum);
	attDto.setStudentNum(studentNum);
	attendMapper.attendUpdate(attDto);
	}
	}
}
