package model.dao;

import java.sql.*;

import model.Certification;

public class CertificationDAO {
	private JDBCUtil jdbcUtil = null;

	public CertificationDAO() {
		jdbcUtil = new JDBCUtil();
	}

	public int upload(Certification certification) throws SQLException {
		String sql = "INSERT INTO CERTIFICATION "
				+ "(certification_no, acceptance_letter_certify, tuition_payment_certify) "
				+ "VALUES (certification_no_seq.NEXTVAL, ?, ?)";
		Object[] param = new Object[] { certification.getCertification_no(),
				certification.getAcceptance_letter_certify(), certification.getTuition_payment_certify() };

		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

}