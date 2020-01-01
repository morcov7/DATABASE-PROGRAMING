package model;

public class LmManage {
	private int littlemeeting_no;
	//private int customer_no;
	private int join_check;
	private String apply_id;
	private String customerId;
	
	/*public LmManage(int littlemeeting_no, int customer_no, int join_check, String apply_id, String customerId) {
		this.littlemeeting_no = littlemeeting_no;
		this.customer_no = customer_no;
		this.join_check = join_check;
		this.apply_id = apply_id;
		this.customerId = customerId;
		
	}*/
	
	

	public int getLittlemeeting_no() {
		return littlemeeting_no;
	}
	public void setLittlemeeting_no(int littlemeeting_no) {
		this.littlemeeting_no = littlemeeting_no;
	}
	/*public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}*/
	
	public LmManage(int littlemeeting_no, int join_check, String apply_id, String customerId) {
		this.littlemeeting_no = littlemeeting_no;
		this.join_check = join_check;
		this.apply_id = apply_id;
		this.customerId = customerId;
	}

	//¼öÁ¤
	/*public LmManage(int littlemeeting_no, int customer_no, int join_check, String customerId) {
		this.littlemeeting_no = littlemeeting_no;
		this.customer_no = customer_no;
		this.join_check = join_check;
		this.apply_id = customerId;
	}*/
	
	public LmManage(int littlemeeting_no, int join_check, String customerId) {
		this.littlemeeting_no = littlemeeting_no;
		this.join_check = join_check;
		this.apply_id = customerId;
	}



	public int getJoin_check() {
		return join_check;
	}
	public void setJoin_check(int join_check) {
		this.join_check = join_check;
	}
	public String getApply_id() {
		return apply_id;
	}
	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}
