package controller.NoticeBbsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.NoticeBbsDto;
import singleton.singleton;

@WebServlet("/noticedelete")
public class DeleteNotice extends HttpServlet {

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
		req.setCharacterEncoding("utf-8");
		String command = req.getParameter("command");
		if(command.contentEquals("oneDelete")) {
			int noti_index = Integer.parseInt(req.getParameter("noti_index"));
			
			boolean isS = s.nbsi.deleteNotice(noti_index);
			
			resp.sendRedirect(req.getContextPath() + "/admin_view/board/finding.jsp?command=delete&isS="+isS);
		
		} else if(command.contentEquals("multiDelete")) {
			String qnaIndex[] = req.getParameterValues("delck");
			boolean isS = s.nbsi.multiDelNotice(qnaIndex);
			
			resp.sendRedirect(req.getContextPath() + "/admin_view/board/finding.jsp?command=multiDelete&isS="+isS);
		}
	}
	
	
	
}
