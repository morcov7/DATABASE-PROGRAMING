package model.service;

import java.util.List;
import java.sql.SQLException;
import model.ApplicationBoard;
import model.dao.FreshmanOTBoardDAO;

public class FreshmanotBoardManager {
	private static FreshmanotBoardManager boardMan = new FreshmanotBoardManager();
	private FreshmanOTBoardDAO boardDAO;

	private FreshmanotBoardManager() {
}

	public static FreshmanotBoardManager getInstance() {
		return boardMan;
	}

	public List<ApplicationBoard> boardList(int department_no) throws SQLException {
		return boardDAO.boardList(department_no);
	}

	public ApplicationBoard showDetail(int department_no, int board_no) throws SQLException {
		ApplicationBoard board = boardDAO.showDetail(department_no, board_no);

		return board;
	}

	public FreshmanOTBoardDAO getBoardDAO() {
		return this.boardDAO;
	}

}
