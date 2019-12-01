package controller.board_notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.NoticeBoard;
import model.service.NoticeBoardManager;

public class ShowNBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NoticeBoard board = null;
		NoticeBoardManager manager = NoticeBoardManager.getInstance();
		
		int department_no = Integer.parseInt(request.getParameter("department_no"));
		int notice_board_no = Integer.parseInt(request.getParameter("notice_board_no"));
		
		
		try {
			board = manager.showDetail(department_no, notice_board_no);

		} catch (Exception e) {
			return "redirect:/view/board/notice/list";
		}
		
		request.setAttribute("board", board);
	
		
		return "/view/board/notice/detail.jsp";
	}

}

