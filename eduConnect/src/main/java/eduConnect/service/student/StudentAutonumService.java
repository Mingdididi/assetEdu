package eduConnect.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.command.StudentCommand;
import eduConnect.mapper.StudentMapper;

@Service
public class StudentAutonumService {
	@Autowired
	StudentMapper studentMapper;
	public void execute(StudentCommand studentCommand, Model model) {
		String studentNum = studentMapper.studentAutoNum();
		studentCommand.setStudentNum(studentNum);
	}
}
