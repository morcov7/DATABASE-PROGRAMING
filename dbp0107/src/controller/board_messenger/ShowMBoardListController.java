package controller.board_messenger;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import controller.customer.CustomerSessionUtils;
import model.ApplicationBoard;
import model.service.MessengerBoardManager;

public class ShowMBoardListController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MessengerBoardManager manager = MessengerBoardManager.getInstance();
		
		int depart_no = Integer.parseInt(request.getParameter("depart_no"));
		
		List<ApplicationBoard> boardList = manager.boardList(depart_no);
		request.setAttribute("curUserId", 
				CustomerSessionUtils.getLoginCustomerId(request.getSession()));		
		request.setAttribute("boardList", boardList);
		
		return "/view/board/showBoard.jsp";
	}
	
}
