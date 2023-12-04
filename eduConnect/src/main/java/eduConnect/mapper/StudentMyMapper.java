package eduConnect.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import eduConnect.domain.StuCourseDTO;
import eduConnect.domain.StuCoursePlusDTO;
import eduConnect.domain.StudentDTO;
@Mapper
public interface StudentMyMapper {
	public StudentDTO studentMyInfo(String studentId);
	public void studentUpdate(StudentDTO dto);
	public void studentDelete(String studentNum);
	public List<StuCoursePlusDTO> stuCourseList(String studentNum);
	public void stuCourseRegist(StuCourseDTO dto);
}
