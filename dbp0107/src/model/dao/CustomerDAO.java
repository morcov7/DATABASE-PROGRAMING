package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class CustomerDAO {
	private JDBCUtil jdbcUtil = null;
	
	public CustomerDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	public int create(Customer customer) throws SQLException {
		String sql = "INSERT INTO CUSTOMER (customer_no, customerId, password, name, email, phone, department_no) "
				+ "VALUES (customer_seq.nextval, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {customer.getCustomerId(), customer.getPassword(), 
				customer.getName(), customer.getEmail(), customer.getPhone(),
				(customer.getDepartment_no()!=0) ? customer.getDepartment_no() : null};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 d설정
						
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
	
	/*

	public int create(Customer customer) throws SQLException {
		String sql = "INSERT INTO CUSTOMER (customer_no, customerId, password, name, email, phone) "
					+ "VALUES (1, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {customer.getCustomerId(), customer.getPassword(), 
				customer.getName(), customer.getEmail(), customer.getPhone()};				
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
	/**
	 * 기존의 사용자 정보를 수정.
	 */
	public int update(Customer customer) throws SQLException {
		String sql = "UPDATE CUSTOMER "
					+ "SET password=?, name=?, email=?, phone=? "
					+ "WHERE customerid=?";
		Object[] param = new Object[] {customer.getPassword(), customer.getName(), 
					customer.getEmail(), customer.getPhone(), customer.getCustomerId()};				
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

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int remove(String customerId) throws SQLException {
		String sql = "DELETE FROM CUSTOMER WHERE customerid=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});	// JDBCUtil에 delete문과 매개 변수 설정

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

	/**
	 * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 Customer 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public Customer findCustomer(String customerId) throws SQLException {
        String sql = "SELECT password, name, email, phone "
        			+ "FROM CUSTOMER "
        			+ "WHERE customerid=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				Customer customer = new Customer(		// Customer 객체를 생성하여 학생 정보를 저장
					customerId,
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("phone"));
				return customer;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	public Customer viewCustomer(String customerId) throws SQLException {
        String sql = "SELECT password, name, email, phone, d.dept_name AS dept_name "
        			+ "FROM CUSTOMER c LEFT OUTER JOIN DEPARTMENT d ON c.department_no = d.department_no "
        			+ "WHERE customerid=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				Customer customer = new Customer(		// Customer 객체를 생성하여 학생 정보를 저장
					customerId,
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("dept_name"));
				return customer;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Customer> findCustomerList() throws SQLException {
        String sql = "SELECT customerId, password, name, email, phone " 
        		   + "FROM CUSTOMER "
        		   + "ORDER BY customerId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Customer> customerList = new ArrayList<Customer>();	// Customer들의 리스트 생성
			while (rs.next()) {
				Customer customer = new Customer(			// Customer 객체를 생성하여 현재 행의 정보를 저장
					rs.getString("customerId"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("phone"));	
				customerList.add(customer);				// List에 Customer 객체 저장
			}		
			return customerList;					
			
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
	public List<Customer> findCustomerList(int currentPage, int countPerPage) throws SQLException {
        String sql = "SELECT customerId, password, name, email, phone " 
        		   + "FROM CUSTOMER "
        		   + "ORDER BY customerId";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<Customer> customerList = new ArrayList<Customer>();	// Customer들의 리스트 생성
				do {
					Customer customer = new Customer(		// Customer 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("customerId"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("phone"));	
					customerList.add(customer);							// 리스트에 Customer 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return customerList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingCustomer(String customerId) throws SQLException {
		String sql = "SELECT count(*) FROM CUSTOMER WHERE customerid=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});	// JDBCUtil에 query문과 매개 변수 설정

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
	
}
