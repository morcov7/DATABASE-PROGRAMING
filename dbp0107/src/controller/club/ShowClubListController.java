package controller.club;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Club;
import model.service.ClubManager;

public class ShowClubListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ClubManager manager = ClubManager.getInstance();
		List<Club> clubList = manager.showClubList();
		
		// clubList 객체를 request에 저장하여 club 리스트 화면으로 이동(forwarding)
		request.setAttribute("clubList", clubList);				
		return "/club/list.jsp";  
	}
}