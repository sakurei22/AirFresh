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

@WebServlet("/memlogin")
public class MemLogin extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		this.processFunc(req, resp);
	}

	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("memlogin 도착");	// ok!
		
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw");

		System.out.println("id:" + mem_id + " pw:" + mem_pw);
		
		singleton s = singleton.getInstance();
				
		MemberDto mem = s.ms.memLogin(mem_id, mem_pw);		
		req.getSession().setAttribute("login", mem);
		req.getSession().setMaxInactiveInterval(60*60*356);
		System.out.println("memlogin 도착2");		// ok!
		forward("./client_view/member/loginAf.jsp", req, resp);
	
	}
	
	public static void forward(String link, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);		
	}

	

}
