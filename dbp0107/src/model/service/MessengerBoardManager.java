package model.service;


import java.util.List;
import java.sql.SQLException;
import model.ApplicationBoard;
import model.dao.MessengerBoardDAO;

public class MessengerBoardManager {
   private static MessengerBoardManager boardMan = new MessengerBoardManager();
   private MessengerBoardDAO boardDAO;
   
   private MessengerBoardManager() {
      try {
         boardDAO = new MessengerBoardDAO();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   public static MessengerBoardManager getInstance() {
      return boardMan;
   }
   
   public List<ApplicationBoard> boardList(int department_no) throws SQLException {
      return boardDAO.boardList(department_no);
   }
   
   public ApplicationBoard showDetail(int department_no, int board_no) throws SQLException {
	   ApplicationBoard board = boardDAO.showDetail(department_no, board_no);
	   
      return board;
   }
   
   public MessengerBoardDAO getBoardDAO() {
      return this.boardDAO;
   }

}
