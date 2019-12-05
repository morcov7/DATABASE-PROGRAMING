package controller.littlemeeting;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Lm;
import model.service.LmManager;

public class UpdateLMController implements Controller {
	
	
	  private static final Logger log = LoggerFactory.getLogger(UpdateLMController.class);

	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
	 
	    	int littlemeeting_no = Integer.parseInt(request.getParameter("littlemeeting_no"));
			
			if (request.getMethod().equals("GET")) {	
	    		// GET request: 커뮤니티 수정 form 요청	
	    		LmManager manager = LmManager.getInstance();
				Lm lm  = manager.ShowLMDetail(littlemeeting_no);	// 수정하려는 커뮤니티 정보 검색
				request.setAttribute("Lm", lm);			
				
				return "/lm/updateForm.jsp";   // 검색한 정보를 update form으로 전송     
		    }	
	    	
	    	// POST request (커뮤니티 정보가 parameter로 전송됨)
	    	Lm lm = new Lm(
	    		littlemeeting_no,
	    		request.getParameter("littlemeeting_name"),
	    		request.getParameter("title"),
	    		request.getParameter("contents"),
	    		Integer.parseInt(request.getParameter("max_num")));

	    	log.debug("Update Community : {}", lm);

			LmManager manager = LmManager.getInstance();
			manager.updateLm(lm);			
			return "redirect:/littlemeeting/list";	
	       		
	    }
	
	

}
