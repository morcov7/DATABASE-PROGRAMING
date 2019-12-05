package controller.littlemeeting;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Lm;
import model.service.LmManager;

public class DeleteLMController implements Controller{
	  private static final Logger log = LoggerFactory.getLogger(DeleteLMController.class);
	  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
	    	
		  	int delete_no = Integer.parseInt(request.getParameter("littlemeeting_no"));
		  	log.debug("Delete lm : {}", delete_no);
		  	
		  	LmManager manager = LmManager.getInstance();
		  	  			 
		  	manager.delete(delete_no);
							
			return "redirect:/littlemeeting/list";				// 커뮤니티 보기 화면으로 이동
	    }

}




