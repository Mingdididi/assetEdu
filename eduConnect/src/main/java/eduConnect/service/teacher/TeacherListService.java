package eduConnect.service.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import eduConnect.domain.StartEndPageDTO;
import eduConnect.domain.TeacherDTO;
import eduConnect.mapper.TeacherMapper;

@Service
public class TeacherListService {
	@Autowired
	TeacherMapper teacherMapper;
	
	public void execute(String searchWord,int page, Model model) {
		int limit = 10;
		int limitPage = 10;
		int stratRow = (page - 1) *  limit + 1;
		int endRow = stratRow + limit - 1;
		StartEndPageDTO vo = new StartEndPageDTO();
		vo.setStartRow(stratRow); 
		vo.setEndRow(endRow);
		vo.setSearchWord(searchWord);
		List<TeacherDTO> list = teacherMapper.teacherAllSelect(vo);
		model.addAttribute("list", list);
		model.addAttribute("searchWord", searchWord);
		
		int count = teacherMapper.teacherCount(searchWord);
		int maxPage = (int)((double)count / limit + 0.99);
		int startPage =  (int)((double) page / limitPage + 0.95 -1 ) * limitPage + 1;
		int endPage = startPage + limitPage - 1;
		if(maxPage < endPage) endPage = maxPage;

		model.addAttribute("page", page);
		model.addAttribute("stratRow", stratRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("count", count);

	}
}
