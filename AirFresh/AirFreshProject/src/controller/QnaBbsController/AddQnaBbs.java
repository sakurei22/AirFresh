package controller.QnaBbsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.QnaBbsDto;
import singleton.singleton;
@WebServlet("/addQna")
public class AddQnaBbs extends HttpServlet {
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
		
		if(command.contentEquals("add")) {
			resp.sendRedirect(req.getContextPath()+"/client_view/board/qna_write.jsp");
			
		} else if(command.contentEquals("addAf")) {
			String mem_id = req.getParameter("mem_id");
			String qna_title = req.getParameter("qna_title");
			String qna_content = req.getParameter("qna_content");
			String secret = req.getParameter("secret");
			
			int qna_secret = 0;
			if(secret!=null) {
				qna_secret = 1;
			}
			
			singleton s = singleton.getInstance();
			boolean isS = s.qbs.addQna(new QnaBbsDto(mem_id, qna_title, qna_content, qna_secret));
			resp.sendRedirect(req.getContextPath() + "/client_view/board/qnaAf.jsp?command=add&isS="+isS);
		}
		
	}
}
