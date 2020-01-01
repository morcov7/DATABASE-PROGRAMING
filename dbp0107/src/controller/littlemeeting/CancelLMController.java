package controller.littlemeeting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.customer.CustomerSessionUtils;
import model.LmManage;
import model.MessengerBoard;
import model.service.LmManager;
import model.service.MessengerBoardManager;

public class CancelLMController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LmManage lman = null;
		LmManager manager = LmManager.getInstance();
	  	String customerId = CustomerSessionUtils.getLoginCustomerId(request.getSession());
	  	int littlemeeting_no = Integer.parseInt(request.getParameter("littlemeeting_no"));	
	  	
		lman = new LmManage(
	  			Integer.parseInt(request.getParameter("littlemeeting_no")),
	  			0,
	  			customerId);
	  	
	  	 
		manager.deleteLmMan(lman); 	
	
		manager.cancel(littlemeeting_no);

		return "/lm/cancelComplete.jsp";			
	}
}
