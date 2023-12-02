package eduConnect.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.command.CourseCommand;
import eduConnect.domain.CourseDTO;
import eduConnect.mapper.CourseMapper;

@Service
public class CourseModifyService {
	@Autowired
	CourseMapper courseMapper;
	
	public void execute(CourseCommand courseCommand) {
		CourseDTO dto = new CourseDTO();
		dto.setCourseContent(courseCommand.getCourseContent());
		dto.setCourseName(courseCommand.getCourseName());
		dto.setCourseNum(courseCommand.getCourseNum());
		dto.setTeacherNum(courseCommand.getTeacherNum());
		dto.setClassRoom(courseCommand.getClassRoom());
		courseMapper.courseUpdate(dto);
		
	}

}
