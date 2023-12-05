package eduConnect.domain;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Alias("question")
@Data
public class QuestionDTO {
	String courseNum;
	Integer questionNum;
	String studentNum;
	String studentName;
	String questionSubject;
	Date questionDate;
	String questionContent;
	String teacherNum;
	String teacherName;
	String answerContent;
	Date answerDate;
	Date updateDate;
}
