package controller.littlemeeting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.customer.CustomerSessionUtils;
import model.Lm;
import model.service.LmManager;

public class ShowLMDetailController implements Controller {
	
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
    	
    	String customerId = CustomerSessionUtils.getLoginCustomerId(request.getSession());
    	
    	Lm lm = null;
		LmManager manager = LmManager.getInstance();
		int littlemeeting_no = Integer.parseInt(request.getParameter("littlemeeting_no"));
		lm = manager.ShowLMDetail(littlemeeting_no);	// 커뮤니티 정보 검색
		request.setAttribute("littlemeeting", lm); // 커뮤니티 정보 저장	
		
		if(lm.getWriter_id().equals(customerId))
			return "/lm/writeComplete.jsp";
		
		else
			return "/lm/detail.jsp";				// 커뮤니티 보기 화면으로 이동
    }
}
