package eduConnect.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import eduConnect.domain.StartEndPageDTO;
import eduConnect.domain.TeacherDTO;

@Mapper
public interface TeacherMapper {
	public String autoNum();
	public void teacherInsert(TeacherDTO dto);
	public List<TeacherDTO> teacherAllSelect(StartEndPageDTO vo);
	public Integer teacherCount(String searchWord);
	public TeacherDTO teacherOneSelect(String teacherNum);
	public void teacherUpdate(TeacherDTO dto);
	public void teacherDelete(String teacherNum);
}
