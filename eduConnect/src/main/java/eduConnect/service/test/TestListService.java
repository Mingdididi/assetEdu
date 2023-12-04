package eduConnect.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.mapper.TestMapper;

@Service
public class TestListService {
	@Autowired
	TestMapper testMapper;
	
	public void execute(String courseNum, Model model) {
		
		String sessionNums [] = testMapper.testList(courseNum);
		
		model.addAttribute("courseNum",courseNum);
		model.addAttribute("sessionNums", sessionNums);
	}
}
