package eduConnect.service.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.command.TeacherCommand;
import eduConnect.mapper.TeacherMapper;

@Service
public class TeacherAutoNumService {
	@Autowired
	TeacherMapper teacherMapper;
	public void execute(TeacherCommand teacherCommand, Model model) {
		String teacherNum = teacherMapper.autoNum();
		teacherCommand.setTeacherNum(teacherNum);
		model.addAttribute("teacherCommand",teacherCommand);
	}
}
