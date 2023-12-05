package eduConnect.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Alias("courseStu")
@Data
public class CourseStudentDTO {
	String courseNum;
	String studentNum;
}
