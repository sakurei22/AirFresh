package controller.MemberController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDto;
import singleton.singleton;

@WebServlet("/addmem")
public class AddMem extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processFunc(req, resp);
		
	}//end do post 

	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("AddMem 도착");
		
		String command = req.getParameter("command");
		System.out.println(command);		

		if(command.equals("regi")) {	// 회원가입 전 약관동의
			resp.sendRedirect(req.getContextPath() + "/client_view/member/terms.jsp");
		}
		if(command.equals("siteterms")) {	// AirFresh몰 이용약관			
			resp.sendRedirect(req.getContextPath() + "/client_view/member/siteterms.jsp");
		}
		else if(command.equals("infoterms")) {	// 개인정보 수집/이용안내
			resp.sendRedirect(req.getContextPath() + "/client_view/member/personalinfoterms.jsp");
		}
		else if(command.equals("puseterms")) {	// 개인 정보 수집/이용 동의
			resp.sendRedirect(req.getContextPath() + "/client_view/member/privacyuseterms.jsp");
		}
		else if(command.equals("register")) {	// 넘겨받는 값 없이 회원가입
			resp.sendRedirect(req.getContextPath() + "/client_view/member/register.jsp");
		}
		else if(command.equals("addAf")) {
			String _id = req.getParameter("mem_id");		
			String _pw = req.getParameter("mem_pw");		
			String _name = req.getParameter("mem_name");		
			String _cell = req.getParameter("mem_cell"); 
			String _birth = req.getParameter("mem_birth"); 
			String _addr1 = req.getParameter("mem_addr1");
			String _addr2 = req.getParameter("mem_addr2");
			String _addr3 = req.getParameter("mem_addr3");			
					
			System.out.println(_id + " " + _pw + " " + _name + " " + _cell + " " + _birth + " " + 
								_addr1 + " " + _addr2 + " " + _addr3);
			
			singleton s = singleton.getInstance();
			
			MemberDto dto = new MemberDto(_id, _pw, _name, _cell, _birth, _addr1,
					_addr2, _addr3, 3);
			
			System.out.println("AddMem 도착2");				
			
			boolean isS = s.ms.addMem(dto);
			
			resp.sendRedirect(req.getContextPath() + "/client_view/member/finding.jsp?command=register&isS=" + isS);			
		}
	}				
	
}
