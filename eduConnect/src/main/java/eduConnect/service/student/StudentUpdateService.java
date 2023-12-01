package eduConnect.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.command.StudentCommand;
import eduConnect.domain.StudentDTO;
import eduConnect.mapper.StudentMyMapper;

@Service
public class StudentUpdateService {
	@Autowired
	StudentMyMapper studentMyMapper;
	public void execute(StudentCommand studentCommand) {
		StudentDTO dto = new StudentDTO();
		dto.setStudentAddr(studentCommand.getStudentAddr());
		dto.setStudentAddrDetail(studentCommand.getStudentAddr2());
		dto.setStudentBirth(studentCommand.getStudentBirth());
		dto.setStudentEmail(studentCommand.getStudentEmail());
		dto.setStudentName(studentCommand.getStudentName());
		dto.setStudentPhone(studentCommand.getStudentPhone());		
		dto.setStudentPost(studentCommand.getStudentPost());
		studentMyMapper.studentUpdate(dto);
	}
}
