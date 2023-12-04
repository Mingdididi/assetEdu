package eduConnect.domain;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Alias("question")
@Data
public class QuestionDTO {
	String questionNum;
	String studentNum;
	String questionSubject;
	Date questionDate;
	String questionContent;
	String teacherNum;
	String answerContent;
	Date answerDate;
	Date updateDate;
}
