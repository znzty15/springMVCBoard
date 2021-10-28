package com.javaGG.springMVCBoard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javaGG.springMVCBoard.dao.BDao;
import com.javaGG.springMVCBoard.dto.BDto;

public class BReplyViewCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BDto dto = dao.reply_View(bId);
		
		model.addAttribute("reply_view", dto);
	}

}
