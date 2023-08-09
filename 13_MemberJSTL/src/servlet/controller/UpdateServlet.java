package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setAddr(addr);
		
		try {
			MemberDAO.getInstance().updateMember(dto.getId(), dto.getPwd(), dto.getName(), dto.getAddr());
			
			HttpSession session = request.getSession();
			if(session.getAttribute("dto")!=null) {
				session.setAttribute("dto", dto);
			}
			
			request.getRequestDispatcher("views/update_result.jsp").forward(request, response);
		} catch (SQLException e) {}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
