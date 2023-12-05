package eduConnect.command;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class QuestionCommand {
	String courseNum;
	Integer questionNum;
	String studentNum;
	String studentName;
	@NotEmpty(message = "제목을 입력해주세요.")
	String questionSubject;
	Date questionDate;
	@Size(min = 2, max = 500)
	String questionContent;
	String teacherNum;
	String answerContent;
	Date answerDate;
	Date updateDate;
	
}
