package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.board_freshmanot.*;
import controller.board_messenger.*;
import controller.board_notice.*;
import controller.club.*;
import controller.customer.*;
import controller.home.ShowHomeController;
import controller.littlemeeting.*;
import controller.testmain.*;

public class RequestMapping {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

	// 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
	private Map<String, Controller> mappings = new HashMap<String, Controller>();

	public void initMapping() {
		// 각 uri에 대응되는 controller 객체를 생성 및 저장
		mappings.put("/", new ForwardController("index.jsp"));

		/* mappings.put("/main", new ForwardController("/main.jsp")); */
		mappings.put("/main", new ShowHomeController());

		mappings.put("/customer/login/form", new ForwardController("/customer/loginForm.jsp"));
		mappings.put("/customer/login", new LoginController());
		mappings.put("/customer/logout", new LogoutController());
		mappings.put("/customer/list", new ListCustomerController());
		mappings.put("/customer/view", new ViewCustomerController());
		mappings.put("/customer/register/form", new RegisterCustomerController());
		mappings.put("/customer/register", new RegisterCustomerController());
		mappings.put("/customer/update/form", new UpdateCustomerFormController());
		mappings.put("/customer/update", new UpdateCustomerController());
		mappings.put("/customer/delete", new DeleteCustomerController());

		mappings.put("/view/testMain", new ShowMainController());

		mappings.put("/view/board/notice/list", new ShowNBoardListController());
		mappings.put("/view/board/notice/detail", new ShowNBoardController());

		mappings.put("/view/board/messenger/list", new ShowMBoardListController());
		mappings.put("/view/board/messenger/detail", new ShowMBoardController());
		mappings.put("/view/board/messenger/connect", new ConnectMessengerController());

		mappings.put("/view/board/freshmanot/list", new ShowFBoardListController());
		mappings.put("/view/board/freshmanot/detail", new ShowFBoardController());

		mappings.put("/club/recommend", new ShowClubRecommendController());
		mappings.put("/club/list", new ShowClubListController());
		mappings.put("/club/detail", new ShowClubDetailController());
		mappings.put("/club/create/form", new CreateClubController());
		mappings.put("/club/create", new CreateClubController());
		mappings.put("/club/update/form", new UpdateClubController());
		mappings.put("/club/update", new UpdateClubController());
		mappings.put("/club/delete", new DeleteClubController());

		mappings.put("/littlemeeting/list", new ShowLMListController());
		mappings.put("/littlemeeting/detail", new ShowLMDetailController());

		mappings.put("/littlemeeting/update/form", new UpdateLMController());
		mappings.put("/littlemeeting/update", new UpdateLMController());

		mappings.put("/littlemeeting/apply", new ApplyLMController());

		mappings.put("/littlemeeting/cancel", new CancelLMController());
		mappings.put("/littlemeeting/delete", new DeleteLMController());

		mappings.put("/littlemeeting/write/form", new ForwardController("/lm/writeForm.jsp"));
		mappings.put("/littlemeeting/write", new CreateLMController());
		
		
		logger.info("Initialized Request Mapping!");
	}

	public Controller findController(String uri) {
		// 주어진 uri에 대응되는 controller 객체를 찾아 반환
		return mappings.get(uri);
	}
}