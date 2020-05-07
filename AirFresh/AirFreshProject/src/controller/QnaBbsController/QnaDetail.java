package controller.QnaBbsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.QnaBbsDto;
import projectutil.ProjectUtil;
import singleton.singleton;
@WebServlet("/qnadetail")
public class QnaDetail extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.processFunc(req, resp);
	}
	
	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		req.setCharacterEncoding("utf-8");
		int qna_index = Integer.parseInt(req.getParameter("qna_index"));
		String command = req.getParameter("command");
		singleton s = singleton.getInstance();
		
		if(command.contentEquals("user")) {
			QnaBbsDto qna = s.qbs.getQnaBbs(qna_index);
			req.setAttribute("qnadto", qna);
			ProjectUtil.forward("./client_view/board/qnadetail.jsp", req, resp);
		
		} else if(command.contentEquals("admin")) {
			
			QnaBbsDto qna = s.qbs.getQnaBbs(qna_index);
			System.out.println(qna.toString());
			req.setAttribute("qnadto", qna);
			ProjectUtil.forward("./admin_view/board/qnadetail.jsp", req, resp);
		}
		
	}
}
