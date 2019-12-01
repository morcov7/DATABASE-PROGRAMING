package model;

public class Department {
	private int department_no;
	private String dept_name;
	private String dept_url;

	public Department() {
	} // 기본 생성자

	
	public Department(int department_no, String dept_name) {
		super();
		this.department_no = department_no;
		this.dept_name = dept_name;
	}


	public Department(String dept_name, String dept_url) {
		this.dept_name = dept_name;
		this.dept_url = dept_url;
	}

	public Department(String dept_url) {
		super();
		this.dept_url = dept_url;
	}

	public Department(int department_no) {
		super();
		this.department_no = department_no;
	}

	public int getDepartment_no() {
		return department_no;
	}

	public void setDepartment_no(int department_no) {
		this.department_no = department_no;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_url() {
		return dept_url;
	}

	public void setDept_url(String dept_url) {
		this.dept_url = dept_url;
	}

	

}
