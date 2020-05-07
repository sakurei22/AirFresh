package controller.MemberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDto;
import singleton.singleton;

@WebServlet("/delmem")
public class DelMem extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		this.processFunc(req, resp);
	}

	protected void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String command = req.getParameter("command");
		System.out.println(command);	
		singleton s = singleton.getInstance();
		
		if(command.equals("signout")) {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			MemberDto mem = s.ms.memLogin(id, pw);
			req.getSession().setAttribute("login", mem);
			forward("./client_view/member/delete.jsp", req, resp);					
		}else if(command.equals("deleteAf")) {
			String _id = req.getParameter("mem_id");
			String _pw = req.getParameter("mem_pw");
			
			System.out.println(_id + "" + _pw);
						
			boolean isS = s.ms.delMem(_id, _pw);			
			resp.sendRedirect(req.getContextPath() + "/client_view/member/finding.jsp?command=delete&isS=" + isS);						
			
		}
	}	
	
	public static void forward(String link, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);		
	}
	
	
	
}
