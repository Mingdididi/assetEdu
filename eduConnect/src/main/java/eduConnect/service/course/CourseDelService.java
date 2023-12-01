package eduConnect.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.mapper.CourseMapper;

@Service
public class CourseDelService {
	@Autowired
	CourseMapper courseMapper;
	public void execute(String courseNum) {
		courseMapper.courseDel(courseNum);
		
	}

}
