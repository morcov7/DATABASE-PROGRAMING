package controller.littlemeeting;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.customer.CustomerSessionUtils;
import model.Lm;
import model.service.LmManager;

public class ShowLMListController implements Controller {
	
	 public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception {
			
		 	
	    	LmManager manager = LmManager.getInstance();
			List<Lm> lmList = manager.findLMList();
			
			// commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
			request.setAttribute("lmList", lmList);				
			return "/lm/list.jsp";        	
	    }	
}
