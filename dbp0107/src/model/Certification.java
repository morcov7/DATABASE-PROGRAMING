package model;

public class Certification {
	int certification_no;
	String acceptance_letter_certify;
	String tuition_payment_certify;
	String certification_check;
	
	public Certification(int certification_no, String acceptance_letter_certify, String tuition_payment_certify,
			String certification_check) {
		super();
		this.certification_no = certification_no;
		this.acceptance_letter_certify = acceptance_letter_certify;
		this.tuition_payment_certify = tuition_payment_certify;
		this.certification_check = certification_check;
	}

	
	
	public Certification(int certification_no, String acceptance_letter_certify, String tuition_payment_certify) {
		super();
		this.certification_no = certification_no;
		this.acceptance_letter_certify = acceptance_letter_certify;
		this.tuition_payment_certify = tuition_payment_certify;
	}



	public Certification(String acceptance_letter_certify, String tuition_payment_certify) {
		super();
		this.acceptance_letter_certify = acceptance_letter_certify;
		this.tuition_payment_certify = tuition_payment_certify;
	}


	public Certification(String certification_check) {
		super();
		this.certification_check = certification_check;
	}



	public int getCertification_no() {
		return certification_no;
	}

	public void setCertification_no(int certification_no) {
		this.certification_no = certification_no;
	}

	public String getAcceptance_letter_certify() {
		return acceptance_letter_certify;
	}

	public void setAcceptance_letter_certify(String acceptance_letter_certify) {
		this.acceptance_letter_certify = acceptance_letter_certify;
	}

	public String getTuition_payment_certify() {
		return tuition_payment_certify;
	}

	public void setTuition_payment_certify(String tuition_payment_certify) {
		this.tuition_payment_certify = tuition_payment_certify;
	}

	public String getCertification_check() {
		return certification_check;
	}

	public void setCertification_check(String certification_check) {
		this.certification_check = certification_check;
	}
	
}
