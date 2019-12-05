package model.dao;

import java.sql.*;
import java.util.*;

import model.Club;

public class ClubDAO {
	private JDBCUtil jdbcUtil = null;
	
	public ClubDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	/* 새로운 Club 생성 */
	public int create(Club club) throws SQLException {
		String sql = "INSERT INTO CLUB (club_no, club_name, title, contents, createtime, department_no) "
				+ "VALUES (club_seq.nextval, ?, ?, ?, SYSDATE, ?)";	
		Object[] param = new Object[] {club.getClub_name(), club.getTitle(), club.getContents(), 
				(club.getDepartment_no()!=0) ? club.getDepartment_no() : null };
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
	
	/* 이건 generate key 안하는 create
	 public int create(Club club) throws SQLException {
		String sql = "INSERT INTO Club VALUES (?, ?, ?, ?, SYSDATE)";		
		Object[] param = new Object[] {club.getClub_no(), club.getClub_name(), 
					club.getTitle(), club.getContents(),
						(club.getClub_no()!=0) ? club.getClub_no() : null };				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
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
	 */
	
	
	/* 기존 Club 수정 */
	public int update(Club club) throws SQLException {
		String sql = "UPDATE CLUB "
					+ "SET deptartment_no=?, club_name=?, title=?, contents=?"
					+ "WHERE club_no=?";
		Object[] param = new Object[] {club.getDepartment_no(), club.getClub_name(), club.getTitle(), 
						club.getContents(), club.getClub_no()};
		
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
	
	/* 기존 Club 삭제 */
	public int remove(int club_no) throws SQLException {
		String sql = "DELETE FROM CLUB WHERE club_no=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {club_no});	// JDBCUtil에 delete문과 매개 변수 설정

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
	
	/* DB에 저장된 club 목록들을 불러옴  */
	public List<Club> clubList() throws SQLException {
					// 동아리가 학과에 소속되어있지 않으면 (dept_no == NULL이면 중앙동아리로 출력)
        String sql = "SELECT club_no, club_name, NVL2(dept_name, dept_name, '중앙동아리') AS dept_name "
        		   + "FROM CLUB c LEFT OUTER JOIN DEPARTMENT d ON c.department_no = d.department_no "
        		   + "ORDER BY club_no";        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Club> clubList = new ArrayList<Club>();	// Community들의 리스트 생성
			while (rs.next()) {
				Club club = new Club(			// Community 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("club_no"),
						rs.getString("club_name"),
						rs.getString("dept_name"));
				clubList.add(club);				// List에 Community 객체 저장
			}		
			return clubList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/* clubNo로 해당 게시글의 상세 내용을 불러옴   Club 도메인 클래스에 저장해서 반환 */
	public Club showDetail(int club_no) {
		String sql = "SELECT club_name, NVL2(dept_name, dept_name, '중앙동아리') AS dept_name, title, contents, createtime "
					+ "FROM CLUB c LEFT OUTER JOIN DEPARTMENT d ON c.department_no = d.department_no "
     				+ "WHERE club_no = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {club_no});	// JDBCUtil에 query문과 매개 변수 설정
		Club club = null;
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if(rs.next()) {
				club = new Club(
						club_no, 
						rs.getString("club_name"),
						rs.getString("dept_name"),
						rs.getString("title"),
						rs.getString("contents"),
						rs.getDate("createtime"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return club;
	}
	
	/* customerId를 기반으로  학과 관련 추천 동아리를 불러옴    Club 리스트에 저장해서 반환 */
	public List<Club> showRecommend(String customerId) throws SQLException {
		// dept_no 기반 학과 관련 추천 동아리 불러오는 sql
		String sql = "SELECT club_name, title, club_no "
        			+ "FROM CLUB c LEFT OUTER JOIN CUSTOMER c1 ON c.department_no = c1.department_no "
        			+ "WHERE customerId = ?"; 
		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});	// JDBCUtil에 query문과 매개 변수 설정
		
		// dept_no is null이면 random으로 3개 추천 동아리 불러오는 sql
		String sql2 = "select club_name, title, club_no from(select club_name, title, club_no from club where department_no is null order by DBMS_RANDOM.value) where rownum < 4";        
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			
			// if dept_no 기반 학과 관련 추천 동아리  존재 O --> using isBeforeFirst()
			// isBeforeFirst() : 첫 row 바로 앞 O --> TRUE / 첫 row 앞 X or 결과 row가 X --> FALSE
			if(rs.isBeforeFirst()) {
				List<Club> clubList = new ArrayList<Club>();	
				while (rs.next()) {
					Club club = new Club(			
						customerId, 
						rs.getString("club_name"),
						rs.getString("title"),
						rs.getInt("club_no"));
					clubList.add(club);			
				}		
				return clubList;					
			}
			// if dept_no 기반 학과 관련 추천 동아리  존재 X
			else {
				jdbcUtil.setSqlAndParameters(sql2, null);
				ResultSet rs2 = jdbcUtil.executeQuery();
				
				List<Club> clubList = new ArrayList<Club>();	
				while (rs2.next()) {
					Club club = new Club(	
						customerId, 
						rs2.getString("club_name"),
						rs2.getString("title"), 
						rs2.getInt("club_no"));
					clubList.add(club);			
				}		
				return clubList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	public boolean existingClub(int club_no) throws SQLException {
		String sql = "SELECT count(*) FROM CLUB WHERE club_no=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {club_no});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
	
	/* findClub & findClubList 부분은 수정이 필요!!!!! 잊지말자 */
	public Club findClub(int club_no) throws SQLException {
        String sql = "SELECT deptartment_no, club_name "
        			+ "FROM CLUB "
        			+ "WHERE club_no=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {club_no});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						
				Club club = new Club(		
					club_no,
					rs.getInt("deptartment_no"),
					rs.getString("club_name"),
					null,
					null,
					null);
				return club;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	public List<Club> findClubList() throws SQLException {
		String sql = "SELECT club_no, deptartment_no, club_name"
     		   + "FROM CLUB "
     		   + "ORDER BY club_no";        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Club> clubList = new ArrayList<Club>();	// Community들의 리스트 생성
			while (rs.next()) {
				Club club = new Club(			// Community 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("club_no"),
						rs.getInt("deptartment_no"),
						rs.getString("club_name"),
						null,
						null,
						null);
				clubList.add(club);				// List에 Community 객체 저장
			}		
			return clubList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
	 * 해당하는 사용자 정보만을 List에 저장하여 반환.
	 */
	public List<Club> findClubList(int currentPage, int countPerPage) throws SQLException {
        String sql = "SELECT club_no, deptartment_no, club_name " 
        		   + "FROM CLUB "
        		   + "ORDER BY club_no";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<Club> clubList = new ArrayList<Club>();
				do {
					Club club = new Club(			// Community 객체를 생성하여 현재 행의 정보를 저장
							rs.getInt("club_no"),
							rs.getInt("deptartment_no"),
							rs.getString("club_name"),
							null,
							null,
							null);
					clubList.add(club);								// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return clubList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	
	
	
}