package model.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Lm;
import model.LmManage;

public class LmDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	public LmDAO() {
		jdbcUtil = new JDBCUtil();	
	}
	
	
	/*public int create(Lm lm) throws SQLException {
	String sql = "INSERT INTO LITTLEMEETING VALUES (littlemeeting_seq.nextval, ?, ?, ?, SYSDATE, 0, ?, 0) ";		
	Object[] param = new Object[] {lm.getLittlemeeting_name(), lm.getTitle(), lm.getContents(), lm.getMax_num()};
								
	jdbcUtil.setSqlAndParameters(sql, param);
	// JDBCUtil 에 insert문과 매개 변수 설정
					
	try {
		int result= jdbcUtil.executeUpdate();
		return result;
	} catch (Exception ex) {
		jdbcUtil.rollback();
		ex.printStackTrace();
	} finally {		
		jdbcUtil.commit();
		jdbcUtil.close();	// resource 반환
	}		
	return 0;			
}*/

	public int create(Lm lm) throws SQLException {
		
		String sql = "INSERT INTO LITTLEMEETING (littlemeeting_no, littlemeeting_name, title, contents, max_num, createtime, writer_id) "
					+ "VALUES (littlemeeting_seq.nextval, ?, ?, ?, ?, SYSDATE, ?)";
		
		/*
		String sql = "INSERT INTO LITTLEMEETING VALUES (littlemeeting_seq.nextval, ?, ?, ?, SYSDATE, 0, ?, 0) ";		
		*/
		Object[] param = new Object[] {lm.getLittlemeeting_name(), lm.getTitle(), lm.getContents(), lm.getMax_num(), lm.getWriter_id()};
								
		jdbcUtil.setSqlAndParameters(sql, param);
		// JDBCUtil 에 insert문과 매개 변수 설정
						
		String key[] = {"littlemeeting_no"};
		try {
			int result = jdbcUtil.executeUpdate(key);
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}
	
	//신청
		public int apply(LmManage lman)throws SQLException{
			
			String sql = "UPDATE LITTLEMEETING "
					+ "SET count = count + 1 "
					+ "WHERE littlemeeting_no=?";
		
			Object[] param = new Object[] {lman.getLittlemeeting_no()};
			
			jdbcUtil.setSqlAndParameters(sql, param);
		
			try {
				int result = jdbcUtil.executeUpdate();
				return result;
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {		
				jdbcUtil.commit();
				jdbcUtil.close();	// resource 반환
			}		
			
			return 0;	
			
		}

		//취소
		public int cancel(int littlemeeting_no)throws SQLException{
			
			String sql = "UPDATE LITTLEMEETING "
					+ "SET count = count - 1 "
					+ "WHERE littlemeeting_no=?";
		
			Object[] param = new Object[] {littlemeeting_no};
			
			jdbcUtil.setSqlAndParameters(sql, param);
		
			try {
				int result = jdbcUtil.executeUpdate();
				return result;
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {		
				jdbcUtil.commit();
				jdbcUtil.close();	// resource 반환
			}		
			
			return 0;	
			
		}

	//글 작성자만 delete권한을 갖고 있다. 
	public int delete(int littlemeeting_no) throws SQLException {
		String sql = "DELETE FROM LITTLEMEETING WHERE littlemeeting_no=? ";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {littlemeeting_no});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	
	
	//전체 littemeeting정보를 검색하여 List에 저장 및 반환
	public List<Lm> findUserList() throws SQLException {
        String sql = "SELECT littlemeeting_no, littlemeeting_name, createtime, count, max_num " 
        		   + "FROM LITTLEMEETING "
        		   + "ORDER BY littlemeeting_no ";
	
	
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Lm> lmList = new ArrayList<Lm>();	// lm들의 리스트 생성
			while (rs.next()) {
				Lm lm = new Lm(	
					rs.getInt("littlemeeting_no"),
					rs.getString("littlemeeting_name"),
					rs.getDate("createtime"),
					rs.getInt("count"),
					rs.getInt("max_num"));
				lmList.add(lm);				// List에 lm 객체 저장
			}		
			return lmList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}	
		
	
	//주어진 littlemeeting_no에 해당하는 정보를 DB에서 찾아 Littlemeeting 도메인 클래스에 저장하여 반환
	public Lm ShowLMDetail(int littlemeeting_no) throws SQLException {
        String sql = "SELECT littlemeeting_name, title, contents, createtime, count, max_num, writer_id "
        			+ "FROM LITTLEMEETING "
        			+ "WHERE littlemeeting_no=?";  
        
		jdbcUtil.setSqlAndParameters(sql, new Object[] {littlemeeting_no});	// JDBCUtil에 query문과 매개 변수 설정
		Lm lm = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				lm = new Lm(
					littlemeeting_no,
					rs.getString("littlemeeting_name"),
					rs.getString("title"),
					rs.getString("contents"),
					rs.getDate("createtime"),
					rs.getInt("count"),					
					rs.getInt("max_num"),
					rs.getString("writer_id"));
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return lm;
	}


	public Lm findLm(int littlemeeting_no) {
		// TODO Auto-generated method stub
		String sql = "SELECT littlemeeting_name, title, contents, createtime, count, max_num "
    			+ "FROM LITTLEMEETING "
    			+ "WHERE littlemeeting_no=? ";              
	jdbcUtil.setSqlAndParameters(sql, new Object[] {littlemeeting_no});	// JDBCUtil에 query문과 매개 변수 설정

	try {
		ResultSet rs = jdbcUtil.executeQuery();		// query 실행
		if (rs.next()) {						// 학생 정보 발견
			Lm lm = new Lm(		
				littlemeeting_no,
				rs.getString("littlemeeting_name"),
				rs.getString("title"),
				rs.getString("contents"),
				rs.getDate("createtime"),
				rs.getInt("count"),
				rs.getInt("max_num"));
			return lm;
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	} finally {
		jdbcUtil.close();		// resource 반환
	}
	return null;
	}


	public int update(Lm lm) throws SQLException {
		String sql = "UPDATE LITTLEMEETING "
					+ "SET littlemeeting_name=?, title=?, contents=?, max_num=? "
					+ "WHERE littlemeeting_no=?";
		
		int littlemeeting_no = lm.getLittlemeeting_no();
		
		
		Object[] param = new Object[] {lm.getLittlemeeting_name(), lm.getTitle(), lm.getContents(), lm.getMax_num(), littlemeeting_no};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	//LM Manage 테이블 생성
		public int createLmMan(LmManage lman) {
			// TODO Auto-generated method stub

			String sql = "INSERT INTO LITTLEMEETING_MANAGE(littlemeeting_no, join_check, apply_id ) "
					+ "VALUES (?, ?, ?) ";
			
			Object[] param = new Object[] { lman.getLittlemeeting_no(), lman.getJoin_check(), lman.getApply_id() };
							
			jdbcUtil.setSqlAndParameters(sql, param);
		// JDBCUtil 에 insert문과 매개 변수 설정
						
			
			try {
				int result = jdbcUtil.executeUpdate();
				return result;
			} catch (Exception ex) {
				jdbcUtil.rollback();
			ex.printStackTrace();
			} finally {		
				jdbcUtil.commit();
				jdbcUtil.close();	// resource 반환
			}		
			return 0;			
		}
		
		//LM Manage 테이블 삭제
		public int deleteLmMan(LmManage lman) {
			String sql = "DELETE FROM LITTLEMEETING_MANAGE WHERE littlemeeting_no = ? AND apply_id = ?";		
			jdbcUtil.setSqlAndParameters(sql, new Object[] {lman.getLittlemeeting_no(), lman.getApply_id()});	// JDBCUtil에 delete문과 매개 변수 설정

			String key[] = {"littlemeeting_no"};
			try {
				int result = jdbcUtil.executeUpdate(key);
				return result;
			} catch (Exception ex) {
				jdbcUtil.rollback();
			ex.printStackTrace();
			} finally {		
				jdbcUtil.commit();
				jdbcUtil.close();	// resource 반환
			}		
			return 0;	
		}
}
