package eduConnect.service.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.AuthInfoDTO;
import eduConnect.domain.TeacherDTO;
import eduConnect.mapper.TeacherMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class TeacherDetailService {
	@Autowired
	TeacherMapper teacherMapper ;
	public void execute(String teacherNum, Model model) {
		TeacherDTO vo = teacherMapper.teacherOneSelect(teacherNum);
		model.addAttribute("teacherCommand", vo);
	}
	
}
