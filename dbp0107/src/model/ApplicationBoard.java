package model;

import java.util.Date;

public class ApplicationBoard {
	private int board_no;
	private String title;
	private String contents;
	private Date createtime;
	private int application_check;  //**
	private int department_no;
	private String customer_name;
	
	public ApplicationBoard() { }
	
	
	
	public ApplicationBoard(int department_no) {
		super();
		this.department_no = department_no;
	}

	

	public ApplicationBoard(int department_no, int board_no) {
		super();
		this.department_no = department_no;
		this.board_no = board_no;
	}



	public ApplicationBoard(int board_no, String title, Date createtime, int department_no, String customer_name) {
		super();
		this.board_no = board_no;
		this.title = title;
		this.createtime = createtime;
		this.department_no = department_no;
		this.customer_name = customer_name;
	}



	public ApplicationBoard(int board_no, String title, String contents, Date createtime, int application_check,
			int department_no, String customer_name) {
		super();
		this.board_no = board_no;
		this.title = title;
		this.contents = contents;
		this.createtime = createtime;
		this.application_check = application_check;
		this.department_no = department_no;
		this.customer_name = customer_name;
	}
	
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getApplication_check() {
		return application_check;
	}
	public void setApplication_check(int application_check) {
		this.application_check = application_check;
	}
	public int getDepart_no() {
		return department_no;
	}
	public void setDepart_no(int department_no) {
		this.department_no = department_no;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}


	
	
	
}
