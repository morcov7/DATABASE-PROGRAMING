package model.service;


import java.util.List;
import java.sql.SQLException;
import model.MessengerBoard;
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
   
   public List<MessengerBoard> boardList(int department_no) throws SQLException {
      return boardDAO.boardList(department_no);
   }
   
   public MessengerBoard showDetail(int department_no, int messenger_connect_board_no) throws SQLException {
	   MessengerBoard board = boardDAO.showDetail(department_no, messenger_connect_board_no);
	   
      return board;
   }
   
   public MessengerBoard connectURL(int department_no, int messenger_connect_board_no, String customerId) throws SQLException {
	   MessengerBoard board = boardDAO.connectURL(department_no, messenger_connect_board_no, customerId);
      return board;
   }
   
   public MessengerBoardDAO getBoardDAO() {
      return this.boardDAO;
   }

}
