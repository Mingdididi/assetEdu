package eduConnect.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import eduConnect.domain.AuthInfoDTO;

@Mapper
public interface FindMapper {
	public String findId(String userPhone, String userEmail);
	public AuthInfoDTO userEmail(@Param("_userId") String userId,
								 @Param("_userPhone") String userPhone);
}
