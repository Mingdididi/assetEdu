package eduConnect.service.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.CourseDTO;
import eduConnect.domain.QuestionDTO;
import eduConnect.domain.StudentDTO;
import eduConnect.domain.TeacherDTO;
import eduConnect.mapper.CourseMapper;
import eduConnect.mapper.QuestionMapper;
import eduConnect.mapper.StudentMapper;
import eduConnect.mapper.TeacherMapper;

@Service
public class QuestionDetailService {
	@Autowired
	QuestionMapper questionMapper;
	@Autowired
	StudentMapper studentMapper;
	@Autowired
	CourseMapper courseMapper;
	@Autowired
	TeacherMapper teacherMapper;
	public void execute(Integer questionNum, Model model) {
		QuestionDTO dto = questionMapper.questionOneSelect(questionNum);
		StudentDTO stu = studentMapper.studentSelectOne(dto.getStudentNum());
		dto.setStudentName(stu.getStudentName());
		model.addAttribute("studentName", stu.getStudentName());
		model.addAttribute("questionCommand", dto);		
		model.addAttribute("teacherName", dto.getTeacherName());
	}
}
