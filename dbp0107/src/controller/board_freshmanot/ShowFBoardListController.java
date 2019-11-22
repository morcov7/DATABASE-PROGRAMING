package controller.board_freshmanot;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.customer.CustomerSessionUtils;
import model.ApplicationBoard;
import model.service.FreshmanotBoardManager;

public class ShowFBoardListController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		FreshmanotBoardManager manager = FreshmanotBoardManager.getInstance();
		
		int departNo = Integer.parseInt(request.getParameter("depart_no"));

		List<ApplicationBoard> boardList = manager.boardList(departNo);
		/*
		 * request.setAttribute("curUserId",
		 * CustomerSessionUtils.getLoginCustomerId(request.getSession()));
		 */
		request.setAttribute("boardList", boardList);
		
		return "/view/board/freshmanot/list.jsp";
	}
	

}