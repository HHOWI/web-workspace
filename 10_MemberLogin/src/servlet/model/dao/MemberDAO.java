package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberDTO;

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
	public void registerMember(MemberDTO dto) throws SQLException {
		Connection conn = getConnection();

		String query = "INSERT INTO MEMBER VALUES(?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, dto.getId());
		ps.setString(2, dto.getPwd());
		ps.setString(3, dto.getName());
		ps.setString(4, dto.getAddr());

		ps.executeUpdate();
		
		closeAll(ps, conn);
	}

	@Override
	public MemberDTO login(String id, String pwd) throws SQLException {
		Connection conn = getConnection();
		MemberDTO dto = null;

		String query = "SELECT* FROM MEMBER WHERE ID=? AND PWD=? ";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, id);
		ps.setString(2, pwd);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			dto = new MemberDTO();
			
			dto.setId(rs.getString("id"));
			dto.setPwd(rs.getString("pwd"));
			dto.setName(rs.getString("name"));
			dto.setAddr(rs.getString("addr"));
		}

		closeAll(rs, ps, conn);
		return dto;
	}

	@Override
	public MemberDTO findByIdMember(String id) throws SQLException {
		Connection conn = getConnection();
		MemberDTO dto = new MemberDTO();

		String query = "SELECT* FROM MEMBER WHERE ID=?";
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			dto.setId(rs.getString("id"));
			dto.setPwd(rs.getString("pwd"));
			dto.setName(rs.getString("name"));
			dto.setAddr(rs.getString("addr"));

			return dto;

		}
		closeAll(rs, ps, conn);

		return null;
	}

	@Override
	public ArrayList<MemberDTO> showAllMember() throws SQLException {
		Connection conn = getConnection();
		
		ArrayList<MemberDTO> list = new ArrayList<>();

		String query = "SELECT* FROM MEMBER";
		PreparedStatement ps = conn.prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPwd(rs.getString("pwd"));
			dto.setName(rs.getString("name"));
			dto.setAddr(rs.getString("addr"));

			list.add(dto);
		}
		closeAll(rs, ps, conn);
		return list;
	}

}
