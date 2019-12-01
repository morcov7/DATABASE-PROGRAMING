package model.service;

import java.util.List;
import java.sql.SQLException;
import model.FreshmanOTBoard;
import model.dao.FreshmanOTBoardDAO;

public class FreshmanOTBoardManager {
	private static FreshmanOTBoardManager boardMan = new FreshmanOTBoardManager();
	private FreshmanOTBoardDAO boardDAO;

	private FreshmanOTBoardManager() {
	      try {
	          boardDAO = new FreshmanOTBoardDAO();
	       } catch (Exception e) {
	          e.printStackTrace();
	       }
	    }

	public static FreshmanOTBoardManager getInstance() {
		return boardMan;
	}

	public List<FreshmanOTBoard> boardList(int department_no) throws SQLException {
		return boardDAO.boardList(department_no);
	}

	public FreshmanOTBoard showDetail(int department_no, int freshmanOT_board_no) throws SQLException {
		FreshmanOTBoard board = boardDAO.showDetail(department_no, freshmanOT_board_no);

		return board;
	}

	public FreshmanOTBoardDAO getBoardDAO() {
		return this.boardDAO;
	}

}
