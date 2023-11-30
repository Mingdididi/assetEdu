package eduConnect.domain;


import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("teacher")
public class TeacherDTO {
	String teacherNum;
	String teacherId;
	String teacherPw;
	String teacherJumin;
	String teacherAddr;
	String teacherAddrDetail;
	String teacherPhone;
	String teacherEmail;
	String teacherName;
	Date teacherRegister;
	String teacherPost;
	
	
	

}