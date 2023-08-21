package member.controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class FindController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String addr = request.getParameter("addr");
		
		String[] list1 = request.getParameterValues("checkId");
		
		String path = "views/find_fail.jsp";
		
		MemberVO vo = new MemberVO();
		if(id!="") vo.setId(id);
		if(addr!="") vo.setAddr(addr);
		
		List<MemberVO> list = new MemberService().findByIdMember(list1);
		
		if(list!=null) {
			request.setAttribute("list", list);
			path = "views/allShow.jsp";
			
		}
		
		return new ModelAndView(path);
	}
	
}
