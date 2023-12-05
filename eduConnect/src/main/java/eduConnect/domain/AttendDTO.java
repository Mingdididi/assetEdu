package eduConnect.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("attend")
public class AttendDTO {
	String attendNum;
	String courseNum;
	String studentNum;
	Integer sessionNum;
	String attendStatus;
}
