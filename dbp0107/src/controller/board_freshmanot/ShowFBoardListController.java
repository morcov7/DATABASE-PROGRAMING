package controller.board_freshmanot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.FreshmanOTBoard;
import model.service.FreshmanOTBoardManager;

public class ShowFBoardListController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		FreshmanOTBoardManager manager = FreshmanOTBoardManager.getInstance();
		
		int department_no = Integer.parseInt(request.getParameter("department_no"));

		List<FreshmanOTBoard> boardList = manager.boardList(department_no);

		request.setAttribute("boardList", boardList);
		
		return "/view/board/freshmanot/list.jsp";
	}
	

}