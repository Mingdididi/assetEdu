package eduConnect.service.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.AuthInfoDTO;
import eduConnect.domain.CourseDTO;
import eduConnect.mapper.CourseMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class CourseListService {
	@Autowired
	CourseMapper courseMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		String teacherNum = auth.getUserNum();
		List<CourseDTO>list = courseMapper.selectAll(teacherNum);
		model.addAttribute("dtos", list);
		
		
	}

}
