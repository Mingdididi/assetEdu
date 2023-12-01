package eduConnect.command;

import java.util.Date;  

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StudentCommand {
	String studentNum;
	@NotEmpty(message="아이디를 입력하세요")
	String studentId;
	@Pattern(regexp="^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[!@#$%^&*?]).{8,}$", message="영문자와 숫자 특수문자가 포함된 8글자 이상")
	String studentPw;
	@NotBlank(message="비밀번호 확인을 입력해주세요")
	String studentPwCon;
	String studentName;
	@NotEmpty(message="주소를 입력하세요")
	String studentAddr;
	String studentAddr2;
	String studentPost;
	String studentGender;
	@NotEmpty(message="연락처를 입력하세요")
	String studentPhone;
	@NotEmpty(message="이메일을 입력하세요")
	String studentEmail;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="생년월일을 입력하세요")
	Date studentBirth;
	public boolean isstudentPwEqualstudentPwCon() {
		return studentPw.equals(studentPwCon);
	} 
}
