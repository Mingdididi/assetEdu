package eduConnect.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.command.TestCommand;
import eduConnect.domain.AttendDTO;
import eduConnect.domain.TestDTO;
import eduConnect.mapper.AttendMapper;
import eduConnect.mapper.TestMapper;

@Service
public class TestWriteService {
	@Autowired
	TestMapper testMapper;
	@Autowired
	AttendMapper attendMapper;
	
	public void execute(TestCommand testCommand) {
		TestDTO testDto = new TestDTO();
		testDto.setTestNum(testCommand.getTestNum());
		testDto.setSessionNum(testCommand.getSessionNum());
		testDto.setCourseNum(testCommand.getCourseNum());
		
		testMapper.testWrite(testDto);
		
		TestDTO testQuestionDto = new TestDTO();
		for(Integer i : testCommand.getTestQuestionNum() ) {
			testQuestionDto.setTestNum(testCommand.getTestNum());
			testQuestionDto.setTestQuestionNum(i);
			testQuestionDto.setTestQuestionContent(testCommand.getTestQuestionContent()[i-1]);
			testQuestionDto.setTestQuestionAnswer(testCommand.getTestQuestionAnswer()[i-1]);
			testMapper.testQuestionWrite(testQuestionDto);
		}
		// 해당 과목을 수강중인 학생들
		String studentNums [] = testMapper.studentSelect(testCommand.getCourseNum());
		if(studentNums.length != 0) {
			AttendDTO attDto = new AttendDTO();
			attDto.setCourseNum(testCommand.getCourseNum());
			attDto.setSessionNum(testCommand.getSessionNum());
			for(String studentNum : studentNums) {
				attDto.setStudentNum(studentNum);
				attendMapper.attendWrite(attDto);
			}
			
		}
		
	}
}
