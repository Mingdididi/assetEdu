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
		studentMyMapper.courseStuAdd(dto);
		// 이미 있는 test에 대하여 결석을 부여하는 코드
		int sessionNums [] = studentMyMapper.testSelect(studentNum);
		if(sessionNums.length != 0) {
			for(int sessionNum : sessionNums) {
				studentMyMapper.attendInsert(studentNum, sessionNum, courseNum);
			}
		}
		
	}
}
