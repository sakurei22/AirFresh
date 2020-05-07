package controller.QnaBbsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.QnaBbsDto;
import singleton.singleton;
@WebServlet("/qnadelete")
public class QnaDelete extends HttpServlet {
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
		String command = req.getParameter("command");
		singleton s = singleton.getInstance();
		int qna_index = 0;
		if(command.contentEquals("user")) {
			qna_index = Integer.parseInt(req.getParameter("qna_index"));
			
			boolean isS = s.qbs.qnaDelete(qna_index);
			resp.sendRedirect(req.getContextPath() + "/client_view/board/qnaAf.jsp?command=qnaDeleteAf&isS="+isS+"&qna_index="+qna_index);

		} else if(command.contentEquals("admin")) {
			qna_index = Integer.parseInt(req.getParameter("qna_index"));
			
			boolean isS = s.qbs.qnaDelete(qna_index);
			resp.sendRedirect(req.getContextPath() + "/admin_view/board/finding.jsp?command=qnaDeleteAf&isS="+isS+"&qna_index="+qna_index);

		}
	}
}
