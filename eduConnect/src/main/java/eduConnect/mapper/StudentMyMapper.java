package eduConnect.mapper;

import org.apache.ibatis.annotations.Mapper;

import eduConnect.domain.StudentDTO;
@Mapper
public interface StudentMyMapper {
	public StudentDTO studentMyInfo(String studentId);
	public int studentUpdate(StudentDTO dto);
	public int studentDelete(String studentNum);
}
