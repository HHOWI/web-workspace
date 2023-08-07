package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDAO dao = new MemberDAO();

		// 폼값 받아오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");

		MemberDTO dto = new MemberDTO();

		// 객체에 담기
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setAddr(addr);

		try {
			// DAO와 연결
			dao.registerMember(dto);

			// 데이터 바인딩
			session.setAttribute("dto", dto);

			// 네비게이션
			response.sendRedirect("AllMemberServlet");
		} catch (SQLException e) {
			System.out.println("회원가입 실패!");
			response.sendRedirect("../index.html");
		}
	
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
