package controller.home;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.customer.CustomerSessionUtils;
import model.Department;
import model.service.MainManager;

public class ShowHomeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		if (!CustomerSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/customer/login/form"; // login form 요청으로 redirect
		}

		MainManager manager = MainManager.getInstance();

		List<Department> departList = manager.departList();

		request.setAttribute("departList", departList);
		request.setAttribute("curCustomerId", CustomerSessionUtils.getLoginCustomerId(request.getSession()));

		return "/main.jsp";
	}

}