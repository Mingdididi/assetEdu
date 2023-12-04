package eduConnect.command;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class QuestionCommand {
	String questionNum;
	String studentNum;
	@NotEmpty(message = "제목을 입력해주세요.")
	String questionSubject;
	Date questionDate;
	@Size(min = 5, max = 500)
	String questionContent;
	String teacherNum;
	String answerContent;
	Date answerDate;
	Date updateDate;
	
}
