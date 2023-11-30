package eduConnect.service.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.command.TeacherCommand;
import eduConnect.domain.TeacherDTO;
import eduConnect.mapper.TeacherMapper;

@Service
public class TeacherUpdateservice {
	@Autowired
	TeacherMapper teacherMapper;
	
	public void execute(TeacherCommand teacherCommand) {
		TeacherDTO dto = new TeacherDTO();
		dto.setTeacherNum(teacherCommand.getTeacherNum());
		dto.setTeacherJumin(teacherCommand.getTeacherJumin());
		dto.setTeacherAddr(teacherCommand.getTeacherAddr());
		dto.setTeacherAddrDetail(teacherCommand.getTeacherAddrDetail());
		dto.setTeacherPhone(teacherCommand.getTeacherPhone());
		dto.setTeacherEmail(teacherCommand.getTeacherEmail());
		dto.setTeacherName(teacherCommand.getTeacherName());
		dto.setTeacherPost(teacherCommand.getTeacherPost());

		teacherMapper.teacherUpdate(dto);
	}
}
