package model.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Lm;

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
		
		String sql = "INSERT INTO LITTLEMEETING (littlemeeting_no, littlemeeting_name, title, contents, max_num, createtime) "
					+ "VALUES (littlemeeting_seq.nextval, ?, ?, ?, ?, SYSDATE)";
		
		/*
		String sql = "INSERT INTO LITTLEMEETING VALUES (littlemeeting_seq.nextval, ?, ?, ?, SYSDATE, 0, ?, 0) ";		
		*/
		Object[] param = new Object[] {lm.getLittlemeeting_name(), lm.getTitle(), lm.getContents(), lm.getMax_num()};
								
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
        String sql = "SELECT littlemeeting_name, title, contents, createtime, count, max_num "
        			+ "FROM LITTLEMEETING "
        			+ "WHERE littlemeeting_no=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {littlemeeting_no});	// JDBCUtil에 query문과 매개 변수 설정
		Lm lm = null;
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				lm = new Lm(	
					rs.getString("littlemeeting_name"),
					rs.getString("title"),
					rs.getString("contents"),
					rs.getDate("createtime"),
					rs.getInt("count"),					
					rs.getInt("max_num"));
				
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
}
