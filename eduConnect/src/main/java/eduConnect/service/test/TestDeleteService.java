package eduConnect.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.command.TestCommand;
import eduConnect.mapper.TestMapper;

@Service
public class TestDeleteService {
	@Autowired
	TestMapper testMapper;
	
	public void execute(String testNum) {
		testMapper.testDelete(testNum);
	}
}
