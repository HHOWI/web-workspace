package servlet.controlloer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age"));
//		String addr = request.getParameter("addr");

		/*
		 * 1. Attribute에 바인딩된 데이터를 받아와서 
		 * 2. 웹브라우저로 출력하는 로직을 작성..
		 */
		// 1. Attribute에 바인딩된 데이터를 받아와서
		context = getServletContext();
		
		// 2. 웹브라우저로 출력하는 로직을 작성..
		MemberVO vo = (MemberVO) context.getAttribute("vo");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
