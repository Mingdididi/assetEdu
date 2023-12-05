package eduConnect.service.attend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eduConnect.mapper.AttendMapper;

@Service
public class AttendListService {
	@Autowired
	AttendMapper attendMapper;
	
	public void execute(String courseNum) {
		//attendMapper.attendList();
	}
}
