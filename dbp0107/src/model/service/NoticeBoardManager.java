package model.service;

import java.util.List;

import model.NoticeBoard;
import model.dao.NoticeBoardDAO;

import java.sql.SQLException;

public class NoticeBoardManager {

	private static NoticeBoardManager boardMan = new NoticeBoardManager();
	private NoticeBoardDAO boardDAO;

	private NoticeBoardManager() {
		try {
			boardDAO = new NoticeBoardDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static NoticeBoardManager getInstance() {
		return boardMan;
	}

	public List<NoticeBoard> boardList(int department_no) throws SQLException {
		return boardDAO.boardList(department_no);
	}

	public NoticeBoard showDetail(int department_no, int notice_board_no) throws SQLException {
		NoticeBoard board = boardDAO.showDetail(department_no, notice_board_no);

		return board;
	}

	public NoticeBoardDAO getBoardDAO() {
		return this.boardDAO;
	}

}
