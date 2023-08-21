package model.vo;

import java.sql.Date;

public class StudentVO {
	private String studentNO;
	private String studentName;
	private String studentAddr;
	private String departmentNO;
	private String departmentName;
	public StudentVO() {
		// TODO Auto-generated constructor stub
	}
	public StudentVO(String studentNO, String studentName, String studentAddr, String departmentNO,
			String departmentName) {
		this.studentNO = studentNO;
		this.studentName = studentName;
		this.studentAddr = studentAddr;
		this.departmentNO = departmentNO;
		this.departmentName = departmentName;
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
	public String getDepartmentNO() {
		return departmentNO;
	}
	public void setDepartmentNO(String departmentNO) {
		this.departmentNO = departmentNO;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "StudentVO [studentNO=" + studentNO + ", studentName=" + studentName + ", studentAddr=" + studentAddr
				+ ", departmentNO=" + departmentNO + ", departmentName=" + departmentName + "]";
	}

}