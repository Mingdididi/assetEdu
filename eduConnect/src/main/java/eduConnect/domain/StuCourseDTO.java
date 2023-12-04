package eduConnect.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Alias("stuCourse")
@Data
public class StuCourseDTO {
	String studentNum;
	String courseNum;
}
