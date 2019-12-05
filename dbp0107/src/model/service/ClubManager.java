package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Club;
import model.dao.ClubDAO;

public class ClubManager {
	private static ClubManager clubMan = new ClubManager();
	private ClubDAO clubDAO;

	private ClubManager() {
		try {
			clubDAO = new ClubDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static ClubManager getInstance() {
		return clubMan;
	}
	
	public int create(Club club) throws SQLException, ExistingClubException {
		if (clubDAO.existingClub(club.getClub_no()) == true) {
			throw new ExistingClubException("이미 존재하는 동아리입니다.");
		}
		return clubDAO.create(club);
	}

	public int update(Club club) throws SQLException {
		return clubDAO.update(club);
	}	

	public int remove(int club_no) throws SQLException {
		return clubDAO.remove(club_no);
	}
	
	/* find 부분 추후 수정 */

	public Club findClub(int club_no)
		throws SQLException, ClubNotFoundException {
		Club club = clubDAO.findClub(club_no);
		
		if (club == null) {
			throw new ClubNotFoundException("존재하지 않는 동아리입니다.");
		}		
		return club;
	}

	public List<Club> findClubList() throws SQLException {
			return clubDAO.clubList();
	}
	
	public List<Club> findClubList(int currentPage, int countPerPage)
		throws SQLException {
		return clubDAO.findClubList(currentPage, countPerPage);
	}
	
	public ClubDAO getClubDAO() {
		return this.clubDAO;
	}

	public List<Club> showRecommend(String customerId) throws SQLException{
		return clubDAO.showRecommend(customerId);
	}
	

	public Club showDetail(int club_no) {
		Club club = clubDAO.showDetail(club_no); 
		return club;
	}
	public List<Club> showClubList() throws SQLException {
		return clubDAO.clubList();
	}


	
}