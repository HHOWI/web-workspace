package servlet.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import servlet.model.dao.MemberRepository;
import servlet.model.vo.MemberVO;

public class MemberService  {
	private MemberRepository repo = new MemberRepository();
	
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		return repo.showAllMember();
	}
}
