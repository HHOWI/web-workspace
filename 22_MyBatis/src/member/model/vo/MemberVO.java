package member.model.vo;

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String addr;
	
	public MemberVO() {}
	public MemberVO(String id, String pwd, String name, String addr) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.addr = addr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", addr=" + addr + "]";
	}
}
