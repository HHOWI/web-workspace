package servlet.controller.component;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		
		PrintWriter out = response.getWriter();
		
		if(vo!=null) {
			
			out.print("<h3> ID 사용 불가!</h3>");
			
		} else {
			
			out.print("<h3> ID 사용 가능!</h3>");
			
		}
		
		return null;
	}

}
