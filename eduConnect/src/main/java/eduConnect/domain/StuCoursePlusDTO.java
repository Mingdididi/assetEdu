package eduConnect.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("stuCourseList")
public class StuCoursePlusDTO {
	String studentNum;
	CourseDTO courseDTO;
	String teacherName;
}
