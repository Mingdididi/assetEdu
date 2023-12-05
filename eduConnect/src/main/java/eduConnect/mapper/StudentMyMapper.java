package eduConnect.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import eduConnect.domain.StuCourseDTO;
import eduConnect.domain.StuCoursePlusDTO;
import eduConnect.domain.StudentDTO;
@Mapper
public interface StudentMyMapper {
	public StudentDTO studentMyInfo(String studentId);
	public void studentUpdate(StudentDTO dto);
	public void studentDelete(String studentNum);
	public List<StuCoursePlusDTO> stuCourseList(String studentNum);
	public int studentCourseRegistered(@Param("studentNum")String studentNum, @Param("courseNum")String courseNum);
	public void stuCourseRegist(StuCourseDTO dto);
	public void courseStuAdd(StuCourseDTO dto);
	public String [] testSelect(String studentNum);
	public void attendInsert(@Param("studentNum") String studentNum, 
							@Param("sessionNum") int sessionNum
							,@Param("courseNum") String courseNum);
}
