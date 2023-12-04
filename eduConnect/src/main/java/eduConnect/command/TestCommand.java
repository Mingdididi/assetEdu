package eduConnect.command;

import java.util.Date;

import lombok.Data;

@Data
public class TestCommand {
	Integer sessionNum;
	Integer [] testQuestionNum;
	String [] testQuestionContent;
	Integer [] testQuestionAnswer;
	Date testDate;
	String  courseNum;
	String testNum;
}