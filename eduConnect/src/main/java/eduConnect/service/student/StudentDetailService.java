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
public class StudentDetailService {
	@Autowired
	StudentMyMapper studentMyMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfoDTO authInfo=(AuthInfoDTO) session.getAttribute("auth");
		String studentId=authInfo.getUserId();
		StudentDTO dto=studentMyMapper.studentMyInfo(studentId);
		StudentCommand studentCommand = new StudentCommand();
		studentCommand.setStudentAddr(dto.getStudentAddr());
		studentCommand.setStudentAddr2(dto.getStudentAddrDetail());
		studentCommand.setStudentBirth(dto.getStudentBirth());
		studentCommand.setStudentEmail(dto.getStudentEmail());
		studentCommand.setStudentGender(dto.getStudentGender());
		studentCommand.setStudentId(dto.getStudentId());
		studentCommand.setStudentName(dto.getStudentName());
		studentCommand.setStudentNum(dto.getStudentNum());
		studentCommand.setStudentPhone(dto.getStudentPhone());
		studentCommand.setStudentPost(dto.getStudentPost());
		model.addAttribute("studentCommand", studentCommand);
	}
}
