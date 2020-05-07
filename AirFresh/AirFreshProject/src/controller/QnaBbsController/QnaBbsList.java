package controller.QnaBbsController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.QnaBbsDto;
import projectutil.ProjectUtil;
import singleton.singleton;

@WebServlet("/qnalist")
public class QnaBbsList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}
	
	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		String command = req.getParameter("command");
		String opt = req.getParameter("opt");
		String keyword = req.getParameter("keyword");
		String spageNumber = req.getParameter("pageNumber");
		System.out.println(opt);
		System.out.println(keyword);
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
		if(command.contentEquals("user")) {
			List<QnaBbsDto> list = s.qbs.getQnaPaging(opt, keyword, pageNumber);
			int len = s.qbs.getAllQnaLength(opt, keyword);
			req.setAttribute("len", len);
			req.setAttribute("qnalist", list);
			ProjectUtil.forward("./client_view/board/qnalist.jsp", req, resp);
			
			//TODO qnapersonallist.jsp mypage.jsp
			/*
			 * } else if(command.contentEquals("personal")) { List<QnaBbsDto> list =
			 * s.qbs.getQnaPaging(opt, keyword, pageNumber); int len =
			 * s.qbs.getAllQnaLength(opt, keyword); req.setAttribute("len", len);
			 * req.setAttribute("qnalist", list);
			 * ProjectUtil.forward("./client_view/board/qnalist.jsp", req, resp);
			 */
			
		} else if(command.contentEquals("admin")) {
			List<QnaBbsDto> list = s.qbs.getQnaPaging(opt, keyword, pageNumber);
			int len = s.qbs.getAllQnaLength(opt, keyword);
			req.setAttribute("len", len);
			req.setAttribute("qnalist", list);
			ProjectUtil.forward("./admin_view/board/qnalist.jsp", req, resp);
		}
		
	}
}
