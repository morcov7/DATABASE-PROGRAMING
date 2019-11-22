package controller.board_notice;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.NoticeBoard;
import model.service.NoticeBoardManager;

public class ShowNBoardListController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NoticeBoardManager manager = NoticeBoardManager.getInstance();
		
		int department_no = Integer.parseInt(request.getParameter("department_no"));

		List<NoticeBoard> boardList = manager.boardList(department_no);

		request.setAttribute("boardList", boardList);
		
		return "/view/board/notice/list.jsp";
	}
	

}