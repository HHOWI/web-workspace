package servlet.model.vo;

/*
 * VO(Value Object), DTO(Data Transfer Object) : 데이터 전송 및 저장 객체
 * - getter/setter만 가지는 것을 DTO 
 * - 실상 구별 없이 사용 
 * */

public class MemberDTO {

	private String id;
	private String pwd;
	private String name;
	private String addr;

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

}
