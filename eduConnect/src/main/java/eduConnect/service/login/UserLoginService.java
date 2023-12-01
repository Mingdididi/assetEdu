package eduConnect.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import eduConnect.command.LoginCommand;
import eduConnect.domain.AuthInfoDTO;
import eduConnect.mapper.UserMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class UserLoginService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute(LoginCommand loginCommand
			, HttpSession session, BindingResult result, HttpServletResponse response) {
		String userId = loginCommand.getUserId();
		String userPw = loginCommand.getUserPw();
		AuthInfoDTO dto = userMapper.loginSelect(userId);
		System.out.println("userId : " + userId);
		// 입력된 아이디 값이 있을 때
		// 아이디 값을 입력하지 않으면 dto가 생성되지 않기 때문에 밑에서 오류남
		if(userId != "" && userId != null) {
		//dto가 생성이 되었고 null이 아닐 때 (아이디가 존재한다는 뜻)
			if(dto != null) {
					if(passwordEncoder.matches(userPw, dto.getUserPw())) {
						System.out.println("비밀번호가 일치");
						// 입력값과 DB에 있는 비밀번호가 일치하면 session에 auth 추가
						session.setAttribute("auth", dto);
						
						if(loginCommand.getIdStore() != null && loginCommand.getIdStore()) {
							// 쿠키 생성
							Cookie cookie = new Cookie("idStore", loginCommand.getUserId());
							// 저장 경로
							cookie.setPath("/");
							// 수명 주기
							cookie.setMaxAge(60*60*24*30);
							// 사용자에게 전송
							response.addCookie(cookie);							
						}else {
							Cookie cookie = new Cookie("idStore", loginCommand.getUserId());
							cookie.setPath("/");
							cookie.setMaxAge(0);
							response.addCookie(cookie);	
						}
						if(loginCommand.getAutoLogin() != null && loginCommand.getAutoLogin()) {
							// 쿠키 생성
							Cookie cookie = new Cookie("autoLogin", loginCommand.getUserId());
							// 저장 경로
							cookie.setPath("/");
							// 수명 주기
							cookie.setMaxAge(60*60*24*30);
							// 사용자에게 전송
							response.addCookie(cookie);							
						}
					}else {
						System.out.println("비밀번호가 일치하지 않을 때");
						result.rejectValue("userPw", "loginCommand.userPw"
								,"비밀번호가 틀렸습니다.");
					}
			}else {
				System.out.println("아이디가 존재 하지 않았을 때");
				result.rejectValue("userId", "loginCommand.userId","아이디가 존재하지 않는다");
			}
		}
	}
}