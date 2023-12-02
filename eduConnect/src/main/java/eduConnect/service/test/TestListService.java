package eduConnect.service.test;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class TestListService {
	public void execute(String courseNum, Model model) {
		model.addAttribute("courseNum",courseNum);
	}
}
