package eduConnect.service.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.CourseStudentDTO;
import eduConnect.mapper.CourseMapper;

@Service
public class CourseStudentListService {
	@Autowired
	CourseMapper courseMapper;
	public void execute(String courseNum, Model model) {
		List<CourseStudentDTO> courseStu = courseMapper.courseStudent(courseNum);
		model.addAttribute("courseStu", courseStu);
	}
}
