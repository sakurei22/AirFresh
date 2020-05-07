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

@WebServlet("/delAsApp")
public class DeleteAsApplication extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		System.out.println("delAsApp도착 seq: "+seq);
		
		
		int as_index = Integer.parseInt(seq);
		
		singleton s = singleton.getInstance();
		boolean isS = s.asi.deleteAsApp(as_index);
		
		if(isS) {
			System.out.println("삭제성공");
		} else {
			System.out.println("삭제실패");
		}
		
		HttpSession session = req.getSession();
		MemberDto mem = (MemberDto) session.getAttribute("login");
		String mem_id = mem.getMem_id();
		 
		List<AsAppDto> list = s.asi.memAsAppList(mem_id);
		System.out.println("list size: "+list.size());
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("./client_view/as/asapplist.jsp").forward(req, resp);
	}

}
