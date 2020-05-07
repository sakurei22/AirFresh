package controller.MemberController;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import singleton.singleton;

@WebServlet("/findidpw")
public class FindIDPW extends HttpServlet {

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
		System.out.println("FindIDPW 도착");	// ok!
		String command = req.getParameter("command");		
		String _name = req.getParameter("mem_name");
		String _cell = req.getParameter("mem_cell");
		String _id = req.getParameter("mem_id");
				
		System.out.println(command);
		
		singleton s = singleton.getInstance();
		
		if(command.equals("searchidpw")) {
			resp.sendRedirect(req.getContextPath() + "/client_view/member/searchidpw.jsp");
		}
		else if(command.equals("FID")) {	
			System.out.println(_name + " " + _cell);
			String id = s.ms.findID(_name, _cell);			
			System.out.println("FindID 도착2");
			System.out.println("id:" + id);
			if(id != null && !id.equals("")) {
				String idx = URLEncoder.encode(id);					
				resp.sendRedirect(req.getContextPath() + "/client_view/member/finding.jsp?command=findi&id=" + idx);
			}else if(id == null || id.equals("")){					
				resp.sendRedirect(req.getContextPath() + "/client_view/member/finding.jsp?command=findi&id=" + id);
			}
		}
		else if(command.equals("FPW")) {				
			System.out.println(_id + " " + _name);
			String pw = s.ms.findPW(_id, _name);					
			System.out.println("FindPW 도착2");
			System.out.println("pw:" + pw);
			if(pw != null && !pw.equals("")) {
				String pwx = URLEncoder.encode(pw);									
				resp.sendRedirect(req.getContextPath() + "/client_view/member/finding.jsp?command=findp&pw=" + pwx);
			}else if(pw == null || pw.equals("")){
				resp.sendRedirect(req.getContextPath() + "/client_view/member/finding.jsp?command=findp&pw=" + pw);
			}
		}		
	}
	
}
