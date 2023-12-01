package eduConnect.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.CourseDTO;
import eduConnect.mapper.CourseMapper;

@Service
public class CourseDetailService {
	@Autowired
	CourseMapper courseMapper;
	public void execute(Model model, String num) {
		CourseDTO dto = courseMapper.selectOne(num);
		model.addAttribute("dto" , dto);
		
	}

}
