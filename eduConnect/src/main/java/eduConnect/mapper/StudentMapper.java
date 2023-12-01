package eduConnect.mapper;

import org.apache.ibatis.annotations.Mapper;

import eduConnect.domain.StudentDTO;

@Mapper
public interface StudentMapper {
	public int studentInsert(StudentDTO dto);
	public String studentAutoNum();
	public StudentDTO studentSelectOne(String studentNum);
}
