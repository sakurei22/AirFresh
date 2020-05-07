package controller.MemberController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDto;
import projectutil.ProjectUtil;
import singleton.singleton;

@WebServlet("/adminMemList")
public class AdminMemList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}
	
	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		singleton s = singleton.getInstance();
		String spageNumber = req.getParameter("pageNumber");
		
		int pageNumber = 0;
		if(spageNumber != null && !spageNumber.equals("")){
			pageNumber = Integer.parseInt(spageNumber);
			System.out.println("pageNumber:"+pageNumber);
		}
		
		List<MemberDto> list = s.ms.getAdminMemList(pageNumber);
		int len = s.ms.getMemLength();
		req.setAttribute("adminMember", list);
		req.setAttribute("memberlen", len);
		ProjectUtil.forward("./admin_view/manageMem/adminMemberList.jsp", req, resp);
		
	}
}
