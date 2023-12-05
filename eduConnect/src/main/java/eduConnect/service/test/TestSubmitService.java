package eduConnect.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.command.TestCommand;
import eduConnect.domain.AuthInfoDTO;
import eduConnect.domain.TestDTO;
import eduConnect.mapper.TestMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class TestSubmitService {
	@Autowired
	TestMapper testMapper;
	
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
		
		
	}
}
