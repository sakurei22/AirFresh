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

@WebServlet("/updatemem")
public class UpdateMem extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		processFunc(req, resp);
	}

	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("UpdateMem 도착");
		
		String command = req.getParameter("command");
		System.out.println(command);
		singleton s = singleton.getInstance();
		
		if(command.equals("update")) {
			String id = req.getParameter("id");
			//String pw = req.getParameter("pw");								
			MemberDto mem = s.ms.getMem(id);	// s.ms.memLogin(id, pw);	
			req.getSession().setAttribute("login", mem);			
			forward("./client_view/member/update.jsp", req, resp);			
		}		
		else if(command.equals("upview")) {
			resp.sendRedirect(req.getContextPath() + "/client_view/member/update.jsp");
		}else if(command.equals("updateAf")) {
			
			
			String _id = req.getParameter("mem_id");
			String _pw = req.getParameter("mem_pw");				
			String _cell = req.getParameter("mem_cell"); 		
			String _addr1 = req.getParameter("mem_addr1");
			String _addr2 = req.getParameter("mem_addr2");
			String _addr3 = req.getParameter("mem_addr3");		
			
			System.out.println(_id + " " + _pw + " " + _cell + " " +  
					_addr1 + " " + _addr2 + " " + _addr3 + " ");
						
			MemberDto dto = new MemberDto(_id, _pw, _cell, _addr1, _addr2, _addr3);
			
			boolean isS = s.ms.updateMem(_id, dto);
			System.out.println("UpdateMem 도착2");							
			resp.sendRedirect(req.getContextPath() + "/client_view/member/finding.jsp?command=update&isS=" + isS);	
		}
	}	
	
	public static void forward(String link, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		RequestDispatcher dispatch = req.getRequestDispatcher(link);
		dispatch.forward(req, resp);		
	}
	
}
