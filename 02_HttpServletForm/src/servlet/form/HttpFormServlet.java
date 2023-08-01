package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet
 */
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 한글처리..양방향!
		 * */
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String[] menuList = request.getParameterValues("menu");
		String gender = request.getParameter("gender");
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p> ID : " + id + "</p>");
		out.println("<p> PASSWORD : " + pwd + "</p>");
		out.println("<p> 성별 : " + (gender.equals("M") ? "남자" : "여자") + "</p>");
		out.println("<ul>");
		for(String menu : menuList) {
			out.println("<li>" + menu + "</li>");
		}
		out.println("<p> 메뉴 : " + Arrays.toString(menuList) + "</p>");
		out.println("</body></html>");
		out.close();
	}

}
