package controller.littlemeeting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.customer.CustomerSessionUtils;
import model.LmManage;
import model.service.LmManager;

public class ApplyLMController implements Controller {

	  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
	    	LmManage lman = null;
	    	LmManager manager = LmManager.getInstance();
		  	String customerId = CustomerSessionUtils.getLoginCustomerId(request.getSession());
		  	
		  	
		  	lman = new LmManage(
		  			Integer.parseInt(request.getParameter("littlemeeting_no")),
		  			1,
		  			customerId);
		  	
		  	
			manager.createLmMan(lman); 	
	
			manager.apply(lman);

							
			return "/lm/applyComplete.jsp";
	    }
	
}
