package controller.board_freshmanot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.FreshmanOTBoard;
import model.service.FreshmanOTBoardManager;

public class ShowFBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		FreshmanOTBoard board = null;
		FreshmanOTBoardManager manager = FreshmanOTBoardManager.getInstance();
		
		int department_no = Integer.parseInt(request.getParameter("department_no"));
		int freshmanOT_board_no = Integer.parseInt(request.getParameter("freshmanOT_board_no"));

		try {
			board = manager.showDetail(department_no, freshmanOT_board_no);

		} catch (Exception e) {
			return "redirect:/view/board/freshmanot/list";
		}
		
		request.setAttribute("board", board);
		
		return "/view/board/freshmanot/detail.jsp";
	}

}

