package controller.board_messenger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.customer.CustomerSessionUtils;
import model.MessengerBoard;
import model.service.MessengerBoardManager;

public class ConnectMessengerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MessengerBoard board = null;
		MessengerBoardManager manager = MessengerBoardManager.getInstance();
		
		int messenger_connect_board_no = Integer.parseInt(request.getParameter("messenger_connect_board_no"));
		int department_no = Integer.parseInt(request.getParameter("department_no"));
		String customerId = CustomerSessionUtils.getLoginCustomerId(request.getSession());
		
		
		try {
			board = manager.connectURL(department_no, messenger_connect_board_no, customerId);
			
		} catch (Exception e) {
			return "redirect:/view/board/messenger/list";
		}
		
		request.setAttribute("board", board);
		
		return "/view/board/messenger/connect.jsp";
	}

}
