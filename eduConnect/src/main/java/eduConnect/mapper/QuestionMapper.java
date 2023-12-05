package eduConnect.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import eduConnect.domain.QuestionDTO;
import eduConnect.domain.StartEndPageDTO;
@Mapper
public interface QuestionMapper {
	public String autoNum();
	public void questionInsert(QuestionDTO dto);
	public List<QuestionDTO> questionAllSelect(StartEndPageDTO vo);
	public Integer questionCount(String searchWord);
	public QuestionDTO questionOneSelect(Integer questionNum);
	public void answerRegist(QuestionDTO dto);
	public void answerUpdate(QuestionDTO dto);
	public void questionDelete(Integer questionNum);
}
