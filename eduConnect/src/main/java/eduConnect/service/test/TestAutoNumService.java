package eduConnect.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.mapper.TestMapper;

@Service
public class TestAutoNumService {
	@Autowired
	TestMapper testMapper;
	public void execute(Model model) {
		String testNum = testMapper.testAutoNum();
		model.addAttribute("testNum", testNum);
	}
}
