package controller.AsController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.AsAppDto;
import Dto.MemberDto;
import singleton.singleton;


@WebServlet("/printAsApp")
public class PrintAsApplication extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		System.out.println("printAsApplication 도착");
		
		
		HttpSession session = req.getSession();
		
		
		if(req.getSession().getAttribute("login") == null) {
			//비로그인 상태   ---> 로그인 페이지로 이동 
			resp.sendRedirect(req.getContextPath() + "/client_view/member/login.jsp");
			
		}else {
			MemberDto mem = (MemberDto) session.getAttribute("login");
			//String mem_id = req.getParameter("id");
			String mem_id = mem.getMem_id();
			System.out.println("printAsApp mem_id: "+mem_id);
			
			singleton s = singleton.getInstance();
			List<AsAppDto> list = s.asi.memAsAppList(mem_id);
			System.out.println("list size: "+list.size());
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("./client_view/as/asapplist.jsp").forward(req, resp);
		}
	}

}
