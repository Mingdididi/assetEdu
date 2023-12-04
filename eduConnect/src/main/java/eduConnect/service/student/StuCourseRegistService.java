package eduConnect.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.domain.StuCourseDTO;
import eduConnect.mapper.StudentMyMapper;

@Service
public class StuCourseRegistService {
	@Autowired
	StudentMyMapper studentMyMapper;
	public void execute(String studentNum, String courseNum) {
		StuCourseDTO dto = new StuCourseDTO();
		dto.setCourseNum(courseNum);
		dto.setStudentNum(studentNum);
		studentMyMapper.stuCourseRegist(dto);
	}
}
