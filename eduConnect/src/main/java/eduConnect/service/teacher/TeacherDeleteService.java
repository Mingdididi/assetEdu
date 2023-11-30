package eduConnect.service.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.mapper.TeacherMapper;

@Service
public class TeacherDeleteService {
	@Autowired
	TeacherMapper teacherMapper;
	public void execute(String teacherNum) {
		teacherMapper.teacherDelete(teacherNum);

	}
}
