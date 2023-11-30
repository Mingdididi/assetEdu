package eduConnect.service.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import eduConnect.command.TeacherCommand;
import eduConnect.domain.TeacherDTO;
import eduConnect.mapper.TeacherMapper;

@Service
public class TeacherInsertService {
	@Autowired
	TeacherMapper teacherMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute(TeacherCommand teacherCommand) {
		TeacherDTO dto = new TeacherDTO();
		dto.setTeacherNum(teacherCommand.getTeacherNum());
		dto.setTeacherId(teacherCommand.getTeacherId());
		dto.setTeacherPw(passwordEncoder.encode(teacherCommand.getTeacherPw()));
		dto.setTeacherJumin(teacherCommand.getTeacherJumin());
		dto.setTeacherAddr(teacherCommand.getTeacherAddr());
		dto.setTeacherAddrDetail(teacherCommand.getTeacherAddrDetail());
		dto.setTeacherPhone(teacherCommand.getTeacherPhone());
		dto.setTeacherEmail(teacherCommand.getTeacherEmail());
		dto.setTeacherName(teacherCommand.getTeacherName());
		dto.setTeacherRegister(teacherCommand.getTeacherRegister());
		dto.setTeacherPost(teacherCommand.getTeacherPost());
		teacherMapper.teacherInsert(dto);
	}
}
