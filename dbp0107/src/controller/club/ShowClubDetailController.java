package controller.club;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Club;
import model.service.ClubManager;

public class ShowClubDetailController  implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Club club = null;
		ClubManager manager = ClubManager.getInstance();
		int club_no = Integer.parseInt(request.getParameter("club_no"));
		club = manager.showDetail(club_no);
		
		// commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
		request.setAttribute("club", club);				
		return "/club/detail.jsp";  
	}
}
