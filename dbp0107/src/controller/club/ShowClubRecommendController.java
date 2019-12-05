package controller.club;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.customer.CustomerSessionUtils;
import model.Club;
import model.service.ClubManager;


public class ShowClubRecommendController  implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ClubManager manager = ClubManager.getInstance();
		
		String customerId = CustomerSessionUtils.getLoginCustomerId(request.getSession());
		
		List<Club> clubList = manager.showRecommend(customerId);
		request.setAttribute("clubList", clubList);
		
	    return "/club/recommend.jsp";
	}
}
