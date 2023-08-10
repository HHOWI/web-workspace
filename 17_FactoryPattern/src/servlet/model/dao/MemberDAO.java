package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberVO;

public class MemberDAO implements MemberDAOTemplate {

	public static void main(String[] args) {

	}

	// 싱글톤 패턴 - 클래스의 객체가 항상 하나만 존재하도록
	/*
	 * DAO를 반복적으로 생성하고 해제하는 것은 비효율적
	 * 객체지향적 설계! 싱글톤 패턴은 객체지향적 설계 원칙을 준수 -> 중앙에서 처리!
	 * 주의할 점은 싱글톤은 전역 상태를 가질 수 있으므로 오남용하면 애플리케이션의 복잡성이 증가
	 * */
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
	}
	public static MemberDAO getInstance() {
		return dao;
	}
	
//	public MemberDAO() {
//		try {
//			Class.forName(ServerInfo.DRIVER_NAME);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		Connection conn = getConnection();

		String query = "INSERT INTO MEMBER VALUES(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPwd());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddr());

		ps.executeUpdate();
		
		closeAll(ps, conn);
	}

	@Override
	public MemberVO login(String id, String pwd) throws SQLException {
		Connection conn = getConnection();
		MemberVO vo = null;

		String query = "SELECT* FROM MEMBER WHERE ID=? AND PWD=? ";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, id);
		ps.setString(2, pwd);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			vo = new MemberVO();
			
			vo.setId(rs.getString("id"));
			vo.setPwd(rs.getString("pwd"));
			vo.setName(rs.getString("name"));
			vo.setAddr(rs.getString("addr"));
		}

		closeAll(rs, ps, conn);
		return vo;
	}

	@Override
	public MemberVO findByIdMember(String id) throws SQLException {
		Connection conn = getConnection();
		MemberVO vo = new MemberVO();

		String query = "SELECT* FROM MEMBER WHERE ID=?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			vo.setId(rs.getString("id"));
			vo.setPwd(rs.getString("pwd"));
			vo.setName(rs.getString("name"));
			vo.setAddr(rs.getString("addr"));

			return vo;

		}
		closeAll(rs, ps, conn);

		return null;
	}

	@Override
	public ArrayList<MemberVO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		
		ArrayList<MemberVO> list = new ArrayList<>();

		String query = "SELECT* FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			MemberVO vo = new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPwd(rs.getString("pwd"));
			vo.setName(rs.getString("name"));
			vo.setAddr(rs.getString("addr"));

			list.add(vo);
		}
		closeAll(rs, ps, conn);
		return list;
	}
	
	public void updateMember(String id, String pwd, String name, String addr) throws SQLException {
		Connection conn = getConnection();
		
		String query = "UPDATE MEMBER SET PWD = ?, NAME = ?, ADDR = ? WHERE ID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, pwd);
		ps.setString(2, name);
		ps.setString(3, addr);
		ps.setString(4, id);
		
		ps.executeUpdate();
		
		closeAll(ps, conn);
	}
}
