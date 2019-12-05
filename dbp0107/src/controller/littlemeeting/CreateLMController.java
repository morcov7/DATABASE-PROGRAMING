package controller.littlemeeting;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.customer.CustomerSessionUtils;
import model.Lm;
import model.service.LmManager;

public class CreateLMController implements Controller{
	
	
	private static final Logger log = LoggerFactory.getLogger(CreateLMController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String customerId = CustomerSessionUtils.getLoginCustomerId(request.getSession());
    	
    	Lm lm = new Lm(
    		customerId,
    		request.getParameter("littlemeeting_name"), request.getParameter("title"), request.getParameter("contents"),
    		Integer.parseInt(request.getParameter("max_num")));
		try {
			LmManager manager = LmManager.getInstance();
			manager.createLM(lm);
		
	    	log.debug("Create littlemeeting : {}", lm);
	        return "redirect:/littlemeeting/list";	// 성공 시 커뮤니티 리스트 화면으로 redirect
	        
		} catch (Exception e) {		// 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("lm", lm);
			return "/lm/writeForm.jsp";
		}
    }

}
