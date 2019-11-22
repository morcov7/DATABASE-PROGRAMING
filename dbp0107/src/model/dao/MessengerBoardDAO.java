package model.dao;

import java.sql.*;
import java.util.*;

import model.ApplicationBoard;

public class MessengerBoardDAO {
	private JDBCUtil jdbcUtil = null;

	public MessengerBoardDAO() {
		jdbcUtil = new JDBCUtil();
	}

	// board/messenger/list/departmentno = ?
	public List<ApplicationBoard> boardList(int depart_no) throws SQLException {

		// messenger_connect_board_no title createtime department_no name

		String sql = "SELECT b.messenger_connect_board_no, b.title, b.createtime,"
				+ "b.department_no, c.name AS customer_name" + "FROM messenger_connect_board b"
				+ "INNER JOIN customer c ON b.customer_no = c.customer_no" + "WHERE b.department_no =?";

		Object[] param = new Object[] { depart_no };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 update문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			jdbcUtil.setSqlAndParameters(sql, null);
			List<ApplicationBoard> boardList = new ArrayList<ApplicationBoard>();
			while (rs.next()) {
				java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy/MM/dd");
				java.util.Date utilDate = new java.util.Date(rs.getDate("createtime").getTime());
				String date = df.format(utilDate);

				ApplicationBoard board = new ApplicationBoard(rs.getInt("messenger_connect_board_no"),
						rs.getString("title"), date, rs.getInt("department_no"), rs.getString("customer_name"));

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

	// board/messenger/list/departmentno = ? & boardno = ?
	public ApplicationBoard showDetail(int depart_no, int board_no) throws SQLException {

		// b.messenger_connect_board_no = 2 AND b.department_no = 9"
		String sql = "SELECT b.messenger_connect_board_no, b.title, b.contents, b.createtime,"
				+ "b.application_check, b.department_no, c.name AS customer_name" + "FROM messenger_connect_board b"
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
				ApplicationBoard board = new ApplicationBoard(rs.getInt("messenger_connect_board_no"),
						rs.getString("title"), rs.getString("contents"), date, rs.getInt("application_check"),
						rs.getInt("department_no"), rs.getString("customer_name"));

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
