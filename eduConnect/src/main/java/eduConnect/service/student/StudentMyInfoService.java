package eduConnect.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.command.StudentCommand;
import eduConnect.domain.AuthInfoDTO;
import eduConnect.domain.StudentDTO;
import eduConnect.mapper.StudentMyMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class StudentMyInfoService {
	@Autowired
	StudentMyMapper studentMyMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("auth");
		String studentId = authInfo.getUserId();
		StudentDTO dto =  studentMyMapper.studentMyInfo(studentId);	
		model.addAttribute("dto", dto);
		}
}
