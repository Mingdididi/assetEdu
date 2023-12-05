package eduConnect.mapper;

import org.apache.ibatis.annotations.Mapper;

import eduConnect.domain.AttendDTO;

@Mapper
public interface AttendMapper {
	public void attendWrite(AttendDTO attDTo);
	public void attendUpdate(AttendDTO attDTo);
}
