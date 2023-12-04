package eduConnect.service.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.command.TestCommand;
import eduConnect.domain.TestDTO;
import eduConnect.mapper.TestMapper;

@Service
public class TestWriteService {
	@Autowired
	TestMapper testMapper;
	
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
		
		
	}
}
