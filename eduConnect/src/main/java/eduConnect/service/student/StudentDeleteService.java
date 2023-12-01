package eduConnect.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.AuthInfoDTO;
import eduConnect.mapper.StudentMyMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class StudentDeleteService {
	@Autowired
	StudentMyMapper studentMyMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public int execute(String studentPw,HttpSession session, Model model) {
		AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
		if(passwordEncoder.matches(studentPw, auth.getUserPw())) {
			studentMyMapper.studentDelete(auth.getUserNum());
			return 1;
		}else {
			model.addAttribute("errPw", "비밀번호가 틀렸습니다.");
			return 0;
		}
	}
}
