package eduConnect.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.command.CourseCommand;
import eduConnect.domain.AuthInfoDTO;
import eduConnect.domain.CourseDTO;
import eduConnect.mapper.CourseMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class CourseWriteService {
	@Autowired
	CourseMapper courseMapper;
	public void execute(CourseCommand courseCommand, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		
		String courseName = courseCommand.getCourseName();
		String courseContent = courseCommand.getCourseContent();
		String teacherNum = auth.getUserNum();
		String courseUrl = courseCommand.getCourseUrl();
		
		CourseDTO dto= new CourseDTO();
		dto.setCourseName(courseName);
		dto.setCourseContent(courseContent);
		dto.setTeacherNum(teacherNum);
		dto.setCourseUrl(courseUrl);
		courseMapper.courseInsert(dto);
		
		
	}

}
