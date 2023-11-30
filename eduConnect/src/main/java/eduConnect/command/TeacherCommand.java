package eduConnect.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TeacherCommand {
	String teacherNum;
	@NotEmpty(message = "아이디를 입력해주세요. ")
	@Size(min = 8, max = 12)
	String teacherId;
	@Pattern(regexp = "^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-+]).{8,}$", 
			 message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상")
	String teacherPw;
	@NotEmpty(message = "비밀번호확인 입력하여 주세요.")
	String teacherPwCon;
	@NotBlank(message = "이름을 입력하여 주세요.")
	String teacherName;
	@NotBlank(message = "주소를 입력하여 주세요.")
	String teacherAddr;
	String teacherAddrDetail;
	String teacherPost;
	@NotBlank(message = "연락처을 입력하여 주세요.")
	String teacherPhone;
	@Email(message = "형식에 맞지 않습니다.")
	@NotEmpty(message = "이메일을 입력하여 주세요.")
	String teacherEmail;
	@NotEmpty(message = "주민번호를 입력하여 주세요.")
	String teacherJumin;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date teacherRegister;
	
	public boolean isteacherPwEqualsteacherPwCon() {
		return teacherPw.equals(teacherPwCon);
	}
}