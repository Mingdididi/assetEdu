package eduConnect.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("course")
public class CourseDTO {
	String courseNum;
	String courseName;
	String courseContent;
	String teacherNum;

}
