package eduConnect.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("courseStu")
public class CourseStudentDTO {
	String courseNum;
	String studentNum;
}
