package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;
import servlet.model.vo.MemberVO;

@WebServlet(urlPatterns = "/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청이 어디에서 들어오는 요청인지.. command값 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp";

		try {
			if (command.equals("register")) {
				path = register(request, response);
			} else if (command.equals("login")) {
				path = login(request, response);
			} else if (command.equals("findMember")) {
				path = findMember(request, response);
			} else if (command.equals("update")) {
				path = update(request, response);
			} else if (command.equals("allMember")) {
				path = allMember(request, response);
			} else if (command.equals("logout")) {
				path = logout(request, response);
			}
		} catch (SQLException e) {
		}

		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// 폼값 받아오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");

		// 객체에 담기
		MemberVO vo = new MemberVO(id, pwd, name, addr);

		// DAO와 연결
		MemberDAO.getInstance().registerMember(vo);

		return "index.jsp";
	}

	protected String allMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember();
		request.setAttribute("list", list);

		return "views/allShow.jsp";
	}

	protected String findMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");

		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		if (vo != null) {
			request.setAttribute("vo", vo);
			return "views/find_ok.jsp";
		} else {
			return "view/find_fail.jsp";
		}
	}

	protected String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberVO vo = MemberDAO.getInstance().login(id, pwd);

		HttpSession session = request.getSession();
		session.setAttribute("vo", vo);

		return "views/login_result.jsp";

	}

	protected String update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");

		MemberVO vo = new MemberVO(id, pwd, name, addr);

		MemberDAO.getInstance().updateMember(vo.getId(), vo.getPwd(), vo.getName(), vo.getAddr());

		HttpSession session = request.getSession();
		if (session.getAttribute("vo") != null) {
			session.setAttribute("vo", vo);
		}

		return "views/update_result.jsp";

	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("vo")!=null) {
		session.invalidate();
		return "views/logout.jsp";
		}
		return "index.jsp";
	}
}
	
