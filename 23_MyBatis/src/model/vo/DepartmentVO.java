package model.vo;

public class DepartmentVO {
	private String departmentNO;
	private String departmentName;
	private String category;

	public DepartmentVO() {
		// TODO Auto-generated constructor stub
	}

	public DepartmentVO(String departmentNO, String departmentName, String category) {
		this.departmentNO = departmentNO;
		this.departmentName = departmentName;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "DepartmentVO [departmentNO=" + departmentNO + ", departmentName=" + departmentName + ", category="
				+ category + "]";
	}
}