package controller.board_freshmanot;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.customer.CustomerSessionUtils;
import model.ApplicationBoard;
import model.service.FreshmanotBoardManager;

public class ShowFBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ApplicationBoard board = null;
		FreshmanotBoardManager manager = FreshmanotBoardManager.getInstance();
		
		int departNo = Integer.parseInt(request.getParameter("depart_no"));
		int boardNo = Integer.parseInt(request.getParameter("board_no"));
		
		request.setAttribute("curUserId", 
				CustomerSessionUtils.getLoginCustomerId(request.getSession()));		
		
		try {
			board = manager.showDetail(departNo, boardNo);

		} catch (Exception e) {
			return "redirect:/view/board/list";
		}
		
		request.setAttribute("board", board);
		
		if (request.getParameter("updateFailed") != null) {
			// 수정 시도 실패
	    	request.setAttribute("exception", 
				new IllegalStateException("본인이 쓰지 않은 글은 수정할 수 없습니다."));            
			request.setAttribute("updateFailed", true);
		}
		else if (request.getParameter("deleteFailed") != null) {
			// 삭제 시도 실패	
	    	request.setAttribute("exception", new IllegalStateException("다른 사용자의 글은 삭제할 수 없습니다."));
			request.setAttribute("deleteFailed", true);
		}
		
		else if (request.getParameter("answerFailed") != null) {
			request.setAttribute("exception", new IllegalStateException("관리자만 답변할 수 있습니다."));
			request.setAttribute("answerFailed", true);
		}
		
		return "/view/board/freshmanot/detail.jsp";
	}

}

