package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		MemberVO vo = new MemberVO(id, pwd, name, addr);
		MemberDAO.getInstance().updateMember(id, pwd, name, addr);
		
		request.setAttribute("vo", vo);
		
		String path = "views/update_result.jsp";
		
		return new ModelAndView(path);
	}

}
