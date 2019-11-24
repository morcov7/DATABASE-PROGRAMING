package model.dao;

import java.sql.*;
import java.util.*;

import model.NoticeBoard;

public class NoticeBoardDAO {

	private JDBCUtil jdbcUtil = null;

	public NoticeBoardDAO() {
		jdbcUtil = new JDBCUtil();
	}

	// board/notice/list/departmentno = ?
	public List<NoticeBoard> boardList(int department_no) throws SQLException {

		// notice_board_no title createtime department_no name
		String sql = "SELECT b.notice_board_no, b.title, b.createtime, " 
				+ "b.department_no, c.name AS customer_name "
				+ "FROM notice_board b " 
				+ "INNER JOIN customer c ON b.customer_no = c.customer_no "
				+ "WHERE b.department_no =? ";
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] { department_no }); // JDBCUtil에 update문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<NoticeBoard> boardList = new ArrayList<NoticeBoard>();
			
			while (rs.next()) {
				NoticeBoard board = new NoticeBoard(
						rs.getInt("notice_board_no"),
						rs.getString("title"), 
						rs.getDate("createtime"),
						rs.getInt("department_no"),
						rs.getString("customer_name"));
				boardList.add(board);
			}
			return boardList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// board/notice/list/departmentno = ? & boardno = ?
	public NoticeBoard showDetail(int department_no, int notice_board_no) throws SQLException {

		/*
		 * SELECT b.notice_board_no, b.title, b.contents, b.createtime, b.department_no,
		 * c.name AS customer_name 
		 * FROM notice_board b 
		 * INNER JOIN customer c 
		 * ON b.customer_no = c.customer_no 
		 * WHERE b.department_no = 1 
		 * AND b.notice_board_no= 5 
		 * ORDER BY b.createtime DESC
		 */
		
		String sql = "SELECT b.notice_board_no, b.title, b.contents, b.createtime, " + 
				"b.department_no, c.name AS customer_name " + 
				"FROM notice_board b " + 
				"INNER JOIN customer c ON b.customer_no = c.customer_no " + 
				"WHERE b.department_no = ? " +
				"AND b.notice_board_no = ? " ;

		 		
		Object[] param = new Object[] { department_no, notice_board_no };
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				NoticeBoard board = new NoticeBoard(
						rs.getInt("notice_board_no"),
						rs.getString("title"),
						rs.getString("contents"),
						rs.getDate("createtime"),
						rs.getInt("department_no"),
						rs.getString("customer_name"));

				return board;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

}
