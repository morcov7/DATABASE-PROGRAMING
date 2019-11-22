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

	public List<NoticeBoard> boardList(int depart_no) throws SQLException {
		return boardDAO.boardList(depart_no);
	}

	public NoticeBoard showDetail(int depart_no, int board_no) throws SQLException {
		NoticeBoard board = boardDAO.showDetail(depart_no, board_no);

		return board;
	}

	public NoticeBoardDAO getBoardDAO() {
		return this.boardDAO;
	}

}
