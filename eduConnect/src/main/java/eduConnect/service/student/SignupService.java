package eduConnect.service.student;

import java.util.Date; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.command.StudentCommand;
import eduConnect.domain.StudentDTO;
import eduConnect.mapper.StudentMapper;
import eduConnect.mapper.UserMapper;
/*import eduConnect.service.EmailSendService;*/

@Service
public class SignupService {
	@Autowired
	PasswordEncoder passwordEncoder;
	/*@Autowired
	UserMapper userMapper;
	@Autowired
	JavaMailSender mailSender;*/
	@Autowired
	StudentMapper studentMapper;
	/*@Autowired
	EmailSendService emailSendService;*/
	public void execute(StudentCommand studentCommand, Model model) {
		String studentNum = studentCommand.getStudentNum();
		String studentId = studentCommand.getStudentId();
		String studentPw = studentCommand.getStudentPw();
		String studentName = studentCommand.getStudentName();
		String studentPhone = studentCommand.getStudentPhone();
		String studentAddr = studentCommand.getStudentAddr();
		String studentAddrDetail = studentCommand.getStudentAddr2();
		String studentPost = studentCommand.getStudentPost();
		String studentEmail = studentCommand.getStudentEmail();
		Date studentBirth = studentCommand.getStudentBirth();
		String studentGender = studentCommand.getStudentGender();
		
		StudentDTO dto = new StudentDTO();
		dto.setStudentNum(studentNum);
		dto.setStudentId(studentId);
		dto.setStudentPw(passwordEncoder.encode(studentPw));
		dto.setStudentName(studentName);
		dto.setStudentPhone(studentPhone);
		dto.setStudentAddr(studentAddr);
		dto.setStudentAddrDetail(studentAddrDetail);
		dto.setStudentPost(studentPost);
		dto.setStudentEmail(studentEmail);
		dto.setStudentGender(studentGender);
		dto.setStudentBirth(studentBirth);
		
		int i=studentMapper.studentInsert(dto);
		
		/*`model.addAttribute("userName", dto.getStudentName());
		model.addAttribute("userEmail",dto.getStudentEmail());
		if(i>=1) {
			//메일링
			String html="<html><body>"+"회원가입축하.<br/>"+"가입완료하려면 <a href='http://localhost:8080/userConfirm?chk="+dto.getStudentEmail()+
					"'>여기</a>를 눌러주세요.";
			String subject="환영인사";
			String fromEmail="hiland00@gmail.com";
			String toEmail=dto.getStudentEmail();
			emailSendService.mailSend(html,subject,fromEmail,toEmail);
		}*/
	}
}
