package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Department;
import model.dao.DepartmentDAO;

public class MainManager {
	
	private static MainManager mainMan = new MainManager();
	private DepartmentDAO departmentDAO;

	private MainManager() {
	      try {
	    	  departmentDAO = new DepartmentDAO();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	public static MainManager getInstance() {
		return mainMan;
	}

	  public List<Department> departList() throws SQLException {
	  return departmentDAO.departList(); }
	 

	public DepartmentDAO getDepartmentDAO() {
		return this.departmentDAO;
	}

}
