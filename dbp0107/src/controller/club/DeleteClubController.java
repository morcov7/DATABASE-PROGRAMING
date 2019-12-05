package controller.club;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.ClubManager;

public class DeleteClubController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(DeleteClubController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int club_no = Integer.parseInt(request.getParameter("club_no"));
		log.debug("Delete Club : {}", club_no);
		
		ClubManager manager = ClubManager.getInstance();
		manager.remove(club_no);
		
		return "redirect:/club/list";
	}

}
