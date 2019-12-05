package controller.club;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Club;
import model.Department;
import model.service.ClubManager;
import model.service.MainManager;
import model.service.ExistingClubException;

public class CreateClubController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(CreateClubController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
 		if (request.getMethod().equals("GET")) {
		  MainManager man = MainManager.getInstance();
		  
		  List<Department> departList = man.departList();
		  request.setAttribute("departList", departList); return "/club/create.jsp";
		  
 		}
 		
 		//POST면
		Club club = new Club(
				Integer.parseInt(request.getParameter("department_no")),
				request.getParameter("club_name"), 
				request.getParameter("title"), 
				request.getParameter("contents"));
		try {
			ClubManager manager = ClubManager.getInstance();
			manager.create(club);
			
			log.debug("Create Club : {}", club);
			return "redirect:/club/list"; //성공시
			
		} catch (ExistingClubException e) { //예외 발생시
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("club", club);
			return "/club/create.jsp";
		}
	}

}
