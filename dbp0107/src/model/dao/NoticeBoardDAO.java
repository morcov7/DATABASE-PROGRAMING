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
	public List<NoticeBoard> boardList(int depart_no) throws SQLException {

		// notice_board_no title createtime department_no name

		String sql = "SELECT b.notice_board_no, b.title, b.createtime," 
				+ "b.department_no, c.name AS customer_name"
				+ "FROM notice_board b" 
				+ "INNER JOIN customer c ON b.customer_no = c.customer_no"
				+ "WHERE b.department_no =?";

		Object[] param = new Object[] { depart_no };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 update문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			jdbcUtil.setSqlAndParameters(sql, null);
			List<NoticeBoard> boardList = new ArrayList<NoticeBoard>();
			while (rs.next()) {
				java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy/MM/dd");
				java.util.Date utilDate = new java.util.Date(rs.getDate("createtime").getTime());
				String date = df.format(utilDate);

				NoticeBoard board = new NoticeBoard(rs.getInt("notice_board_no"), rs.getString("title"), date,
						rs.getInt("department_no"), rs.getString("customer_name"));

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
	public NoticeBoard showDetail(int depart_no, int board_no) throws SQLException {

		// b.notice_board_no = 2 AND b.department_no = 9"
		String sql = "SELECT b.notice_board_no, b.title, b.contents, b.createtime,"
				+ "b.department_no, c.name AS customer_name" + "FROM messenger_connect_board b"
				+ "INNER JOIN customer c ON b.customer_no = c.customer_no" + "WHERE b.department_no =?"
				+ "ORDER BY b.createtime DESC";

		Object[] param1 = new Object[] { depart_no };
		Object[] param2 = new Object[] { board_no };

		jdbcUtil.setSqlAndParameters(sql, param1, param2);
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy/MM/dd");
				java.util.Date utilDate = new java.util.Date(rs.getDate("createtime").getTime());
				String date = df.format(utilDate);
				NoticeBoard board = new NoticeBoard(rs.getInt("notice_board_no"), rs.getString("title"),
						rs.getString("contents"), date, rs.getInt("department_no"), rs.getString("customer_name"));

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
