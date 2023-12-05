package eduConnect.service.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.CourseDTO;
import eduConnect.mapper.CourseMapper;
import eduConnect.mapper.StudentMyMapper;

@Service
public class CourseDetailService {
	@Autowired
	CourseMapper courseMapper;
	@Autowired
	StudentMyMapper studentMyMapper;
	public void execute(Model model, String num, String studentNum) {
		CourseDTO dto = courseMapper.selectOne(num);
		int registered = studentMyMapper.studentCourseRegistered(studentNum, num);
		model.addAttribute("courseRegisterd", registered);
		model.addAttribute("dto" , dto);
	}

}
