package controller.board_messenger;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.MessengerBoard;
import model.service.MessengerBoardManager;

public class ShowMBoardListController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		MessengerBoardManager manager = MessengerBoardManager.getInstance();
		
		int department_no = Integer.parseInt(request.getParameter("department_no"));
		
		List<MessengerBoard> boardList = manager.boardList(department_no);
		
		request.setAttribute("boardList", boardList);
		
		return "/view/board/messenger/list.jsp";
	}
	
}
