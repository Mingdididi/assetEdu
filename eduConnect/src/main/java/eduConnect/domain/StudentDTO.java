package eduConnect.domain;


import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Alias("student")
@Data
public class StudentDTO {
	String studentNum;
	String studentName;
	String studentId;
	String studentPw;
	Date studentBirth;
	String studentEmail;
	String studentGender;
	String studentPhone;
	String studentAddr;
	String studentAddrDetail;
	String studentPost;
	String studentEmailConfig;
	
	int attendRatio;
}
