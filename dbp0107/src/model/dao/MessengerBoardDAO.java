package model.dao;

import java.sql.*;
import java.util.*;

import model.MessengerBoard;

public class MessengerBoardDAO {
	private JDBCUtil jdbcUtil = null;

	public MessengerBoardDAO() {
		jdbcUtil = new JDBCUtil();
	}

	// board/messenger/list/departmentno = ?
	public List<MessengerBoard> boardList(int department_no) throws SQLException {

		// messenger_connect_board_no title createtime department_no name

		String sql = "SELECT b.messenger_connect_board_no, b.title, b.createtime, "
				+ "b.department_no, c.name AS customer_name " 
				+ "FROM messenger_connect_board b "
				+ "INNER JOIN customer c ON b.customer_no = c.customer_no " 
				+ "WHERE b.department_no = ? ";

		Object[] param = new Object[] { department_no };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 update문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<MessengerBoard> boardList = new ArrayList<MessengerBoard>();
			
			while (rs.next()) {
				MessengerBoard board = new MessengerBoard(
						rs.getInt("messenger_connect_board_no"),
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

	// board/messenger/list/departmentno = ? & boardno = ?
	public MessengerBoard showDetail(int department_no, int messenger_connect_board_no) throws SQLException {

		// b.messenger_connect_board_no = 2 AND b.department_no = 9"
		String sql = "SELECT b.messenger_connect_board_no, b.title, b.contents, b.createtime, "
				+ "b.application_check, b.department_no, c.name AS customer_name " 
				+ "FROM messenger_connect_board b "
				+ "INNER JOIN customer c ON b.customer_no = c.customer_no " 
				+ "WHERE b.department_no = ? "
				+ "AND b.messenger_connect_board_no = ? " ;

		
		Object[] param = new Object[] { department_no, messenger_connect_board_no };
		jdbcUtil.setSqlAndParameters(sql, param);
		
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				MessengerBoard board = new MessengerBoard(
						rs.getInt("messenger_connect_board_no"),
						rs.getString("title"),
						rs.getString("contents"), 
						rs.getDate("createtime"),
						rs.getInt("application_check"),
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
	
	//메신저 연결 - 학과별 url 
	public  MessengerBoard connectURL(int department_no, int messenger_connect_board_no, String customerId) throws SQLException {

		// b.department_no = 1
		String sql = "SELECT b.title, d.url, c.name AS customer_name "
				+ "FROM messenger_connect_board b "
				+ "LEFT JOIN department d ON b.department_no = d.department_no "
				+ "INNER JOIN customer c ON b.customer_no = c.customer_no " 
				+ "WHERE b.department_no = ? "
				+ "AND b.messenger_connect_board_no = ? ";

		Object[] param = new Object[] { department_no, messenger_connect_board_no };
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				MessengerBoard board = new MessengerBoard(
						rs.getString("title"),
						rs.getString("url"),
						rs.getString("customer_name"),
						customerId);
				
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
