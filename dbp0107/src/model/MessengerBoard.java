package model;

import java.util.Date;

public class MessengerBoard {
	private int messenger_connect_board_no;
	private String title;
	private String contents;
	private Date createtime;
	private int application_check;  //**
	private int department_no;
	private String customer_name;
	private String customerId; 
	private String url;
	
	public MessengerBoard() {}

	public MessengerBoard(int department_no) {
		super();
		this.department_no = department_no;
	}

	public MessengerBoard(int department_no, int messenger_connect_board_no) {
		super();
		this.department_no = department_no;
		this.messenger_connect_board_no = messenger_connect_board_no;
	}
	
	public MessengerBoard(int messenger_connect_board_no, String title, Date createtime, int department_no, String customer_name) {
		super();
		this.messenger_connect_board_no = messenger_connect_board_no;
		this.title = title;
		this.createtime = createtime;
		this.department_no = department_no;
		this.customer_name = customer_name;
	}


	public MessengerBoard(int messenger_connect_board_no, String title, String contents, Date createtime, int application_check,
			int department_no, String customer_name) {
		super();
		this.messenger_connect_board_no = messenger_connect_board_no;
		this.title = title;
		this.contents = contents;
		this.createtime = createtime;
		this.application_check = application_check;
		this.department_no = department_no;
		this.customer_name = customer_name;
	}
	
	//Ω≈√ª
	public MessengerBoard(String title, String url, String customer_name, String customerId) {
		//super();
		this.title = title;
		this.url = url;
		this.customer_name = customer_name;
		this.setCustomerId(customerId);
	}
	
	
	public int getMessenger_connect_board_no() {
		return messenger_connect_board_no;
	}

	public void setMessenger_connect_board_no(int messenger_connect_board_no) {
		this.messenger_connect_board_no = messenger_connect_board_no;
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

	public int getDepartment_no() {
		return department_no;
	}

	public void setDepartment_no(int department_no) {
		this.department_no = department_no;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
