package controller.board_messenger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.ApplicationBoard;
import model.service.MessengerBoardManager;

public class ShowMBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ApplicationBoard board = null;
		MessengerBoardManager manager = MessengerBoardManager.getInstance();
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int department_no = Integer.parseInt(request.getParameter("department_no"));
		
		
		try {
			board = manager.showDetail(department_no, board_no);

		} catch (Exception e) {
			return "redirect:/view/board/messenger/list";
		}
		
		request.setAttribute("board", board);
		
		return "/view/board/messenger/detail.jsp";
	}

}
