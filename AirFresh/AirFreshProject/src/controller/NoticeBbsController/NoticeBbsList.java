package controller.NoticeBbsController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.impl.NoticeBbsDao;
import Dto.NoticeBbsDto;
import projectutil.ProjectUtil;
import singleton.singleton;
@WebServlet("/noticelist")
public class NoticeBbsList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}
	
	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String opt = req.getParameter("opt");
		String keyword = req.getParameter("keyword");
		String spageNumber = req.getParameter("pageNumber");
		
		String command = req.getParameter("command");
		
		int pageNumber = 0;
		if(spageNumber != null && !spageNumber.equals("")){
			pageNumber = Integer.parseInt(spageNumber);
		}

		if (opt == null || opt.equals("")) {
			opt = "sel";
		}
		// 검색어를 지정하지 않고 choice가 넘어 왔을 때
		if (opt.equals("sel")) {
			keyword = "";
		}
		if (keyword == null) {
			keyword = "";
			opt = "sel";
		}
		
		singleton s = singleton.getInstance();
		//List<NoticeBbsDto> list = s.nbsi.getNoticeList();
		//List<NoticeBbsDto> list = s.nbsi.getNoticeList(opt, keyword);
		if(command.contentEquals("user")) {
			
			List<NoticeBbsDto> list = s.nbsi.getNoticeUser(opt, keyword, pageNumber);
			int len = s.nbsi.getUserLength(opt, keyword);
			req.setAttribute("len", len);
			req.setAttribute("noticeList", list);
			ProjectUtil.forward("./client_view/board/noticelist.jsp", req, resp);
			
		} else if(command.contentEquals("admin")){
			
			List<NoticeBbsDto> list = s.nbsi.getNoticePaging(opt, keyword, pageNumber);
			int len = s.nbsi.getAllBbsLength(opt, keyword);
			req.setAttribute("noticeList", list);
			req.setAttribute("len", len);
			ProjectUtil.forward("./admin_view/board/noticelist.jsp", req, resp);
		}
	}

}
