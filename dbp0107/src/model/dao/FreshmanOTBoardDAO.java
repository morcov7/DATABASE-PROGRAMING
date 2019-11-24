package model.dao;

import java.sql.*;
import java.util.*;

import model.FreshmanOTBoard;

public class FreshmanOTBoardDAO {
	private JDBCUtil jdbcUtil = null;

	public FreshmanOTBoardDAO() {
		jdbcUtil = new JDBCUtil();
	}

	// board/freshmanot/list/departmentno = ?
	public List<FreshmanOTBoard> boardList(int department_no) throws SQLException {

		// freshmanOT_board_no title createtime department_no name

		/*
		 * SELECT b.freshmanOT_board_no, b.title, b.createtime, b.department_no, c.name
		 * AS customer_name FROM freshmanOT_board b INNER JOIN customer c ON
		 * b.customer_no = c.customer_no WHERE b.department_no = 1
		 */

		String sql = "SELECT b.freshmanOT_board_no, b.title, b.createtime, "
				+ "b.department_no, c.name AS customer_name " 
				+ "FROM freshmanOT_board b "
				+ "INNER JOIN customer c ON b.customer_no = c.customer_no " 
				+ "WHERE b.department_no = ? ";

		Object[] param = new Object[] { department_no };

		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 update문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<FreshmanOTBoard> boardList = new ArrayList<FreshmanOTBoard>();

			while (rs.next()) {
				FreshmanOTBoard board = new FreshmanOTBoard(rs.getInt("freshmanOT_board_no"), rs.getString("title"),
						rs.getDate("createtime"), rs.getInt("department_no"), rs.getString("customer_name"));

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

	// board/freshmanot/list/departmentno = ? & boardno = ?
	public FreshmanOTBoard showDetail(int department_no, int freshmanOT_board_no) throws SQLException {

		// b.freshmanOT_board_no = 2 AND b.department_no = 9"
		String sql = "SELECT b.freshmanOT_board_no, b.title, b.contents, b.createtime, "
				+ "b.application_check, b.department_no, c.name AS customer_name " 
				+ "FROM freshmanOT_board b "
				+ "INNER JOIN customer c ON b.customer_no = c.customer_no " 
				+ "WHERE b.department_no = ?"
				+ "AND b.freshmanOT_board_no = ? ";

		Object[] param = new Object[] { department_no, freshmanOT_board_no };
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				FreshmanOTBoard board = new FreshmanOTBoard(
						rs.getInt("freshmanOT_board_no"), 
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

}
