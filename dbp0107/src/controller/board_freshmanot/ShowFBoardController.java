package controller.board_freshmanot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ApplicationBoard;
import model.service.FreshmanotBoardManager;

public class ShowFBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ApplicationBoard board = null;
		FreshmanotBoardManager manager = FreshmanotBoardManager.getInstance();
		
		int department_no = Integer.parseInt(request.getParameter("department_no"));
		int boardNo = Integer.parseInt(request.getParameter("board_no"));

		try {
			board = manager.showDetail(department_no, boardNo);

		} catch (Exception e) {
			return "redirect:/view/board/freshmanot/list";
		}
		
		request.setAttribute("board", board);
		
		return "/view/board/freshmanot/detail.jsp";
	}

}

