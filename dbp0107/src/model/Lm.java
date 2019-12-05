package model;

import java.util.Date;

public class Lm {

    private int littlemeeting_no;
    private String littlemeeting_name;
    private String title;
    private String contents;
    private Date createtime;
    private int count;
    private int max_num;
    private int writer_check;
    private String customerId;
    private String writer_id;
    
    public Lm(int littlemeeting_no, String littlemeeting_name , String title, String contents, Date createtime, int count, int max_num, int writer_check) {
        this.littlemeeting_no = littlemeeting_no;
        this.littlemeeting_name = littlemeeting_name;
        this.title = title;
        this.contents = contents;
        this.createtime = createtime;
        this.count = count;
        this.max_num = max_num;
        this.writer_check = writer_check;
        
    }

	public Lm(int littlemeeting_no, String littlemeeting_name , int count, int max_num) {
		this.littlemeeting_no = littlemeeting_no;
		this.littlemeeting_name = littlemeeting_name;
		this.count = count;
		this.max_num = max_num;
		// TODO Auto-generated constructor stub
	}

	public Lm(int littlemeeting_no, String littlemeeting_name , String title, String contents, Date createtime, int count, int max_num) {
		this.littlemeeting_no = littlemeeting_no;
		this.littlemeeting_name = littlemeeting_name;
		this.title = title;
		this.contents = contents;
		this.createtime = createtime;
		this.count = count;
		this.max_num = max_num;
		
		// TODO Auto-generated constructor stub
	}

	public Lm(int littlemeeting_no, String littlemeeting_name, Date createtime, int count, int max_num) {
		this.littlemeeting_no = littlemeeting_no;
		this.littlemeeting_name = littlemeeting_name;
		this.createtime = createtime;
		this.count = count;
		this.max_num = max_num;
	}


	public Lm(String littlemeeting_name, String title, String contents, Date createtime, int count, int max_num) {
		this.littlemeeting_name = littlemeeting_name;
		this.title = title;
		this.contents = contents;
		this.createtime = createtime;
		this.count = count;
		this.max_num = max_num;
	}


	
	public Lm(String littlemeeting_name, String title, String contents, int max_num) {
		this.littlemeeting_name = littlemeeting_name;
		this.title = title;
		this.contents = contents;
		this.max_num = max_num;
	}

	
	public Lm(String customerId, String littlemeeting_name, String title, String contents, Date createtime, int count, int max_num) {
		this.customerId  = customerId;
		this.littlemeeting_name = littlemeeting_name;
		this.title = title;
		this.contents = contents;
		this.createtime = createtime;
		this.count = count;
		this.max_num = max_num;
	}

	
	
 // dtail獣 持失切
	public Lm(String littlemeeting_name, String title, String contents, Date createtime, int count, int max_num,
			String writer_id) {
		this.littlemeeting_name = littlemeeting_name;
		this.title = title;
		this.contents = contents;
		this.createtime = createtime;
		this.count = count;
		this.max_num = max_num;
		this.writer_id = writer_id;
	}

	//create獣 持失切
	public Lm(String customerId, String littlemeeting_name, String title, String contents, int max_num) {
		
		this.littlemeeting_name = littlemeeting_name;
		this.title = title;
		this.contents = contents;
		this.max_num = max_num;
		this.writer_id = customerId;
	}
	
	

	public Lm(int littlemeeting_no, String littlemeeting_name, String title, String contents, Date createtime,
			int count, int max_num, String writer_id) {
		super();
		this.littlemeeting_no = littlemeeting_no;
		this.littlemeeting_name = littlemeeting_name;
		this.title = title;
		this.contents = contents;
		this.createtime = createtime;
		this.count = count;
		this.max_num = max_num;
		this.writer_id = writer_id;
	}

	public Lm(int littlemeeting_no, String littlemeeting_name, String title, String contents, int max_num) {
		this.littlemeeting_no = littlemeeting_no;
		this.littlemeeting_name = littlemeeting_name;
		this.title = title;
		this.contents = contents;
		this.max_num = max_num;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	
	
	public int getLittlemeeting_no() {
		return littlemeeting_no;
	}

	public void setLittlemeeting_no(int littlemeeting_no) {
		this.littlemeeting_no = littlemeeting_no;
	}

	public String getLittlemeeting_name() {
		return littlemeeting_name;
	}

	public void setLittlemeeting_name(String littlemeeting_name) {
		this.littlemeeting_name = littlemeeting_name;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMax_num() {
		return max_num;
	}

	public void setMax_num(int max_num) {
		this.max_num = max_num;
	}

	public int getWriter_check() {
		return writer_check;
	}

	public void setWriter_check(int writer_check) {
		this.writer_check = writer_check;
	}

	
        
}
