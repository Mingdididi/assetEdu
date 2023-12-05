package eduConnect.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import eduConnect.domain.AttendDTO;

@Mapper
public interface AttendMapper {
	public void attendWrite(AttendDTO attDTo);
	public void attendUpdate(AttendDTO attDTo);
	public List<AttendDTO> attendList(
			@Param("courseNum") String courseNum, 
			@Param("studentNum") String studentNum);
}
