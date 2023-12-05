package eduConnect.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.StuCoursePlusDTO;
import eduConnect.mapper.CourseMapper;
import eduConnect.mapper.StudentMyMapper;

@Service
public class StuCourseListService {
	@Autowired
	StudentMyMapper studentMyMapper;
	@Autowired
	CourseMapper courseMapper;
	public void execute(String studentNum, Model model) {
		List<StuCoursePlusDTO> courses = studentMyMapper.stuCourseList(studentNum);
		model.addAttribute("courses", courses);
		
	}
}
