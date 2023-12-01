package eduConnect.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Alias("authInfo")
@NoArgsConstructor
public class AuthInfoDTO {
	String userNum;
	String userId;
	String userPw;
	String userName;
	String grade;
	String userEmail;
	String userEmailCheck;
	
	String tableName;
	String pwColumName;
	String userIdColumName;
	
	   public AuthInfoDTO(String userNum, String userId, String userPw, String userName, String grade, String userEmail, String userEmailCheck) {
	        this.userNum = userNum;
	        this.userId = userId;
	        this.userPw = userPw;
	        this.userName = userName;
	        this.grade = grade;
	        this.userEmail = userEmail;
	        this.userEmailCheck= userEmailCheck;
	    }
	
	}
