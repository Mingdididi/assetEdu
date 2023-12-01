package eduConnect.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import eduConnect.domain.CourseDTO;

@Mapper
public interface CourseMapper {
	public int courseInsert(CourseDTO dto);
	public List<CourseDTO> selectAll(String teacherNum);
	public CourseDTO selectOne(String num);
	public void courseUpdate(CourseDTO dto);


}
