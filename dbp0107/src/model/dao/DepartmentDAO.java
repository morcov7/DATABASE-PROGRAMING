package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Department;

//학과 select 모든 학과 출력.
//상세보기가 board겠지?
//
public class DepartmentDAO {
	private JDBCUtil jdbcUtil = null;

	public DepartmentDAO() {
		jdbcUtil = new JDBCUtil();
	}

	// main
	public List<Department> departList() throws SQLException {

		// notice_board_no title createtime department_no name

		String sql = "SELECT department_no, dept_name FROM department";

		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil에 update문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Department> departList = new ArrayList<Department>();
			while (rs.next()) {
				Department department = new Department(
							rs.getInt("department_no"),
							rs.getString("dept_name"));
				departList.add(department);
			}
			return departList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	/*
	 * // board/notice/list/departmentno = ? & boardno = ? public NoticeBoard
	 * showDetail(int depart_no, int board_no) throws SQLException {
	 * 
	 * // b.notice_board_no = 2 AND b.department_no = 9" String sql =
	 * "SELECT b.notice_board_no, b.title, b.contents, b.createtime," +
	 * "b.department_no, c.name AS customer_name" + "FROM messenger_connect_board b"
	 * + "INNER JOIN customer c ON b.customer_no = c.customer_no" +
	 * "WHERE b.department_no =?" + "ORDER BY b.createtime DESC";
	 * 
	 * Object[] param1 = new Object[] { depart_no }; Object[] param2 = new Object[]
	 * { board_no };
	 * 
	 * jdbcUtil.setSqlAndParameters(sql, param1, param2); try { ResultSet rs =
	 * jdbcUtil.executeQuery(); if (rs.next()) { java.text.DateFormat df = new
	 * java.text.SimpleDateFormat("yyyy/MM/dd"); java.util.Date utilDate = new
	 * java.util.Date(rs.getDate("createtime").getTime()); String date =
	 * df.format(utilDate); NoticeBoard board = new
	 * NoticeBoard(rs.getInt("notice_board_no"), rs.getString("title"),
	 * rs.getString("contents"), date, rs.getInt("department_no"),
	 * rs.getString("customer_name"));
	 * 
	 * return board; } } catch (Exception ex) { ex.printStackTrace(); } finally {
	 * jdbcUtil.close(); } return null; }
	 */

}
