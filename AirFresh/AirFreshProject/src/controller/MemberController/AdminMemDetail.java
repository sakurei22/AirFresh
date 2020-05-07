package controller.MemberController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDto;
import projectutil.ProjectUtil;
import singleton.singleton;

@WebServlet("/adminMemDetail")
public class AdminMemDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mem_id = req.getParameter("mem_id");
		System.out.println("adminMemDetail 도착 mem_id : "+mem_id);
	
		singleton s = singleton.getInstance();
		MemberDto dto = s.ms.getMem(mem_id);
		
		req.setAttribute("dto", dto);
		ProjectUtil.forward("./admin_view/manageMem/memDetail.jsp", req, resp);
	
	}

}
