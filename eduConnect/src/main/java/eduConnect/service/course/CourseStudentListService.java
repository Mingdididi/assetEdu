package eduConnect.service.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.CourseStudentDTO;
import eduConnect.domain.StudentDTO;
import eduConnect.mapper.CourseMapper;
import eduConnect.mapper.StudentMapper;
import eduConnect.service.attend.AttendRatioService;

@Service
public class CourseStudentListService {
	@Autowired
	CourseMapper courseMapper;
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	AttendRatioService attendRatioService;
	
	public void execute(String courseNum, Model model) {
		List<CourseStudentDTO> courseStu = courseMapper.courseStudent(courseNum);
		List<StudentDTO> studentInfos = new ArrayList<StudentDTO>();
		for( CourseStudentDTO dto: courseStu) {
			StudentDTO stuDto = new StudentDTO();
			stuDto =	studentMapper.studentSelectOne(dto.getStudentNum());
			stuDto.setAttendRatio(attendRatioService.execute(courseNum, dto.getStudentNum(), model));
			studentInfos.add(stuDto);
		}
		model.addAttribute("studentInfos",studentInfos);
		model.addAttribute("courseStu", courseStu);
	}
}
