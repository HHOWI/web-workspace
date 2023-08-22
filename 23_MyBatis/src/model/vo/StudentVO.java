package model.vo;

import java.sql.Date;

public class StudentVO {
	private String studentNO;
	private String studentName;
	private String studentAddr;
	private DepartmentVO department;

	public StudentVO() {}

	public StudentVO(String studentNO, String studentName, String studentAddr, DepartmentVO department) {
		this.studentNO = studentNO;
		this.studentName = studentName;
		this.studentAddr = studentAddr;
		this.department = department;
	}

	public String getStudentNO() {
		return studentNO;
	}

	public void setStudentNO(String studentNO) {
		this.studentNO = studentNO;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddr() {
		return studentAddr;
	}

	public void setStudentAddr(String studentAddr) {
		this.studentAddr = studentAddr;
	}

	public DepartmentVO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "StudentVO [studentNO=" + studentNO + ", studentName=" + studentName + ", studentAddr=" + studentAddr
				+ ", department=" + department + "]";
	}

}
