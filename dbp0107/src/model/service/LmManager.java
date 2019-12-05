package model.service;

import java.sql.SQLException;

import java.util.List;

import model.Lm;
import model.LmManage;
import model.dao.LmDAO;

public class LmManager {
	
	
	private static LmManager lmMan = new LmManager();
	private LmDAO lmDAO;
	
	private LmManager() {
		try {
			lmDAO = new LmDAO();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static LmManager getInstance() {
		return lmMan;
	}

	// 소모임 글 등록
	public int createLM(Lm lm) throws SQLException {
		// TODO Auto-generated method stub
		return lmDAO.create(lm);
	}

	
	public Lm findLm(int littlemeeting_no) {
		Lm lm = lmDAO.findLm(littlemeeting_no);
		
		return lm;
	}
	
	
	
	//소모임 전체 글 목록을 보여준다. 
	public List<Lm> findLMList() throws SQLException {
		// TODO Auto-generated method stub
		return lmDAO.findUserList();
	}

	
	//3가지의 경우의 수로 customer의 보는 화면이 달라진다.
	//소모임 상세 글을 보여준다.  
	public Lm ShowLMDetail(int littlemeeting_no) throws SQLException{
		// TODO Auto-generated method stub
		return lmDAO.ShowLMDetail(littlemeeting_no);
		
	}
	
	
	//소모임의 글을 삭제 한다.(글 작성자 한정)
	public int delete(int littlemeeting_no)throws SQLException{
		
		return lmDAO.delete(littlemeeting_no);
	}

	
	public int updateLm(Lm lm) throws SQLException {
		// TODO Auto-generated method stub
		return lmDAO.update(lm);
	}
	
	//추가한 부분
	//LmMan 생성
	public int createLmMan(LmManage lman) throws SQLException {
		// TODO Auto-generated method stub
		return lmDAO.createLmMan(lman);
	}

	//LmMan 삭제
	public int deleteLmMan(LmManage lman) throws SQLException {
		// TODO Auto-generated method stub
		return lmDAO.deleteLmMan(lman);
	}

	public int apply(LmManage lman)throws SQLException{
		return lmDAO.apply(lman);
	}
	
	public int cancel(int littlemeeting_no)throws SQLException{
		return lmDAO.cancel(littlemeeting_no);
	}
	
}