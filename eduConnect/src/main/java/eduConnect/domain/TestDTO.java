package eduConnect.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("test")
public class TestDTO {
	Integer sessionNum;
	Integer  testQuestionNum;
	String  testQuestionContent;
	Integer  testQuestionAnswer;
	Date testDate;
	String  courseNum;
	String testNum;
}
