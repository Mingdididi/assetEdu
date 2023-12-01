package eduConnect.mapper;

import org.apache.ibatis.annotations.Mapper;

import eduConnect.domain.AuthInfoDTO;

@Mapper
public interface UserMapper {
//	public int userCkeckUpdate(String email);
	public AuthInfoDTO loginSelect(String userId);
}
