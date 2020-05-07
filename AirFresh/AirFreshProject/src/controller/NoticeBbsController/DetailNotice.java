package controller.NoticeBbsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.NoticeBbsDto;
import projectutil.ProjectUtil;
import singleton.singleton;

@WebServlet("/noticedetail")
public class DetailNotice extends HttpServlet {

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
		int noti_index = Integer.parseInt(req.getParameter("noti_index"));
		String command = req.getParameter("command");
		
		singleton s = singleton.getInstance();
		s.nbsi.readcount(noti_index);
		
		if(command.contentEquals("admin")) {
			NoticeBbsDto notice = s.nbsi.getNoticeBbs(noti_index);
			req.setAttribute("noticeBbs", notice);
		
			ProjectUtil.forward("./admin_view/board/noticedetail.jsp", req, resp);
			
		} else if(command.contentEquals("user")) {
			NoticeBbsDto notice = s.nbsi.getNoticeBbs(noti_index);
			req.setAttribute("noticeBbs", notice);
		
			ProjectUtil.forward("./client_view/board/noticedetail.jsp", req, resp);
		}
		
	}
	
	
	
}
