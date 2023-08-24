package grade.model.vo;

public class ManagerVO {
	private int managerNumber;
	private String managerName;
	private String managerHireDate;
	public ManagerVO() {
		// TODO Auto-generated constructor stub
	}
	public ManagerVO(int managerNumber, String managerName, String managerHireDate) {
		this.managerNumber = managerNumber;
		this.managerName = managerName;
		this.managerHireDate = managerHireDate;
	}
	public int getManagerNumber() {
		return managerNumber;
	}
	public void setManagerNumber(int managerNumber) {
		this.managerNumber = managerNumber;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerHireDate() {
		return managerHireDate;
	}
	public void setManagerHireDate(String managerHireDate) {
		this.managerHireDate = managerHireDate;
	}
	@Override
	public String toString() {
		return "ManagerVO [managerNumber=" + managerNumber + ", managerName=" + managerName + ", managerHireDate="
				+ managerHireDate + "]";
	}
	
}
