package servlet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import config.ServerInfo;

public class UserDAO implements UserDAOTemplate {

	public static void main(String[] args) {

		UserDAO dao = new UserDAO();

	}
	
	public UserDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

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
	public void insertUser(UserVO vo) throws SQLException {
		Connection conn = getConnection();
		
		
		String query = "INSERT INTO USER_INFO VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getUserId());
		ps.setString(2, vo.getUserPwd());
		ps.setString(3, vo.getUserName());
		ps.setString(4, vo.getUserNickname());
		ps.setString(5, String.valueOf(vo.getGender()));
		ps.setString(6, vo.getPlace());
		ps.setString(7, vo.getPhone());
		ps.setString(8, vo.getEmail());
		ps.setString(9, vo.getProfileImg());
		ps.setString(10, vo.getStatusMessage());
		ps.setString(11, String.valueOf(vo.getLover()));
		ps.setString(12, vo.getBloodType());
		ps.setString(13, vo.getMbti());
		ps.setString(14, vo.getBirthday());
		ps.setInt(16, vo.getUserLike());
		ps.setString(17, String.valueOf(vo.getUserAddmin()));
		ps.setString(18, String.valueOf(vo.getWithdrawal()));
		
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<UserVO> showAllUser() throws SQLException {
		Connection conn = getConnection();

		String member = "SELECT * FROM USER_INFO";
		PreparedStatement ps = conn.prepareStatement(member);
		ResultSet rs = ps.executeQuery();

		ArrayList<UserVO> list = new ArrayList<>();

		while (rs.next()) {

			list.add(new UserVO(rs.getString("name"), rs.getInt("age"), rs.getString("addr")));
		}

		closeAll(rs, ps, conn);
		return list;
		return null;
	}

	@Override
	public ArrayList<UserVO> searchUser() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
