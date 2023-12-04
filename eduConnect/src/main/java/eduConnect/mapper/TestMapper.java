package eduConnect.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import eduConnect.domain.TestDTO;

@Mapper
public interface TestMapper {
	public String testAutoNum();
	public void testWrite(TestDTO testDto);
	public void testQuestionWrite(TestDTO testDto);
	public String [] testList(String courseNum);
	public List<TestDTO> testSelectOne(@Param("courseNum") String courseNum, @Param("sessionNum") String sessionNum);
	public void testDelete (String testNum);

}
