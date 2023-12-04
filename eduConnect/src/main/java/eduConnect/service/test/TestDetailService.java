package eduConnect.service.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.TestDTO;
import eduConnect.mapper.TestMapper;

@Service
public class TestDetailService {
	@Autowired
	TestMapper testMapper;
	
	public void execute(String courseNum, String sessionNum, Model model) {
		
		List<TestDTO> dtos = testMapper.testSelectOne(courseNum, sessionNum);
		
		
		model.addAttribute("dtos", dtos);
	}
}
