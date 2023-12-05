package eduConnect.mapper;

import java.util.List; 

import org.apache.ibatis.annotations.Mapper;

import eduConnect.domain.CourseDTO;
import eduConnect.domain.CourseStudentDTO;
@Mapper
public interface CourseMapper {
	public int courseInsert(CourseDTO dto);
	public List<CourseDTO> selectAll(String teacherNum);
	public List<CourseDTO> allTheCourse();
	public CourseDTO selectOne(String num);
	public void courseUpdate(CourseDTO dto);
	public void courseDel(String num);
	public List<CourseStudentDTO> courseStudent(String courseNum);

}
