package model;

import java.util.Date;

// board/notice/{departement_no}/{notice_board_no}
public class NoticeBoard {
	private int notice_board_no;
	private String title;
	private String contents;
	private Date createtime;
	private int department_no; // 학과별 게시판이기 때문에 check하는 용도
	private String customer_name; // 게시글 글쓴이

	public NoticeBoard() {	}
	

	public NoticeBoard(int department_no) {
		super();
		this.department_no = department_no;
	}

	public NoticeBoard(int department_no, int notice_board_no) {
		super();
		this.department_no = department_no;
		this.notice_board_no = notice_board_no;
	}

	public NoticeBoard(int notice_board_no, String title, Date createtime, int department_no, String customer_name) {
		super();
		this.notice_board_no = notice_board_no;
		this.title = title;
		this.createtime = createtime;
		this.department_no = department_no;
		this.customer_name = customer_name;
	}

	public NoticeBoard(int notice_board_no, String title, String contents, Date createtime, int department_no,
			String customer_name) {
		super();
		this.notice_board_no = notice_board_no;
		this.title = title;
		this.contents = contents;
		this.createtime = createtime;
		this.department_no = department_no;
		this.customer_name = customer_name;
	}

	public int getnotice_board_no() {
		return notice_board_no;
	}


	public void setnotice_board_no(int notice_board_no) {
		this.notice_board_no = notice_board_no;
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

	

	
}
