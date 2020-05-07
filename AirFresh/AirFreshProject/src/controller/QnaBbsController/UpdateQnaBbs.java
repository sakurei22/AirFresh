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
@WebServlet("/updateqnabbs")
public class UpdateQnaBbs extends HttpServlet {
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
		
		
		if(command.contentEquals("admin")) {
			qna_index = Integer.parseInt(req.getParameter("qna_index"));
			String re_content = req.getParameter("re_content");
			boolean isS = s.qbs.reComentQna(qna_index, re_content);
			resp.sendRedirect(req.getContextPath() + "/admin_view/board/finding.jsp?command=qnare&isS="+isS+"&qna_index="+qna_index);
			
		} else if(command.contentEquals("user")) {
			qna_index = Integer.parseInt(req.getParameter("qna_index"));
			QnaBbsDto qna = s.qbs.getQnaBbs(qna_index);
			req.setAttribute("qnadto", qna);
			ProjectUtil.forward("./client_view/board/qnaupdate.jsp", req, resp);
			
		} else if(command.contentEquals("qnaUpdateAf")) {
			qna_index = Integer.parseInt(req.getParameter("qna_index"));
			String qna_title = req.getParameter("qna_title");
			String qna_content = req.getParameter("qna_content");
			String secret = req.getParameter("secret");
			
			int qna_secret = 0;
			if(secret!=null) {
				qna_secret = 1;
			}
			
			boolean isS = s.qbs.userUpdate(new QnaBbsDto(qna_index, qna_title, qna_content, qna_secret));
			resp.sendRedirect(req.getContextPath() + "/client_view/board/qnaAf.jsp?command=qnaUpdateAf&isS="+isS+"&qna_index="+qna_index);
		} else if(command.contentEquals("adminUpdate")) {
			qna_index = Integer.parseInt(req.getParameter("qna_index"));
			QnaBbsDto qna = s.qbs.getQnaBbs(qna_index);
			req.setAttribute("qnadto", qna);
			ProjectUtil.forward("./admin_view/board/qnaupdate.jsp", req, resp);
			
		} else if(command.equals("adminUpdateAf")) {
			qna_index = Integer.parseInt(req.getParameter("qna_index"));
			String secret = req.getParameter("secret");
			System.out.println(secret);
			int qna_secret = 0;
			if(secret!=null) {
				qna_secret = 1;
			}
			boolean isS = s.qbs.adminUpdate(qna_index, qna_secret);
			resp.sendRedirect(req.getContextPath() + "/admin_view/board/finding.jsp?command=qnaAdminUpdate&isS="+isS+"&qna_index="+qna_index);

			
			
		}
		
	}
}
